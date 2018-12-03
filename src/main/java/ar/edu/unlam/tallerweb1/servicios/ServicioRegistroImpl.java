package ar.edu.unlam.tallerweb1.servicios;

import java.util.Date;
import java.util.Calendar;
import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.unlam.tallerweb1.dao.CuotaDao;
import ar.edu.unlam.tallerweb1.dao.PrestamoDao;
import ar.edu.unlam.tallerweb1.dao.RegistroDao;
import ar.edu.unlam.tallerweb1.modelo.Caja;
import ar.edu.unlam.tallerweb1.modelo.Cuota;
import ar.edu.unlam.tallerweb1.modelo.Prestamo;
import ar.edu.unlam.tallerweb1.modelo.Registro;

@Service("servicioRegistro")
@Transactional
public class ServicioRegistroImpl implements ServicioRegistro {
	
	@Inject
	private RegistroDao servicioRegistroDao;
	@Inject
	private CuotaDao servicioCuotaDao;
	@Inject
	private PrestamoDao servicioPrestamoDao;
	

	@Override
	public void insertarIngresos(Cuota cuotai) {
		Cuota miCuota=servicioCuotaDao.buscarCuota(cuotai);
		Registro registroi=new Registro();
		registroi.setCuota(miCuota.getIdCuota());
		registroi.setIngreso(miCuota.getMontoTotal());
		registroi.setPrestamo(miCuota.getPrestamo().getIdPrestamo());
		registroi.setConcepto("cobro de cuotas");
		registroi.setOrigen(miCuota.getPrestamo().getAfiliado().getApellido());
		registroi.setEgreso(0.0);
		registroi.setFecha(new Date());
		servicioRegistroDao.agregarRegistro(registroi);

	}

	@Override
	public void insertarEgresos(Cuota cuotae) {
		Cuota miCuota=servicioCuotaDao.buscarCuota(cuotae);
		Prestamo mipres=servicioPrestamoDao.consultarPrestamoPorCuota(cuotae);
		Long id=mipres.getIdPrestamo();
		Registro registroe=new Registro();
		registroe.setCuota(miCuota.getIdCuota());
		registroe.setEgreso(miCuota.getMonto());
		registroe.setPrestamo(id);
//		registroe.setDestino(mipres.getFinanciera().getNombre());
		registroe.setConcepto("pago de cuotas a financiera");
		registroe.setIngreso(0.0);
		registroe.setFecha(new Date());
		servicioRegistroDao.agregarRegistro(registroe);

	}

	@Override
	public List<Registro> consultarTodosRegistros(){
		return servicioRegistroDao.consultarRegistros();
	}

	
	@Override
	public Double montoDeIngresos() {
		List<Registro> ingresos=servicioRegistroDao.consultarRegistros();
		Double sumatoria = 0.0;
		for(Registro i: ingresos) {
			sumatoria+=i.getIngreso();
			
		}
		
		return sumatoria;
	}

	@Override
	public Double montoDeEgresos() {
		List<Registro> egresos=servicioRegistroDao.consultarEgresos();
		Double sumatoria = 0.0;
		for(Registro i: egresos) {
			sumatoria+=i.getEgreso();
		}
		
		return sumatoria;
	}

	@Override
	public List<Registro> consultarIngresos() {
		
		return servicioRegistroDao.consultarIngresos();
	}

}
