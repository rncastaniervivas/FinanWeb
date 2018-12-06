package ar.edu.unlam.tallerweb1.servicios;

import ar.edu.unlam.tallerweb1.modelo.Caja;
import ar.edu.unlam.tallerweb1.modelo.Cuota;

public interface ServicioCaja {
	
	void agregarCaja(Double agregar);
	
	void sacarCaja(Double sacar);
	
	Caja consultarCaja();

	void agregarCaja(Cuota cuotai);

	void sacarCaja(Cuota cuotae);
	

}
