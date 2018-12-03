package ar.edu.unlam.tallerweb1.modelo;

import java.sql.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Caja {
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idCaja;
	private Double monto;
	
	@OneToMany (cascade=CascadeType.ALL)
	private List<Registro> registros;

	public Long getIdCaja() {
		return idCaja;
	}

	public void setIdCaja(long i) {
		this.idCaja = i;
	}

	public Double getMonto() {
		return monto;
	}

	public void setMonto(Double monto) {
		this.monto = monto;
	}

	public List<Registro> getRegistros() {
		return registros;
	}

	public void setRegistros(List<Registro> registros) {
		this.registros = registros;
	}
	
	@SuppressWarnings("null")
	public Double consultarMontoCaja(List<Registro> registro) {
		Double ingresos = null;
		Double egresos = null;
		for(Registro i: registro) {
			ingresos+=i.getIngreso();
			egresos+=i.getEgreso();
		}
	
	return ingresos-egresos;
	
	}
	
	
	
	
	
	
	

}
