package ar.edu.unlam.tallerweb1.servicios;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.unlam.tallerweb1.dao.AfiliadoDao;
import ar.edu.unlam.tallerweb1.modelo.Afiliado;
import ar.edu.unlam.tallerweb1.modelo.Prestamo;

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
	public List<Afiliado> consultarListaAfiliado(){
		
		return servicioAfiliadoDao.consultarListaAfiliado();
	}
	@Override
	public Afiliado consultarIdAfiliado(Long id) {
		return servicioAfiliadoDao.consultarIdAfiliado(id);
	}


}
