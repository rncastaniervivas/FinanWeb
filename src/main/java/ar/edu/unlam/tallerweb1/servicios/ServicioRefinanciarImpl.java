package ar.edu.unlam.tallerweb1.servicios;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.unlam.tallerweb1.dao.RefinanciarDao;
import ar.edu.unlam.tallerweb1.modelo.Cuota;

@Service("servicioRerinanciar")
@Transactional
public class ServicioRefinanciarImpl implements ServicioRefinanciar {
	@Inject
	private RefinanciarDao servicioRefinanciarDao;
	
	@Override
	public List<Cuota> consultarCuota() {
		
		return servicioRefinanciarDao.consultarCuota();
	}

}
