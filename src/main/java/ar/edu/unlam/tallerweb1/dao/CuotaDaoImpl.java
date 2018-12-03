package ar.edu.unlam.tallerweb1.dao;

import java.util.List;

import javax.inject.Inject;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import ar.edu.unlam.tallerweb1.modelo.Cuota;
import ar.edu.unlam.tallerweb1.modelo.Financiera;

@Repository("CuotaDao")
public class CuotaDaoImpl implements CuotaDao{
	
	@Inject
	private SessionFactory sessionFactory;

	@Override
	public void insertarCuota(List<Cuota> cuotas) {
		
		for (Cuota cuota : cuotas) {
			sessionFactory.getCurrentSession().save(cuota);
		}
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Cuota> consultarCuota(Long arefinanciar) {
		return (sessionFactory.getCurrentSession()
				.createCriteria(Cuota.class)
				.createAlias("prestamo", "prestamoj")
				.add(Restrictions.eq("prestamoj.idPrestamo", arefinanciar))
				.add(Restrictions.eq("estado", false))
				.list());
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Cuota> consultarPorFinanciera(Financiera financiera) {
		return (sessionFactory.getCurrentSession().createCriteria(Cuota.class)
		.createAlias("prestamo","prestamojoin" )
		.createAlias("prestamojoin.financiera", "financierajoin")
		.add(Restrictions.eq("financierajoin.nombre", financiera.getNombre()))
		.add(Restrictions.eq("cubierto",false))
		.list());
		
		
	}

	@Override
	public void modificarElCubierto(Cuota cuota) {
		sessionFactory.getCurrentSession().update(cuota);
		
	}

	@Override
	public Cuota buscarCuota(Cuota cuota) {
		
		return (Cuota) (sessionFactory.getCurrentSession().createCriteria(Cuota.class)
				.add(Restrictions.eq("idCuota",cuota.getIdCuota()))
				.uniqueResult());
	}
	
	
}
