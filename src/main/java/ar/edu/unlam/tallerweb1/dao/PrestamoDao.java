package ar.edu.unlam.tallerweb1.dao;

import java.util.List;

import ar.edu.unlam.tallerweb1.modelo.Cuota;
import ar.edu.unlam.tallerweb1.modelo.Prestamo;

public interface PrestamoDao {
	List<Prestamo> consultarPrestamo();
	
	Prestamo consultarUnPrestamo(Long idPrestamo);
	
	boolean consultarPorFinanciera(Long idFinanciera);
	
	Prestamo consultarPrestamoPorCuota(Cuota cuota);
	
}
