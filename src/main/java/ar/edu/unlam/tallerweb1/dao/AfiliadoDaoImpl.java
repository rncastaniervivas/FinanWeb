package ar.edu.unlam.tallerweb1.dao;

import ar.edu.unlam.tallerweb1.modelo.Afiliado;
import ar.edu.unlam.tallerweb1.modelo.Prestamo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import java.util.List;

import javax.inject.Inject;

// implelemtacion del DAO de usuarios, la anotacion @Repository indica a Spring que esta clase es un componente que debe
// ser manejado por el framework, debe indicarse en applicationContext que busque en el paquete ar.edu.unlam.tallerweb1.dao
// para encontrar esta clase.
@Repository("AfiliadoDao")
public class AfiliadoDaoImpl implements AfiliadoDao {

	// Como todo dao maneja acciones de persistencia, normalmente estará inyectado el session factory de hibernate
	// el mismo está difinido en el archivo hibernateContext.xml
	@Inject
    private SessionFactory sessionFactory;

	@Override
	public List<Afiliado> consultarAfiliado() {
		return (sessionFactory.getCurrentSession()
				.createCriteria(Afiliado.class)
				.add(Restrictions.isNotNull("nombre"))
				.list());
	}
	
	@Override
	public void agregarAfiliado (Afiliado afiliado) {
		sessionFactory.getCurrentSession().save(afiliado);
	}
	
	@Override
	public void modificarAfiliado(Afiliado afiliado) {
		sessionFactory.getCurrentSession().update(afiliado);
	}
	
	@Override
	public void eliminarAfiliado(Afiliado afiliado) {
		sessionFactory.getCurrentSession().delete(afiliado);
	}
	
	@Override
	public List<Afiliado> buscarAfiliado(Afiliado afiliado){
		return (sessionFactory.getCurrentSession().createCriteria(Afiliado.class)
				.add(Restrictions.eq("nombre", afiliado.getNombre()))
				.list());
	}
	
	@Override
	public Afiliado consultarAfiliado(Long idPrestamo) {
		final Session session = sessionFactory.getCurrentSession();
		return (Afiliado) session.createCriteria(Afiliado.class)
				.createAlias("prestamo", "prestamoj")
				.add(Restrictions.eq("prestamoj.idPrestamo", idPrestamo))
				.uniqueResult();
	}
	
	@Override
	public Afiliado consultarAfiliadoDni(Long dni) {
		final Session session = sessionFactory.getCurrentSession();
		return (Afiliado) session.createCriteria(Afiliado.class)
				.add(Restrictions.eq("dni", dni))
				.uniqueResult();
	}
	
//	@Override
//	public List<Prestamo> listarPrestamos(Long id) {
//		final Session session = sessionFactory.getCurrentSession();
//		List<Prestamo> nvaLista=session.createCriteria(Prestamo.class)
//				.createAlias("afiliado","afiliadojoin")
//				.add(Restrictions.eq("afiliadojoin.idAfiliado", id))
//				.list();
//		return nvaLista;
//	}
//	

	
	/*
	 * private List<Prestamo> buscarPrestamos(Long id) {
	
		List<Prestamo> nvaLista=getSession().createCriteria(Prestamo.class)
				.createAlias("afiliado","afiliadojoin")
				.add(Restrictions.eq("afiliadojoin.idAfiliado", id))
				.list();
		return nvaLista;
	}
	 */
}
