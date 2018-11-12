package ar.edu.unlam.tallerweb1.dao;

import java.util.List;

import javax.inject.Inject;

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import ar.edu.unlam.tallerweb1.modelo.Cuota;

@Repository("CuotaDao")
public class CuotaDaoImpl implements CuotaDao{
	
	@Inject
	private SessionFactory sessionFactory;

	@Override
	public void insertarCuota(List<Cuota> cuotas) {
		
		for (Cuota cuota : cuotas) {
			sessionFactory.getCurrentSession().save(cuota);
		}
	}
}
