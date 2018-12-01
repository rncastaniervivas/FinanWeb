package ar.edu.unlam.tallerweb1.servicios;

import java.util.List;

import ar.edu.unlam.tallerweb1.modelo.Afiliado;
import ar.edu.unlam.tallerweb1.modelo.Prestamo;

public interface ServicioPrestamo {

	List<Prestamo> consultarPrestamo();
	
	Prestamo consultarUnPrestamo(Long idPrestamo);
	
	void crearNuevoPrestamo(Prestamo prestamoRef);
	
	List<Prestamo> consultarPrestamo(Long dni);
	
	void modificarPrestamo(Prestamo prestamo);
	
	boolean consultarPorFinanciera(Long idFinanciera);
	
	double salarioAfectado(Afiliado afiliado);
	
	double prestamoDisponible(Afiliado afiliado);
	
	void crearNuevoPrestamo(Afiliado afiliado, Integer valor, Integer cuotas);
	
	List<Prestamo> consultarPrestamoActivos(Afiliado afiliado);
	
	List<Prestamo> consultarPrestamoTodosLosAfiliados();
}
