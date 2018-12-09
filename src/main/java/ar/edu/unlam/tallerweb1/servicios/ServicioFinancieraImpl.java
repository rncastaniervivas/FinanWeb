package ar.edu.unlam.tallerweb1.servicios;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.unlam.tallerweb1.dao.FinancieraDao;
import ar.edu.unlam.tallerweb1.dao.PrestamoDao;
import ar.edu.unlam.tallerweb1.modelo.Financiera;

@Service("servicioFinanciera")
@Transactional
public class ServicioFinancieraImpl implements ServicioFinanciera {
	@Inject
	private FinancieraDao servicioFinancieraDao;
	@Inject
	private PrestamoDao servicioPrestamoDao;
	
	@Override
	public List<Financiera> consultarFinanciera() {
		return servicioFinancieraDao.consultarFinanciera();
	}

	@Override
	public boolean guardarFinanciera(Financiera financiera) {
		List<Financiera> mifinanciera=servicioFinancieraDao.buscarFinanciera(financiera);
		if(mifinanciera.size() == 0) {
			servicioFinancieraDao.guardarFinanciera(financiera);
			return true;
		}else {
			return false;
		}
		
	}

	@Override
	public List<Financiera> buscarFinanciera (Financiera financiera) {
		return servicioFinancieraDao.buscarFinanciera(financiera);
		
	}


	@Override
	public boolean eliminarfinanciera(Financiera financiera) {
		boolean tienePrestamo=servicioPrestamoDao.consultarPorFinanciera(financiera.getIdFinanciera());
		if(tienePrestamo) {
		return false;
		}else
		{
			servicioFinancieraDao.eliminarfinanciera(financiera);
			return true;
		}
		
	}

	@Override
	public boolean modificarFinanciera(Financiera financiera) {
		List<Financiera> miFinan=servicioFinancieraDao.buscarFinanciera(financiera);
		if(miFinan.size() != 0) {
			return false;
			}else {
		servicioFinancieraDao.modificarFinanciera(financiera);
		return true;
			}
		}

	@Override
	public Financiera buscarFinancieraPorNombre(String nombreF) {
		return servicioFinancieraDao.buscarFinancieraPorNombre(nombreF);
	}

	@Override
	public void descontarMontoFinanciera(Integer valor) {
		// TODO Auto-generated method stub
		
	}
	
	
	
}
