package ar.edu.unlam.tallerweb1.modelo;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Financiera {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idFinanciera;
	private String nombre;
	@OneToMany
	private List<Prestamo> pestamos;
	
	public Long getIdFinanciera() {
		return idFinanciera;
	}
	public void setIdFinanciera(Long idFinanciera) {
		this.idFinanciera = idFinanciera;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public List<Prestamo> getPestamos() {
		return pestamos;
	}
	public void setPestamos(List<Prestamo> pestamos) {
		this.pestamos = pestamos;
	}
	
	

}
