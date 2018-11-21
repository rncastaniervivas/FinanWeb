package ar.edu.unlam.tallerweb1.dao;

import java.util.List;

import ar.edu.unlam.tallerweb1.modelo.Financiera;

public interface FinancieraDao {
	List<Financiera> consultarFinanciera();
	
	void guardarFinanciera(Financiera financiera);
	
	List<Financiera> buscarFinanciera(Financiera financiera);
	
	void eliminarfinanciera(Financiera financiera);
	
	void modificarFinanciera(Financiera financiera);
	
}
