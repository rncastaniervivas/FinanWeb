package ar.edu.unlam.tallerweb1.modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Financiera {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idFinanciera;
	private String nombre;

}
