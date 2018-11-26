package ar.edu.unlam.tallerweb1.dao;

import java.util.List;

import javax.inject.Inject;

import org.hibernate.Session;
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
				.list());
	}
	
	@Override
	public Prestamo consultarUnPrestamo(Long idPrestamo){
		final Session session = sessionFactory.getCurrentSession();
		return (Prestamo) session.createCriteria(Prestamo.class)
				.add(Restrictions.eq("idPrestamo", idPrestamo))
				.uniqueResult();
	}
	
	@Override
	public void crearNuevoPrestamo(Prestamo prestmoRef) {
		sessionFactory.getCurrentSession().save(prestmoRef);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Prestamo> consultarPrestamo(Long dni) {
		return (sessionFactory.getCurrentSession()
				.createCriteria(Prestamo.class)
				.createAlias("afiliado", "afiliadoj")
				.add(Restrictions.eq("afiliadoj.dni", dni))
				.list());
	}
	
	@Override
	public void modificarPrestamo(Prestamo prestamo) {
		sessionFactory.getCurrentSession().update(prestamo);
	}
}
