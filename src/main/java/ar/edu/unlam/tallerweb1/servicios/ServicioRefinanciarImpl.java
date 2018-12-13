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

@Service("servicioRefinanciar")
@Transactional
public class ServicioRefinanciarImpl implements ServicioRefinanciar{
	
	@Inject
	private CuotaDao servicioCuotaDao;
	
	@Inject
	private AfiliadoDao servicioAfiliadoDao;
	
	@Inject
	private PrestamoDao servicioPrestamoDao;
	
	@Override
	public Double montoARefinanciar(Long idPrestamo){
		double montoTotal = 0.0;
		List<Cuota> cuotas = servicioCuotaDao.consultarCuota(idPrestamo);
		
		for(Cuota i :cuotas) {
			montoTotal += i.getMontoTotal();
		}
		return (double)((int) montoTotal);
	}

	@Override
	public List<Cuota> consultaCuota(Long idPrestamo) {
		return servicioCuotaDao.consultarCuotaImpagas(idPrestamo);
	}

	@Override
	public void refinanciar(Long dni, Long idPrestamoRef, Integer cuotas) {
		
		//Integer nCapital = (int)newCapital;

		// Se modificar la clasificacion del Afiliado (Perdida).
		Afiliado afiliado = servicioAfiliadoDao.consultarAfiliadoDni(dni);
		afiliado.setClasificacion("Perdida");
		servicioAfiliadoDao.modificarAfiliado(afiliado);

		// aqui tiene que estar el modificar el estado del prestamo (Refinanciado).
		Prestamo prestamoARef = servicioPrestamoDao.consultarUnPrestamo(idPrestamoRef);
		prestamoARef.setEstado("refinanciado");
		servicioPrestamoDao.modificarPrestamo(prestamoARef);
		
		int valor = (int) prestamoARef.getSaldo();
		
		Prestamo newPrestamo = new Prestamo();
		newPrestamo.setValor(valor);
		newPrestamo.setCuotas(cuotas);
		newPrestamo.setInteres(0.355);
		newPrestamo.setEstado("activo");
		newPrestamo.setAfiliado(afiliado);
		newPrestamo.setDni(afiliado.getDni());
		newPrestamo.setSaldo(valor);
		//guarda la financiera del prestamo y modifica el monto capital
//		newPrestamo.setFinanciera(miFinanciera);
//		Integer montoCapital=miFinanciera.getMontoCapital();
//		miFinanciera.setMontoCapital(montoCapital-valor);
//		servicioFinancieraDao.modificarFinanciera(miFinanciera);
		//
		double newInteres = newPrestamo.getInteres()/12;
		
		double cuota = fijarNumero(valor*((newInteres*Math.pow((1+newInteres), cuotas))/(Math.pow((1+newInteres), cuotas)-1)),2);
		double salini=valor;
		double interes = fijarNumero(salini*newInteres,2);
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
			interes = fijarNumero(salini*newInteres,2);
			amortizacion = fijarNumero(cuota-interes,2);
			salfin = fijarNumero(salini-amortizacion,2);
			
		}
		servicioCuotaDao.insertarCuota(newCuotas);
	}

	@Override
	public List<Cuota> generarCuotas(Long idPrestamoRef, Integer cuotas) {
		Prestamo prestamoARef = servicioPrestamoDao.consultarUnPrestamo(idPrestamoRef);
		List<Cuota> newCuotas = new ArrayList<Cuota>();
		
		double newInteres = (prestamoARef.getInteres()+0.005)/12; // Por refinanciar le sumamos al interes un 0.5% de interes anual.
		double valor = prestamoARef.getSaldo();
		
		double cuota = fijarNumero(valor*((newInteres*Math.pow((1+newInteres), cuotas))/(Math.pow((1+newInteres), cuotas)-1)),2);
		double salini = valor;
		double interes = fijarNumero(salini*newInteres,2);
		double amortizacion = fijarNumero(cuota-interes,2);
		double salfin = salini-amortizacion;
		
		
		Calendar fechven = Calendar.getInstance();	
		
		for(int i=0; i<cuotas; i++){
			
			Cuota newCuota = new Cuota();
			fechven.add(Calendar.DAY_OF_YEAR, 30);
			newCuota.setIdCuota((long) (i+1));
			newCuota.setMonto(cuota);
			newCuota.setInteres(interes);
			newCuota.setMontoTotal(amortizacion);
			newCuota.setEstado(false);
			newCuota.setFechaDeVencimiento(fechven.getTime());
			//newCuota.setPrestamo(newPrestamo);	
			newCuotas.add(newCuota);
			
			salini=salfin;
			interes = fijarNumero(salini*newInteres,2);
			amortizacion = fijarNumero(cuota-interes,2);
			salfin = fijarNumero(salini-amortizacion,2);
			
		}
		
		return newCuotas;
	}
	@Override
	public List<Cuota> generarCuotasPrestamoNuevo(Integer valor0, Integer cuotas) {
		List<Cuota> newCuotas = new ArrayList<Cuota>();
		double valor=(double)valor0;
		double newInteres = 0.35/12; // Por refinanciar le sumamos al interes un 0.5% de interes anual.
		
		double cuota = fijarNumero(valor*((newInteres*Math.pow((1+newInteres), cuotas))/(Math.pow((1+newInteres), cuotas)-1)),2);
		double salini = valor;
		double interes = fijarNumero(salini*newInteres,2);
		double amortizacion = fijarNumero(cuota-interes,2);
		double salfin = salini-amortizacion;
		
		
		Calendar fechven = Calendar.getInstance();	
		
		for(int i=0; i<cuotas; i++){
			
			Cuota newCuota = new Cuota();
			fechven.add(Calendar.DAY_OF_YEAR, 30);
			newCuota.setIdCuota((long) (i+1));
			newCuota.setMonto(cuota);
			newCuota.setInteres(interes);
			newCuota.setMontoTotal(amortizacion);
			newCuota.setEstado(false);
			newCuota.setFechaDeVencimiento(fechven.getTime());
			//newCuota.setPrestamo(newPrestamo);	
			newCuotas.add(newCuota);
			
			salini=salfin;
			interes = fijarNumero(salini*newInteres,2);
			amortizacion = fijarNumero(cuota-interes,2);
			salfin = fijarNumero(salini-amortizacion,2);
			
		}
		
		return newCuotas;
	}
	
	// esto es para hacer el truncamiento de un valor con decimal
	public static double fijarNumero(double numero, int digitos) {
        double resultado;
        resultado = numero * Math.pow(10, digitos);
        resultado = Math.round(resultado);
        resultado = resultado/Math.pow(10, digitos);
        return resultado;
    }
	
}
