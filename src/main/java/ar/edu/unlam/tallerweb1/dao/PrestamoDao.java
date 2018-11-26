package ar.edu.unlam.tallerweb1.dao;

import java.util.List;

import ar.edu.unlam.tallerweb1.modelo.Prestamo;

public interface PrestamoDao {
	List<Prestamo> consultarPrestamo();
	
	Prestamo consultarUnPrestamo(Long idPrestamo);
	
	void crearNuevoPrestamo(Prestamo prestamoRef);
	
	List<Prestamo> consultarPrestamo(Long dni);
	
	void modificarPrestamo(Prestamo prestamo);
	
}
