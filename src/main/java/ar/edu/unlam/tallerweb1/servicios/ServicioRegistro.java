package ar.edu.unlam.tallerweb1.servicios;

import java.util.List;

import ar.edu.unlam.tallerweb1.modelo.Cuota;
import ar.edu.unlam.tallerweb1.modelo.Registro;

public interface ServicioRegistro {
	
	public void insertarIngresos(Cuota cuotai, Long idPrestamo, String nombreAfiliado);
	
	public void insertarEgresos(Cuota cuotae,Long idPrestamo,String nombreFinanciera);
	
	public List<Registro> consultarTodosRegistros();
	
	public Double montoDeIngresos();
	
	public Double montoDeEgresos();
	
	public List<Registro> consultarIngresos();
	
	public Double montoCaja();


	
	

}
