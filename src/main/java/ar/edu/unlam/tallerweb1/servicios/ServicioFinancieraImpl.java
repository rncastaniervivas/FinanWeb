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
}
