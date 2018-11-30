package ar.edu.unlam.tallerweb1.servicios;

import java.util.List;

import ar.edu.unlam.tallerweb1.modelo.Cuota;

public interface ServicioRefinanciar {
	
	Double montoARefinanciar(Long idPrestamo);
	
	List<Cuota> consultaCuota(Long idPrestamo);
	
	void refinanciar(Long dni, Long idPrestamoRef, double newCapital, Integer cuotas, double interes);
}
