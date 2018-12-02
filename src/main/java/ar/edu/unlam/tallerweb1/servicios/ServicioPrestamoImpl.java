package ar.edu.unlam.tallerweb1.servicios;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.unlam.tallerweb1.dao.AfiliadoDao;
import ar.edu.unlam.tallerweb1.dao.CuotaDao;
import ar.edu.unlam.tallerweb1.dao.PrestamoDao;
import ar.edu.unlam.tallerweb1.modelo.Afiliado;
import ar.edu.unlam.tallerweb1.modelo.Cuota;
import ar.edu.unlam.tallerweb1.modelo.Prestamo;

@Service("servicioPrestamo")
@Transactional
public class ServicioPrestamoImpl implements ServicioPrestamo {
	@Inject
	private PrestamoDao servicioPrestamoDao;
	
	@Inject AfiliadoDao servicioAfiliadoDao;
	
	@Inject
	private CuotaDao servicioCuotaDao;
	
	@Override
	public List<Prestamo> consultarPrestamo() {
		return servicioPrestamoDao.consultarPrestamo();
	}
	@Override
	public List<Prestamo> consultarPrestamoTodosLosAfiliados() {
		List<Prestamo> prestamo= servicioPrestamoDao.consultarPrestamo();
		List<Prestamo> prestamoresult= new ArrayList<Prestamo>();
		for(Prestamo item: prestamo) {
			if(item.getFinanciera()==null) {
				prestamoresult.add(item);
			}
		}
		return prestamoresult;
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
	public List<Prestamo> consultarPrestamoActivos(Afiliado afiliado) {
		return servicioPrestamoDao.consultarPrestamoActivo(afiliado);
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
	@Override
	public List<Prestamo> consultarPrestamoOrdenadoDesc() {
		List<Prestamo> prestamo= servicioPrestamoDao.consultarPrestamoOrdenadoDesc();
		List<Prestamo> prestamoresult= new ArrayList<Prestamo>();
		for(Prestamo item: prestamo) {
			if(item.getFinanciera()==null) {
				prestamoresult.add(item);
			}
		}
		return prestamoresult;
	}

	@Override
	public void crearNuevoPrestamo(Afiliado afiliado, Integer valor, Integer cuotas) {
		Afiliado miAfiliado = servicioAfiliadoDao.consultarAfiliadoDni(afiliado.getDni());
		Prestamo nprestamo = new Prestamo();
		nprestamo.setValor(valor);
		nprestamo.setCuotas(cuotas);
		nprestamo.setInteres(0.35);
		nprestamo.setEstado("activo");
		nprestamo.setAfiliado(miAfiliado);
		nprestamo.setDni(afiliado.getDni());
		
		double montoMensual = valor/cuotas;
		double interesCuota = (valor*0.35)/12;
		double total = montoMensual+interesCuota;
		
		Calendar fechven = Calendar.getInstance();
		
		List<Cuota> ncuotas = new ArrayList<Cuota>();	
		
		for(int i=0; i<nprestamo.getCuotas(); i++){
			
			Cuota ncuota = new Cuota();
			fechven.add(Calendar.DAY_OF_YEAR, 30);
			ncuota.setMonto(montoMensual);
			ncuota.setInteres(interesCuota);
			ncuota.setMontoTotal(total);
			ncuota.setEstado(false);
			ncuota.setFechaDeVencimiento(fechven.getTime());
			ncuota.setPrestamo(nprestamo);	
			ncuotas.add(ncuota);
			
		}
		servicioCuotaDao.insertarCuota(ncuotas);
	}


}
