package ar.edu.unlam.tallerweb1.modelo;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Prestamo {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idPrestamo;
	private Integer cuotas;
	private Integer valor;
	private double interes;
	private String estado; // si el prestamo fue cancelado, refinanciado u otros.
	
	@ManyToOne
	private Financiera financiera;
	
	@ManyToOne
	private Afiliado afiliado;
	
	@OneToMany(cascade = CascadeType.ALL)
	private List<Cuota> cuota;
	
	public Long getIdPrestamo() {
		return idPrestamo;
	}
	public void setIdPrestamo(Long id) {
		this.idPrestamo = id;
	}
	public Integer getCuotas() {
		return cuotas;
	}
	public void setCuotas(Integer cuotas) {
		this.cuotas = cuotas;
	}
	public Integer getValor() {
		return valor;
	}
	public void setValor(Integer valor) {
		this.valor = valor;
	}
	
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public Afiliado getAfiliado() {
		return afiliado;
	}
	public void setAfiliado(Afiliado afiliado) {
		this.afiliado = afiliado;
	}
	public Financiera getFinanciera() {
		return financiera;
	}
	public void setFinanciera(Financiera financiera) {
		this.financiera = financiera;
	}
	
	public double getInteres() {
		return interes;
	}
	public void setInteres(double interes) {
		this.interes = interes;
	}
	public List<Cuota> getCuota() {
		return cuota;
	}
	public void setCuota(List<Cuota> cuota) {
		this.cuota = cuota;
	}
	
}
