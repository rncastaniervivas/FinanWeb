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
	public void refinanciar(Long dni, Long idPrestamoRef, double newCapital, Integer cuotas, double interes) {
		
		Integer nCapital = (int)newCapital;

		// Se modificar la clasificacion del Afiliado (Perdida).
		Afiliado afiliado = servicioAfiliadoDao.consultarAfiliadoDni(dni);
		afiliado.setClasificacion("Perdida");
		servicioAfiliadoDao.modificarAfiliado(afiliado);

		// aqui tiene que estar el modificar el estado del prestamo (Refinanciado).
		Prestamo prestamo = servicioPrestamoDao.consultarUnPrestamo(idPrestamoRef);
		prestamo.setEstado("refinanciado");
		servicioPrestamoDao.modificarPrestamo(prestamo);
		
		Prestamo prestamoRef = new Prestamo();
		prestamoRef.setValor(nCapital);
		prestamoRef.setCuotas(cuotas);
		prestamoRef.setInteres(interes);
		prestamoRef.setAfiliado(afiliado);
		prestamoRef.setPrestamoRef(prestamo);
		prestamoRef.setEstado("activo");
		prestamoRef.setDni(afiliado.getDni());
		//prestamoRef.setCuota(cuotasRef);
		
		// Creo un nuevo prestamo con sus respectivos cuotas.
		Calendar fechven = Calendar.getInstance();
		
		List<Cuota> cuotasRef = new ArrayList<Cuota>();
		
		double montoMensual = nCapital/cuotas;
		double valorInteres = (nCapital*interes)/12;
		double total = montoMensual + valorInteres;
		
		for(int i=0; i<cuotas; i++){
			fechven.add(Calendar.DAY_OF_YEAR, 30);
			
			Cuota ncuota = new Cuota();
			
			ncuota.setMonto(montoMensual);
			ncuota.setInteres(valorInteres);
			ncuota.setMontoTotal(total);
			ncuota.setEstado(false);
			ncuota.setFechaDeVencimiento(fechven.getTime());
			ncuota.setPrestamo(prestamoRef);

			cuotasRef.add(ncuota);
		}
		servicioCuotaDao.insertarCuota(cuotasRef);
	}
	
}
