package ar.edu.unlam.tallerweb1.servicios;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.unlam.tallerweb1.dao.RegistroDao;
import ar.edu.unlam.tallerweb1.modelo.Cuota;
import ar.edu.unlam.tallerweb1.modelo.Registro;

@Service("servicioRegistro")
@Transactional
public class ServicioRegistroImpl implements ServicioRegistro {
	
	@Inject
	private RegistroDao servicioRegistroDao;
	

	@Override
	public void insertarIngresos(Cuota cuotai) {
		Registro registroi=new Registro();
		registroi.setCuota(cuotai.getIdCuota());
		registroi.setIngreso(cuotai.getMontoTotal());
		registroi.setPrestamo(cuotai.getPrestamo().getIdPrestamo());
		registroi.setConcepto("cobro de cuotas");
		registroi.setOrigen(cuotai.getPrestamo().getAfiliado().toString());
		servicioRegistroDao.agregarRegistro(registroi);

	}

	@Override
	public void insertarEgresos(Cuota cuotae) {
		Registro registroe=new Registro();
		registroe.setCuota(cuotae.getIdCuota());
		registroe.setIngreso(cuotae.getMonto());
		registroe.setPrestamo(cuotae.getPrestamo().getIdPrestamo());
		registroe.setConcepto("pago de cuotas a financiera");
		registroe.setDestino(cuotae.getPrestamo().getFinanciera().toString());
		servicioRegistroDao.agregarRegistro(registroe);

	}

}
