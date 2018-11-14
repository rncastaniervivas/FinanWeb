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
	public Afiliado consultarAfiliado(Afiliado afiliado) {
		final Session session = sessionFactory.getCurrentSession();
		return (Afiliado) session.createCriteria(Afiliado.class)
				.add(Restrictions.eq("idAfiliado", afiliado.getIdAfiliado()))
				.uniqueResult();
	}
	@Override
	public Afiliado consultarIdAfiliado(Long id) {
		final Session session = sessionFactory.getCurrentSession();
		return (Afiliado) session.createCriteria(Afiliado.class)
				.add(Restrictions.eq("idAfiliado", id))
				.uniqueResult();
	}
	
	@Override
	public List<Afiliado> consultarListaAfiliado() {
		return (sessionFactory.getCurrentSession()
				.createCriteria(Afiliado.class)
				.list());
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
		// TODO Auto-generated method stub
		List<Prestamo> nvaLista=getSession().createCriteria(Prestamo.class)
				.createAlias("afiliado","afiliadojoin")
				.add(Restrictions.eq("afiliadojoin.idAfiliado", id))
				.list();
		return nvaLista;
	}
	 */
}
