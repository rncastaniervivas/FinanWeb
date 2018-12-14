package ar.edu.unlam.tallerweb1.servicios;

import java.util.Date;
import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.unlam.tallerweb1.dao.CajaDao;
import ar.edu.unlam.tallerweb1.dao.CuotaDao;
import ar.edu.unlam.tallerweb1.dao.RegistroDao;
import ar.edu.unlam.tallerweb1.modelo.Caja;
import ar.edu.unlam.tallerweb1.modelo.Cuota;
import ar.edu.unlam.tallerweb1.modelo.Registro;

@Service("servicioRegistro")
@Transactional
public class ServicioRegistroImpl implements ServicioRegistro {
	
	@Inject
	private RegistroDao servicioRegistroDao;
	@Inject
	private CuotaDao servicioCuotaDao;
	
	@Inject
	private CajaDao servicioCajaDao;

	@Override
	public void insertarIngresos(Cuota cuotai ,Long idPrestamo, String nombreAfiliado) {
		Cuota miCuota=servicioCuotaDao.buscarCuota(cuotai);
		Registro registroi=new Registro();
		registroi.setCuota(miCuota.getIdCuota());
		registroi.setIngreso(fijarNumero(miCuota.getMonto(), 2) );
		registroi.setPrestamo(idPrestamo);
		registroi.setConcepto("cobro de cuotas");
		registroi.setOrigen(nombreAfiliado);
		
		registroi.setFecha(new Date());
		servicioRegistroDao.agregarRegistro(registroi);

	}

	@Override
	public void insertarIngresosPagoUnitario(Double pago,Long idPrestamo, String nombreAfiliado) {
		Registro registroi=new Registro();
		registroi.setCuota(0L);
		registroi.setIngreso(fijarNumero(pago, 2));
		registroi.setPrestamo(idPrestamo);
		registroi.setConcepto("cobro unitario");
		registroi.setOrigen(nombreAfiliado);		
		registroi.setFecha(new Date());
		servicioRegistroDao.agregarRegistro(registroi);

	}
	@Override
	public void insertarEgresos(Cuota cuotae,Long idPrestamo,String nombreFinanciera) {
		Cuota miCuota=servicioCuotaDao.buscarCuota(cuotae);
		Registro registroe=new Registro();
		registroe.setCuota(miCuota.getIdCuota());
		registroe.setEgreso(fijarNumero(miCuota.getMonto(), 2));
		registroe.setPrestamo(idPrestamo);
		registroe.setDestino(nombreFinanciera);
		registroe.setConcepto("pago de cuotas a financiera");
		registroe.setFecha(new Date());
		servicioRegistroDao.agregarRegistro(registroe);

	}

	@Override
	public List<Registro> consultarTodosRegistros(){
		return servicioRegistroDao.consultarRegistros();
	}

	
	@Override
	public Double montoDeIngresos() {
		List<Registro> ingresos=servicioRegistroDao.consultarIngresos();
		Double sumatoria = 0.0;
		for(Registro i: ingresos) {
			sumatoria+=i.getIngreso();
			
		}
		sumatoria=fijarNumero(sumatoria, 2);
		return sumatoria;
	}

	@Override
	public Double montoDeEgresos() {
		List<Registro> egresos=servicioRegistroDao.consultarEgresos();
		Double sumatoria = 0.0;
		for(Registro i: egresos) {
			sumatoria+=i.getEgreso();
		}
		sumatoria=fijarNumero(sumatoria, 2);
		return sumatoria;
	}

	@Override
	public List<Registro> consultarIngresos() {
	
		return servicioRegistroDao.consultarIngresos();
	}

	@Override
	public Double montoCaja() {
		Caja caja = servicioCajaDao.consultarCaja();
		double montoCaja = caja.getMonto();
		return fijarNumero(montoCaja + this.montoDeIngresos()-this.montoDeEgresos(),2);
	}

	@Override
	public List<Registro> consultarEgresos() {
		
		return servicioRegistroDao.consultarEgresos();
	}
	public static double fijarNumero(double numero, int digitos) {
        double resultado;
        resultado = numero * Math.pow(10, digitos);
        resultado = Math.round(resultado);
        resultado = resultado/Math.pow(10, digitos);
        return  resultado;
    }

}
