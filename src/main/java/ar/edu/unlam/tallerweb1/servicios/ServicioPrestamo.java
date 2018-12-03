package ar.edu.unlam.tallerweb1.servicios;

import java.util.List;

import ar.edu.unlam.tallerweb1.modelo.Cuota;
import ar.edu.unlam.tallerweb1.modelo.Prestamo;

public interface ServicioPrestamo {

	List<Prestamo> consultarPrestamo();
	
	Prestamo consultarUnPrestamo(Long idPrestamo);
	
	boolean consultarPorFinanciera(Long idFinanciera);
	
	Prestamo consutaPrestamoPorCuota(Cuota cuota);

}
