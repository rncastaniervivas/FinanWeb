package ar.edu.unlam.tallerweb1.servicios;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.unlam.tallerweb1.dao.AfiliadoDao;
import ar.edu.unlam.tallerweb1.dao.CuotaDao;
import ar.edu.unlam.tallerweb1.dao.FinancieraDao;
import ar.edu.unlam.tallerweb1.dao.PrestamoDao;
import ar.edu.unlam.tallerweb1.modelo.Afiliado;
import ar.edu.unlam.tallerweb1.modelo.Cuota;
import ar.edu.unlam.tallerweb1.modelo.Financiera;
import ar.edu.unlam.tallerweb1.modelo.Prestamo;

@Service("servicioPrestamo")
@Transactional
public class ServicioPrestamoImpl implements ServicioPrestamo {
	@Inject
	private PrestamoDao servicioPrestamoDao;
	
	@Inject AfiliadoDao servicioAfiliadoDao;
	
	@Inject
	private CuotaDao servicioCuotaDao;
	@Inject
	private FinancieraDao servicioFinancieraDao;
	
	@Override
	public List<Prestamo> consultarPrestamo() {
		return servicioPrestamoDao.consultarPrestamo();
	}
	@Override
	public List<Prestamo> consultarPrestamoTodosLosAfiliados() {
		List<Prestamo> prestamo= servicioPrestamoDao.consultarPrestamo();
		List<Prestamo> prestamoresult= new ArrayList<Prestamo>();
		for(Prestamo item: prestamo) {
			if(item.getDni()!=null) {
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
	public Prestamo consutaPrestamoPorCuota(Cuota cuota) {
		return servicioPrestamoDao.consultarPrestamoPorCuota(cuota);
		
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
	public boolean consultarPrestamoActivoAfiliado (Long idAfiliado) {
		return servicioPrestamoDao.consultarPrestamoActivoAfiliado(idAfiliado);
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
	public List<Prestamo> consultarPrestamoFinanOrdenadoDesc() {
		List<Prestamo> prestamo= servicioPrestamoDao.consultarPrestamoOrdenadoDesc();
		List<Prestamo> prestamoresult= new ArrayList<Prestamo>();
		for(Prestamo item: prestamo) {
			if(item.getFinanciera()!=null) {
				prestamoresult.add(item);
			}
		}
		return prestamoresult;
	}
	@Override
	public List<Prestamo> consultarPrestamoFinanOrdenadoAsc() {
		List<Prestamo> prestamo= servicioPrestamoDao.consultarPrestamoOrdenadoAsc();
		List<Prestamo> prestamoresult= new ArrayList<Prestamo>();
		for(Prestamo item: prestamo) {
			if(item.getFinanciera()!=null) {
				prestamoresult.add(item);
			}
		}
		return prestamoresult;
	}
	@Override
	public List<Prestamo> consultarPrestamoOrdenadoAsc() {
		List<Prestamo> prestamo= servicioPrestamoDao.consultarPrestamoOrdenadoAsc();
		List<Prestamo> prestamoresult= new ArrayList<Prestamo>();
		for(Prestamo item: prestamo) {
			if(item.getFinanciera()==null) {
				prestamoresult.add(item);
			}
		}
		return prestamoresult;
	}

	@Override
	public void crearNuevoPrestamo(Afiliado afiliado, Integer valor, Integer cuotas,String nombreF) {
		Afiliado miAfiliado = servicioAfiliadoDao.consultarAfiliadoDni(afiliado.getDni());
		//busca financiera
		Financiera miFinanciera=servicioFinancieraDao.buscarFinancieraPorNombre(nombreF);
		//
		
		
		Prestamo newPrestamo = new Prestamo();
		newPrestamo.setValor(valor);
		newPrestamo.setCuotas(cuotas);
		newPrestamo.setInteres(0.35);
		newPrestamo.setEstado("activo");
		newPrestamo.setAfiliado(miAfiliado);
		newPrestamo.setDni(afiliado.getDni());
		newPrestamo.setSaldo(valor);
		//guarda la financiera del prestamo y modifica el monto capital
		double porCientoInteres = newPrestamo.getInteres()/12;
		newPrestamo.setFinanciera(miFinanciera);
		Integer montoCapital=miFinanciera.getMontoCapital();
		miFinanciera.setMontoCapital(montoCapital-valor);
		servicioFinancieraDao.modificarFinanciera(miFinanciera);
		//
		double cuota = fijarNumero(valor*((porCientoInteres*Math.pow(1+porCientoInteres, cuotas))/(Math.pow(1+porCientoInteres, cuotas)-1)),2);
		double salini=valor;
		double interes = fijarNumero(salini*porCientoInteres,2);
		double amortizacion = fijarNumero(cuota-interes,2);
		double salfin = salini-amortizacion;
		
		
		Calendar fechven = Calendar.getInstance();
		
		List<Cuota> newCuotas = new ArrayList<Cuota>();	
		
		for(int i=0; i<newPrestamo.getCuotas(); i++){
			
			Cuota newCuota = new Cuota();
			fechven.add(Calendar.DAY_OF_YEAR, 30);
			newCuota.setMonto(cuota);
			newCuota.setInteres(interes);
			newCuota.setMontoTotal(amortizacion);
			newCuota.setEstado(false);
			newCuota.setFechaDeVencimiento(fechven.getTime());
			newCuota.setPrestamo(newPrestamo);	
			newCuotas.add(newCuota);
			
			salini=salfin;
			interes = fijarNumero(salini*porCientoInteres,2);
			amortizacion = fijarNumero(cuota-interes,2);
			salfin = fijarNumero(salini-amortizacion,2);
			
		}
		
		List<Prestamo> prestamos = miAfiliado.getPrestamo();
		prestamos.add(newPrestamo);
		miAfiliado.setPrestamo(prestamos);
		
		servicioAfiliadoDao.modificarAfiliado(miAfiliado);
		servicioCuotaDao.insertarCuota(newCuotas);
	}
	
	public static double fijarNumero(double numero, int digitos) {
        double resultado;
        resultado = numero * Math.pow(10, digitos);
        resultado = Math.round(resultado);
        resultado = resultado/Math.pow(10, digitos);
        return resultado;
    }


}
