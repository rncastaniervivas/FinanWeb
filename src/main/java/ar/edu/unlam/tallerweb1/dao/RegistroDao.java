package ar.edu.unlam.tallerweb1.dao;

import java.util.List;

import ar.edu.unlam.tallerweb1.modelo.Registro;

public interface RegistroDao {
	
	public void agregarRegistro(Registro registro);
	
	public List<Registro> consultarRegistros();
	
	public List<Registro> consultarEgresos();
	
	public List<Registro> consultarIngresos();
	

}
