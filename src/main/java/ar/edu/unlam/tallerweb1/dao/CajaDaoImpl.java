package ar.edu.unlam.tallerweb1.dao;

import javax.inject.Inject;

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import ar.edu.unlam.tallerweb1.modelo.Caja;

@Repository("CajadDao")
public class CajaDaoImpl implements CajaDao {
	
	@Inject
	private SessionFactory sessionFactory;

	@Override
	public Caja consultarCaja() {
		
		return (Caja) sessionFactory.getCurrentSession().createCriteria(Caja.class)
				.uniqueResult();
	}
}
