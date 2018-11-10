package ar.edu.unlam.tallerweb1.dao;

import java.util.List;

import javax.inject.Inject;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import ar.edu.unlam.tallerweb1.modelo.Prestamo;

@Repository("PrestamoDao")
public class PrestamoDaoImpl implements PrestamoDao {
	
	@Inject
	private SessionFactory sessionFactory;
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Prestamo> consultarPrestamo() {
		return (sessionFactory.getCurrentSession()
				.createCriteria(Prestamo.class)
				.add(Restrictions.isNotNull("monto"))
				.list());
	}
}
