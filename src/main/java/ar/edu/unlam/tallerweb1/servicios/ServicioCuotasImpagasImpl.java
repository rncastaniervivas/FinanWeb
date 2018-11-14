package ar.edu.unlam.tallerweb1.servicios;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.unlam.tallerweb1.dao.RefinanciarDao;
import ar.edu.unlam.tallerweb1.modelo.Cuota;
@Service("servicioPrestamo")
@Transactional
public class ServicioCuotasImpagasImpl implements ServicioCuotasImpagas {
	@Inject
	private RefinanciarDao servicioRefinanciar;
	

	@Override
	public List<Cuota> cuotasImpagas() {
		
		return servicioRefinanciar.listaCuotas();
	}

}
