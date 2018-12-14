package ar.edu.unlam.tallerweb1.servicios;

import java.util.List;

import ar.edu.unlam.tallerweb1.modelo.Afiliado;

public interface ServicioAfiliado {


	List<Afiliado> consultarAfiliado ();
	
	boolean guardarAfiliado (Afiliado afiliado);
	
	void modificarAfiliado (Afiliado afiliado);
	
	boolean eliminarAfiliado (Afiliado afiliado);
	
	Afiliado consultarAfiliado(Long idPrestamo);
	
	Afiliado consultarAfiliadoDni(Long dni);
	
	Afiliado consultarIdAfiliado(Long id);

	Boolean existeAfiliado(Afiliado afiliado);

	boolean validarAfiliadoAntiguedad(String antiguedad);
	
}