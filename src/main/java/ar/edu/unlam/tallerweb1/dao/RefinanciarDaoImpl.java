package ar.edu.unlam.tallerweb1.dao;

import java.util.List;

import javax.inject.Inject;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import ar.edu.unlam.tallerweb1.modelo.Cuota;

@Repository("RefinanciarDao")
public class RefinanciarDaoImpl implements RefinanciarDao {
	@Inject
	private SessionFactory sessionFactory;
	
	@SuppressWarnings("unchecked")

	@Override
	public List<Cuota> listaCuotas() {
		return (sessionFactory.getCurrentSession()
				.createCriteria(Cuota.class)
				.add(Restrictions.eq("estado", 1))
				.list());
	}

}
