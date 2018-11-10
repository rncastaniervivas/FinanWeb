package ar.edu.unlam.tallerweb1.modelo;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Cuota {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idCuota;
	private Double monto;
	private Double interes;
	private boolean estado;
	private Date fechaDePago;
	private Date fechaDeVencimiento;
	
	@ManyToOne
	private Prestamo prestamo;

	public Long getIdCuota() {
		return idCuota;
	}

	public void setIdCuota(Long idCuota) {
		this.idCuota = idCuota;
	}

	public Double getMonto() {
		return monto;
	}

	public void setMonto(Double monto) {
		this.monto = monto;
	}

	public Double getInteres() {
		return interes;
	}

	public void setInteres(Double interes) {
		this.interes = interes;
	}

	public boolean isEstado() {
		return estado;
	}

	public void setEstado(boolean estado) {
		this.estado = estado;
	}

	public Date getFechaDePago() {
		return fechaDePago;
	}

	public void setFechaDePago(Date fechaDePago) {
		this.fechaDePago = fechaDePago;
	}

	public Date getFechaDeVencimiento() {
		return fechaDeVencimiento;
	}

	public void setFechaDeVencimiento(Date fechaDeVencimiento) {
		this.fechaDeVencimiento = fechaDeVencimiento;
	}

	public Prestamo getPrestamo() {
		return prestamo;
	}

	public void setPrestamo(Prestamo prestamo) {
		this.prestamo = prestamo;
	}
	
}
