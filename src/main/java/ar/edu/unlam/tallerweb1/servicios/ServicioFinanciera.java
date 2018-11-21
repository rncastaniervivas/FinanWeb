package ar.edu.unlam.tallerweb1.servicios;

import java.util.List;

import ar.edu.unlam.tallerweb1.modelo.Financiera;

public interface ServicioFinanciera {
	
	List<Financiera> consultarFinanciera();
	
	void guardarFinanciera(Financiera financiera);
	
	List<Financiera> buscarFinanciera(Financiera financiera);
	
	void eliminarfinanciera(Financiera financiera);
	
	void modificarFinanciera(Financiera financiera);
	
	
}
