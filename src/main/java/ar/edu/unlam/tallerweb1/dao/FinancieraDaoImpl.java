package ar.edu.unlam.tallerweb1.dao;

import java.util.List;

import javax.inject.Inject;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import ar.edu.unlam.tallerweb1.modelo.Financiera;

@Repository("financieraDao")
public class FinancieraDaoImpl implements FinancieraDao {
	
	@Inject
	private SessionFactory sessionFactory;
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Financiera> consultarFinanciera() {
		return (sessionFactory.getCurrentSession()
				.createCriteria(Financiera.class)
				.add(Restrictions.like("nombre","Galicia"))
				.list());
	}
}
