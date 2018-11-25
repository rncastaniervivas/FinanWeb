package ar.edu.unlam.tallerweb1.servicios;

import java.util.List;

import ar.edu.unlam.tallerweb1.modelo.Afiliado;

public interface ServicioAfiliado {


	List<Afiliado> consultarAfiliado ();
	
	void agregarAfiliado (Afiliado afiliado);
	
	void modificarAfiliado (Afiliado afiliado);
	
	void eliminarAfiliado (Afiliado afiliado);
	
	Afiliado consultarAfiliado(Long idPrestamo);
	
	List<Afiliado> buscarAfiliado (Afiliado afiliado);
	
	Afiliado consultarAfiliadoDni(Long dni);
	
}