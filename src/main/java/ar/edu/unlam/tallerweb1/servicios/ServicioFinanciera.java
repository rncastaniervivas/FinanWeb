package ar.edu.unlam.tallerweb1.servicios;

import java.util.List;

import ar.edu.unlam.tallerweb1.modelo.Financiera;

public interface ServicioFinanciera {
	
	List<Financiera> consultarFinanciera();
	
	boolean guardarFinanciera(Financiera financiera);
	
	List<Financiera> buscarFinanciera(Financiera financiera);
	
	boolean eliminarfinanciera(Financiera financiera);
	
	boolean modificarFinanciera(Financiera financiera);
	
	
}
