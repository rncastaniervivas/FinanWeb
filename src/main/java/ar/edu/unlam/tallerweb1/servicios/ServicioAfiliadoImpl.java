package ar.edu.unlam.tallerweb1.servicios;

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
	public Afiliado consultarAfiliado (Afiliado afiliado) {
		return servicioAfiliadoDao.consultarAfiliado(afiliado);
	}
	
	@Override
	public Afiliado consultarAfiliado (Long idPrestamo) {
		return servicioAfiliadoDao.consultarAfiliado(idPrestamo);
	}

}
