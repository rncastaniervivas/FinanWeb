package ar.edu.unlam.tallerweb1.servicios;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.unlam.tallerweb1.dao.FinancieraDao;
import ar.edu.unlam.tallerweb1.modelo.Financiera;

@Service("servicioFinanciera")
@Transactional
public class ServicioFinancieraImpl implements ServicioFinanciera {
	@Inject
	private FinancieraDao servicioFinancieraDao;
	
	@Override
	public List<Financiera> consultarFinanciera() {
		return servicioFinancieraDao.consultarFinanciera();
	}

	@Override
	public void guardarFinanciera(Financiera financiera) {
		servicioFinancieraDao.guardarFinanciera(financiera);
		
	}

	@Override
	public List<Financiera> buscarFinanciera (Financiera financiera) {
		return servicioFinancieraDao.buscarFinanciera(financiera);
		
	}

	@Override
	public void eliminarfinanciera(Financiera financiera) {
		servicioFinancieraDao.eliminarfinanciera(financiera);
		
	}

	@Override
	public void modificarFinanciera(Financiera financiera) {
		servicioFinancieraDao.modificarFinanciera(financiera);
		
	}
}
