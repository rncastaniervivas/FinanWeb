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
				.add(Restrictions.isNotNull("nombre"))
				.list());
	}

	@Override
	public void guardarFinanciera(Financiera financiera) {
		sessionFactory.getCurrentSession().save(financiera);
		
	}

	@Override
	public List<Financiera> buscarFinanciera(Financiera financiera) {
		return (sessionFactory.getCurrentSession().createCriteria(Financiera.class)
		.add(Restrictions.eq("nombre",financiera.getNombre()))
		.list());
		
	
	}

	@Override
	public void eliminarfinanciera(Financiera financiera) {
		sessionFactory.getCurrentSession().delete(financiera);
		
	}

	@Override
	public void modificarFinanciera(Financiera financiera) {
		sessionFactory.getCurrentSession().update(financiera);
		
	}
}
