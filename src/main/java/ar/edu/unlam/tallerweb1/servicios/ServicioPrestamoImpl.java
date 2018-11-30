package ar.edu.unlam.tallerweb1.servicios;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.unlam.tallerweb1.dao.AfiliadoDao;
import ar.edu.unlam.tallerweb1.dao.PrestamoDao;
import ar.edu.unlam.tallerweb1.modelo.Afiliado;
import ar.edu.unlam.tallerweb1.modelo.Prestamo;

@Service("servicioPrestamo")
@Transactional
public class ServicioPrestamoImpl implements ServicioPrestamo {
	@Inject
	private PrestamoDao servicioPrestamoDao;
	
	@Inject AfiliadoDao servicioAfiliadoDao;
	
	@Override
	public List<Prestamo> consultarPrestamo() {
		return servicioPrestamoDao.consultarPrestamo();
	}
	
	@Override
	public Prestamo consultarUnPrestamo(Long idPrestamo) {
		return servicioPrestamoDao.consultarUnPrestamo(idPrestamo);
	}

	@Override
	public boolean consultarPorFinanciera(Long idFinanciera) {
		return servicioPrestamoDao.consultarPorFinanciera(idFinanciera);
		
	}
	
	@Override
	public void crearNuevoPrestamo(Prestamo prestamoRef) {
		servicioPrestamoDao.crearNuevoPrestamo(prestamoRef);
	}
	
	@Override
	public List<Prestamo> consultarPrestamo(Long dni) {
		return servicioPrestamoDao.consultarPrestamo(dni);
	}
	
	@Override
	public void modificarPrestamo(Prestamo prestamo) {
		servicioPrestamoDao.modificarPrestamo(prestamo);
	}

	@Override
	public double salarioAfectado(Afiliado afiliado) {
		List<Prestamo> prestamos = servicioPrestamoDao.consultarPrestamoActivo(afiliado);
		
		double salarioAfectado = 0;
		
		for (Prestamo prestamo : prestamos) {
			salarioAfectado += prestamo.getValor();
		}
		
		return salarioAfectado;
	}

	@Override
	public double prestamoDisponible(Afiliado afiliado) {
		Afiliado miAfiliado = servicioAfiliadoDao.consultarAfiliadoDni(afiliado.getDni());
		
		double salarioAfectado = this.salarioAfectado(miAfiliado);
		double porcientoSalarioAfectar = miAfiliado.getSueldo()*0.3;
		
		double prestamoDisponible = porcientoSalarioAfectar-salarioAfectado;
		
		return prestamoDisponible;
	}
	
	
	
}
