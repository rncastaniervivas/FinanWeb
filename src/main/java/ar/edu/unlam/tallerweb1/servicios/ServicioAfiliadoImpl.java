package ar.edu.unlam.tallerweb1.servicios;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.unlam.tallerweb1.dao.AfiliadoDao;
import ar.edu.unlam.tallerweb1.dao.PrestamoDao;
import ar.edu.unlam.tallerweb1.modelo.Afiliado;

@Service("servicioAfiliado")
@Transactional
public class ServicioAfiliadoImpl implements ServicioAfiliado {

	@Inject
	private AfiliadoDao servicioAfiliadoDao;
	@Inject
	private PrestamoDao servicioPrestamoDao;
	
	@Override
	public boolean guardarAfiliado(Afiliado afiliado) {
		List<Afiliado> miafiliado=servicioAfiliadoDao.buscarAfiliado(afiliado);
		if(miafiliado.size() == 0) {
			servicioAfiliadoDao.guardarAfiliado(afiliado);
			return true;
		}else {
			return false;
		}
		
	}
	@Override
	public Boolean existeAfiliado(Afiliado afiliado){
		Afiliado afil=servicioAfiliadoDao.consultarAfiliadoDni(afiliado.getDni());
		if(afil.getDni()!=null) {
			return true;
		}
		else {
			return false;
		}
	}
	@Override
	public List<Afiliado> consultarAfiliado () {
		return servicioAfiliadoDao.consultarAfiliado();
	}
	@Override
	public boolean modificarAfiliado(Afiliado afiliado) {
		List<Afiliado> miafil=servicioAfiliadoDao.buscarAfiliado(afiliado);
		if(miafil.size() != 0) {
			return false;
			}else {
				servicioAfiliadoDao.modificarAfiliado(afiliado);
		
		return true;
			}
		}
	
	
	@Override
	public boolean eliminarAfiliado (Afiliado afiliado) {
		boolean tienePrestamo=servicioPrestamoDao.consultarPrestamoActivoAfiliado(afiliado.getIdAfiliado());
		if(tienePrestamo) {
		return false;
		}else
		{		
			servicioAfiliadoDao.eliminarAfiliado(afiliado);
			return true;
		}
	}
	
	@Override
	public Afiliado consultarAfiliado (Long id) {
		return servicioAfiliadoDao.consultarAfiliado(id);
	}
	
	@Override
	public boolean validarAfiliadoAntiguedad(String antiguedad) {
		if(Integer.parseInt(antiguedad) >= 1) {
		return true;	
		}
		return false;
	}
	@Override
	public Afiliado consultarAfiliadoDni (Long dni) {
		return servicioAfiliadoDao.consultarAfiliadoDni(dni);
	}
	@Override
	public Afiliado consultarIdAfiliado(Long id) {
		return servicioAfiliadoDao.consultarIdAfiliado(id);
	}

}
