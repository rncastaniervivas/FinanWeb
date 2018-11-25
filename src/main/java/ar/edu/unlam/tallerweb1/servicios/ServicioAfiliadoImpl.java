package ar.edu.unlam.tallerweb1.servicios;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.unlam.tallerweb1.dao.AfiliadoDao;
import ar.edu.unlam.tallerweb1.modelo.Afiliado;

@Service("servicioAfiliado")
@Transactional
public class ServicioAfiliadoImpl implements ServicioAfiliado {

	@Inject
	private AfiliadoDao servicioAfiliadoDao;

	@Override
	public List<Afiliado> consultarAfiliado () {
		return servicioAfiliadoDao.consultarAfiliado();
	}
	
	@Override
	public void agregarAfiliado (Afiliado afiliado) {
		servicioAfiliadoDao.agregarAfiliado(afiliado);
	}
	
	@Override
	public void modificarAfiliado(Afiliado afiliado) {
		servicioAfiliadoDao.modificarAfiliado(afiliado);
	}
	
	@Override
	public void eliminarAfiliado (Afiliado afiliado) {
		servicioAfiliadoDao.eliminarAfiliado(afiliado);
	}
	
	@Override
	public List <Afiliado> buscarAfiliado (Afiliado afiliado) {
		return servicioAfiliadoDao.buscarAfiliado(afiliado);
	}
	
	@Override
	public Afiliado consultarAfiliado (Long id) {
		return servicioAfiliadoDao.consultarAfiliado(id);
	}
	
	@Override
	public Afiliado consultarAfiliadoDni (Long dni) {
		return servicioAfiliadoDao.consultarAfiliadoDni(dni);
	}

}
