package ar.edu.unlam.tallerweb1.servicios;

import ar.edu.unlam.tallerweb1.modelo.Afiliado;

public interface ServicioAfiliado {

	Afiliado consultarAfiliado(Afiliado afiliado);
	
	Afiliado consultarAfiliado(Long idPrestamo);

}
