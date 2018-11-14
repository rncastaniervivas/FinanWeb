package ar.edu.unlam.tallerweb1.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import ar.edu.unlam.tallerweb1.modelo.*;

// Interface que define los metodos del DAO de Usuarios.
public interface AfiliadoDao {
	
	Afiliado consultarAfiliado(Afiliado afiliado);
	
	List<Afiliado> consultarListaAfiliado();
	
	Afiliado consultarIdAfiliado(Long id);
	
	
//	List<Prestamo> listarPrestamos(Long id);
}
/*
 * 
	@Override
	public List<Prestamo> buscarPrestamos(Long id){
		final Session session = sessionFactory.getCurrentSession();
		return session.createCriteria(Prestamo.class)
				.createAlias("afiliado", "afiliadojoin")
				.add(Restrictions.eq("afiliadojoin",id)
				.list();
	}
 */
