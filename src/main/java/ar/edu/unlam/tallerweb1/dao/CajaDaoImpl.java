package ar.edu.unlam.tallerweb1.dao;

import javax.inject.Inject;

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import ar.edu.unlam.tallerweb1.modelo.Caja;

@Repository("CajadDao")
public class CajaDaoImpl implements CajaDao {
	@Inject
	private SessionFactory sessionFactory;
	
	@SuppressWarnings("unchecked")
	@Override
	public void agregarCaja(Double agregar) {
		Caja miCaja= (Caja) sessionFactory.getCurrentSession().createCriteria(Caja.class)
				.uniqueResult();
		if(miCaja == null) {
			Caja cajaCero=new Caja();
			sessionFactory.getCurrentSession().save(cajaCero);
			Caja miCaja2= (Caja) sessionFactory.getCurrentSession().createCriteria(Caja.class)
					.uniqueResult();
			Double sumandoSaldo=agregar+miCaja2.getMonto();
			miCaja2.setMonto(sumandoSaldo);
			
			}else {
		Double sumandoSaldo=agregar+miCaja.getMonto();
		miCaja.setMonto(sumandoSaldo);
			}
		
	}

	@Override
	public void sacarCaja(Double sacar) {
		Caja miCaja= (Caja) sessionFactory.getCurrentSession().createCriteria(Caja.class)
				.uniqueResult();
		Double restandoSaldo=(-1*sacar)+miCaja.getMonto();
		miCaja.setMonto(restandoSaldo);

	}

	@Override
	public Double consultarCaja() {
	
		Caja miCaja=(Caja) sessionFactory.getCurrentSession().createCriteria(Caja.class)
			.uniqueResult();
		
		if(miCaja == null) {
			Caja cajaCero =new Caja();
			cajaCero.setMonto(0.0);
			sessionFactory.getCurrentSession().save(cajaCero);
			Caja miCaja2=(Caja) sessionFactory.getCurrentSession().createCriteria(Caja.class)
					.uniqueResult();
			return miCaja2.getMonto();
		
		}else {

		return miCaja.getMonto();
	}
	}
}
