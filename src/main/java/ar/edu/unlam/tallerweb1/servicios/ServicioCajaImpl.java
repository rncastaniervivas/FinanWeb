package ar.edu.unlam.tallerweb1.servicios;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.unlam.tallerweb1.dao.CajaDao;

@Service("servicioCaja")
@Transactional
public class ServicioCajaImpl implements ServicioCaja {
	@Inject
	private CajaDao servicioCajaDao;

	@Override
	public void agregarCaja(Double agregar) {
		servicioCajaDao.agregarCaja(agregar);

	}

	@Override
	public void sacarCaja(Double sacar) {
		servicioCajaDao.sacarCaja(sacar);
	}

	@Override
	public Double consultarCaja() {
		return servicioCajaDao.consultarCaja();
		
	}

}
