package ar.edu.unlam.tallerweb1.dao;

import java.util.List;

import ar.edu.unlam.tallerweb1.modelo.*;

// Interface que define los metodos del DAO de Usuarios.
public interface AfiliadoDao {
	
	List<Afiliado> consultarAfiliado();
	
	void guardarAfiliado (Afiliado afiliado);
	
	void modificarAfiliado(Afiliado afiliado);
	
	void eliminarAfiliado(Afiliado afiliado);
	
	List<Afiliado> buscarAfiliado(Afiliado afiliado);

	//Afiliado consultarAfiliado(Afiliado afiliado);
	
	Afiliado consultarAfiliado(Long idPrestamo);

	Afiliado consultarAfiliadoDni(Long dni);
	
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
