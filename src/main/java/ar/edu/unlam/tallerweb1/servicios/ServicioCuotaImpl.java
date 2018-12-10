package ar.edu.unlam.tallerweb1.servicios;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.unlam.tallerweb1.dao.CuotaDao;
import ar.edu.unlam.tallerweb1.dao.PrestamoDao;
import ar.edu.unlam.tallerweb1.modelo.Confirmpagocuota;
import ar.edu.unlam.tallerweb1.modelo.Cuota;
import ar.edu.unlam.tallerweb1.modelo.Financiera;
import ar.edu.unlam.tallerweb1.modelo.Prestamo;

@Service("servicioCuota")
@Transactional
public class ServicioCuotaImpl implements ServicioCuota{
	
	@Inject
	private CuotaDao servicioCuotaDao;
	@Inject
	private PrestamoDao servicioPrestamoDao;
	
	@Override
	public Cuota consultarCuotaporId(Long idCuota){
		return servicioCuotaDao.consultarCuotaporId(idCuota);
	}
	
	@Override
	public List<Cuota> consultarCuotaPagada(Long arefinanciar){
		return servicioCuotaDao.consultarCuotaPagada(arefinanciar);
	}
	@Override
	public void pagarCuota(Confirmpagocuota confirm) {
		List<Long> idCuotas = new ArrayList<Long>();
		
		Cuota cuotaitem= new Cuota();
		
		for(String item: confirm.getCheck()) {
			idCuotas.add(Long.parseLong(item));
			
		}
		
		for(Long item2: idCuotas) {
			cuotaitem=servicioCuotaDao.consultarCuotaporId(item2);
			cuotaitem.setEstado(true);
			cuotaitem.setCubierto(true);
			cuotaitem.setFechaDePago(new Date());
			servicioCuotaDao.modificarElCubierto(cuotaitem);
		}
		///registra pago
//		String doc= Long.toString(confirm.getDni());
//		servicioRegistroDao.insertarIngresos(cuotaitem, confirm.getIdPrestamo(), doc);
		//
		Prestamo prestamo0=servicioPrestamoDao.consultarUnPrestamo(confirm.getIdPrestamo());
		
		
		List<Cuota> cuotaspagas=servicioCuotaDao.consultarCuotaPagada(prestamo0.getIdPrestamo());
		if(cuotaspagas.size()==prestamo0.getCuotas()) {
			prestamo0.setEstado("pagado");
		}
		servicioPrestamoDao.modificarPrestamo(prestamo0);
		
	}
	
	@Override
	public void insertarCuota(List<Cuota> cuotas){
		servicioCuotaDao.insertarCuota(cuotas);
	}
	
	@Override
	public List<Cuota> consultarCuota(Long arefinanciar) {
		
		return servicioCuotaDao.consultarCuota(arefinanciar);
	}
	
	@Override
	public List<Cuota> consultarPorFinanciera(Financiera financiera) {
		return servicioCuotaDao.consultarPorFinanciera(financiera);
	}

	@Override
	public void modificarCubierto(Cuota cuota) {
		servicioCuotaDao.modificarElCubierto(cuota);
		
	}

	@Override
	public Cuota buscarCuota(Cuota cuota) {
		servicioCuotaDao.buscarCuota(cuota);
		return null;
	}
	
	
	
	@Override
	public List<Cuota> consultarCuotaDelUltimoPrestamo() {
		return servicioCuotaDao.consultarCuotaDelUltimoPrestamo();
	}
	
	@Override
	public List<Cuota> consultarCuotaImpagas(Long idPrestamo){
		return servicioCuotaDao.consultarCuotaImpagas(idPrestamo);
	}

	
}
