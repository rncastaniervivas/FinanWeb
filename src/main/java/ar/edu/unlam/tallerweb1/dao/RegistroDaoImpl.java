package ar.edu.unlam.tallerweb1.dao;

import javax.inject.Inject;

import org.hibernate.SessionFactory;
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

}
