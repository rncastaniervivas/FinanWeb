package ar.edu.unlam.tallerweb1.dao;

import ar.edu.unlam.tallerweb1.modelo.Cuota;

public interface CajaDao {
	
	public void agregarCaja(Cuota cuotai);
	
	public void sacarCaja(Cuota cuotae);
	
	public Double consultarCaja();

}
