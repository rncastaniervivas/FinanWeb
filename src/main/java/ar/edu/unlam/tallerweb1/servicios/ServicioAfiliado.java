package ar.edu.unlam.tallerweb1.servicios;

import java.util.List;

import ar.edu.unlam.tallerweb1.modelo.Afiliado;
import ar.edu.unlam.tallerweb1.modelo.Prestamo;

public interface ServicioAfiliado {

	Afiliado consultarAfiliado(Afiliado afiliado);
	List<Afiliado> consultarListaAfiliado();
	Afiliado consultarIdAfiliado(Long id);
	}
