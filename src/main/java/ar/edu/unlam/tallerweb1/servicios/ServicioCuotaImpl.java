package ar.edu.unlam.tallerweb1.servicios;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.unlam.tallerweb1.dao.CuotaDao;
import ar.edu.unlam.tallerweb1.modelo.Cuota;
import ar.edu.unlam.tallerweb1.modelo.Financiera;

@Service("servicioCuota")
@Transactional
public class ServicioCuotaImpl implements ServicioCuota{
	
	@Inject
	private CuotaDao servicioCuotaDao;
	
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
		Cuota miCuota=servicioCuotaDao.buscarCuota(cuota);
		miCuota.setCubierto(true);
		servicioCuotaDao.modificarElCubierto(miCuota);
		
	}

	@Override
	public Cuota buscarCuota(Cuota cuota) {
		servicioCuotaDao.buscarCuota(cuota);
		return null;
	}
	
	
	
}
