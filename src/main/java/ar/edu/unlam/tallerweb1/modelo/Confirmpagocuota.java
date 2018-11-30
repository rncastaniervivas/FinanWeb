package ar.edu.unlam.tallerweb1.modelo;
import java.util.List;

public class Confirmpagocuota {
	
	private List<String> check;
	private Long dni;
	private Long idPrestamo;
	
	
	public List<String> getCheck() {
		return check;
	}
	
	public void setCheck(List<String> check) {
		this.check = check;
	}

	public Long getDni() {
		return dni;
	}

	public void setDni(Long dni) {
		this.dni = dni;
	}

	public Long getIdPrestamo() {
		return idPrestamo;
	}

	public void setIdPrestamo(Long idPrestamo) {
		this.idPrestamo = idPrestamo;
	}
}
