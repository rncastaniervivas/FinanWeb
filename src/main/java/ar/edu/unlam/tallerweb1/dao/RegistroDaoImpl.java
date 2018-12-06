package ar.edu.unlam.tallerweb1.dao;

import java.util.List;

import javax.inject.Inject;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import ar.edu.unlam.tallerweb1.modelo.Registro;

@Repository("RegistroDao")
public class RegistroDaoImpl implements RegistroDao {
	@Inject
	private SessionFactory sessionFactory;

	@Override
	public void agregarRegistro(Registro registro) {
		sessionFactory.getCurrentSession().save(registro);

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Registro> consultarRegistros() {
		
		return sessionFactory.getCurrentSession().createCriteria(Registro.class)
				.add(Restrictions.isNotNull("idRegistro"))
				.list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Registro> consultarEgresos() {
		return (sessionFactory.getCurrentSession().createCriteria(Registro.class)
			.add(Restrictions.isNotNull("egreso"))
			.list());
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Registro> consultarIngresos() {
		return (sessionFactory.getCurrentSession().createCriteria(Registro.class)
				.add(Restrictions.isNotNull("ingreso"))
				.list());
	}

}
