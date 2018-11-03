package ar.edu.unlam.tallerweb1.modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Afiliado {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idAfiliado;
	private String nombre;
	private String apellido;
	private String puesto;
	private String antiguedad;
	private Double sueldo;
	public Long getIdAfiliado() {
		return idAfiliado;
	}
	public void setIdAfiliado(Long idAfiliado) {
		this.idAfiliado = idAfiliado;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public String getPuesto() {
		return puesto;
	}
	public void setPuesto(String puesto) {
		this.puesto = puesto;
	}
	public String getAntiguedad() {
		return antiguedad;
	}
	public void setAntiguedad(String antiguedad) {
		this.antiguedad = antiguedad;
	}
	public Double getSueldo() {
		return sueldo;
	}
	public void setSueldo(Double sueldo) {
		this.sueldo = sueldo;
	}

}
