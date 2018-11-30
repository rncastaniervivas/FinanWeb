package ar.edu.unlam.tallerweb1.servicios;

import java.util.List;

import ar.edu.unlam.tallerweb1.modelo.Cuota;
import ar.edu.unlam.tallerweb1.modelo.Financiera;

public interface ServicioCuota {
	
	void insertarCuota(List<Cuota> cuotas);
	
	List<Cuota> consultarCuota(Long arefinanciar);
	
	List<Cuota> consultarCuotaDelUltimoPrestamo();

	List<Cuota> consultarPorFinanciera(Financiera financiera);
	
	List<Cuota> consultarCuotaPagada(Long arefinanciar);
	
	void modificarCubierto(Cuota cuota);
	
	Cuota consultarCuotaporId(Long idCuota);

}
