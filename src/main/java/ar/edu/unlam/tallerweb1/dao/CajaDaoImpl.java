package ar.edu.unlam.tallerweb1.dao;

import javax.inject.Inject;

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import ar.edu.unlam.tallerweb1.modelo.Caja;
import ar.edu.unlam.tallerweb1.modelo.Cuota;
import ar.edu.unlam.tallerweb1.modelo.Registro;

@Repository("CajadDao")
public class CajaDaoImpl implements CajaDao {
	@Inject
	private SessionFactory sessionFactory;
	
	@SuppressWarnings("unchecked")
	@Override
	public void agregarCaja(Cuota cuotai) {
		
			
		
	}

	@Override
	public void sacarCaja(Cuota cuotae) {
		Caja miCaja= (Caja) sessionFactory.getCurrentSession().createCriteria(Caja.class)
				.uniqueResult();
		
		

	}

	@Override
	public Caja consultarCaja() {
	
//		Caja miCaja=(Caja) sessionFactory.getCurrentSession().createCriteria(Caja.class)
//			.uniqueResult();
//		
//		if(miCaja == null) {
//			Caja cajaCero =new Caja();
//			cajaCero.setMonto(0.0);
//			sessionFactory.getCurrentSession().save(cajaCero);
//			Caja miCaja2=(Caja) sessionFactory.getCurrentSession().createCriteria(Caja.class)
//					.uniqueResult();
//			return miCaja2.getMonto();
//		
//		}else {
//
//		return miCaja.getMonto();
//	}
		
		return (Caja) sessionFactory.getCurrentSession().createCriteria(Caja.class)
				.uniqueResult();
	}
}
