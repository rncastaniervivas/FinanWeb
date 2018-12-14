package ar.edu.unlam.tallerweb1.servicios;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.unlam.tallerweb1.dao.CajaDao;
import ar.edu.unlam.tallerweb1.modelo.Caja;
import ar.edu.unlam.tallerweb1.modelo.Cuota;

@Service("servicioCaja")
@Transactional
public class ServicioCajaImpl implements ServicioCaja {
	@Inject
	private CajaDao servicioCajaDao;
	
	@Override
	public void agregarCaja(Cuota cuotai) {
		
		
	}
	@Override
	public void sacarCaja(Cuota cuotae) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public Caja consultarCaja() {
		
		return servicioCajaDao.consultarCaja();
	}
	@Override
	public void agregarCaja(Double agregar) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void sacarCaja(Double sacar) {
		// TODO Auto-generated method stub
		
	}

	

}
