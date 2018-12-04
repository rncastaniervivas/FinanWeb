package ar.edu.unlam.tallerweb1.dao;

import java.util.List;

import ar.edu.unlam.tallerweb1.modelo.Cuota;
import ar.edu.unlam.tallerweb1.modelo.Financiera;

public interface CuotaDao {
	void insertarCuota(List<Cuota> cuotas);
	
	List<Cuota> consultarCuota(Long arefinanciar);
	
	List<Cuota> consultarCuotaDelUltimoPrestamo();
 
	List<Cuota> consultarPorFinanciera(Financiera financiera);
	
	void modificarElCubierto(Cuota cuota);

	List<Cuota> consultarCuotaPagada(Long arefinanciar);
	
	List<Cuota> consultarCuotaImpagas(Long idPrestamo);
	
	Cuota consultarCuotaporId(Long idCuota);
	
	boolean consultarCuotaPendiente(Long idPrestamo);
}
