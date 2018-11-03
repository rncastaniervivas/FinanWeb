package ar.edu.unlam.tallerweb1.modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Prestamo {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idPrestamo;
	private Integer cuotas;
	private Integer valor;
	
	@ManyToOne
	private Financiera financiera;
	
	@ManyToOne
	private Afiliado afiliado;
	
	public Long getId() {
		return idPrestamo;
	}
	public void setId(Long id) {
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
	
	
}
