package ar.edu.unlam.tallerweb1.servicios;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.unlam.tallerweb1.dao.CajaDao;
import ar.edu.unlam.tallerweb1.dao.RegistroDao;
import ar.edu.unlam.tallerweb1.modelo.Caja;
import ar.edu.unlam.tallerweb1.modelo.Cuota;
import ar.edu.unlam.tallerweb1.modelo.Registro;

@Service("servicioCaja")
@Transactional
public class ServicioCajaImpl implements ServicioCaja {
	@Inject
	private CajaDao servicioCajaDao;
	@Inject
	private RegistroDao servicoRegistroDao;
	
	@Override
	public void agregarCaja(Cuota cuotai) {
		Caja miCaja= (Caja) sessionFactory.getCurrentSession().createCriteria(Caja.class)
				.uniqueResult();
		if(miCaja == null) {
			Caja cajaCero=new Caja();
			sessionFactory.getCurrentSession().save(cajaCero);//crea caja 
			
			Caja miCaja2= (Caja) sessionFactory.getCurrentSession().createCriteria(Caja.class)
					.uniqueResult();
			
			Registro nuevoReg=new Registro();
			nuevoReg.setCaja(cuotai);
			nuevoReg.setCuota(cuotai.getIdCuota());
			nuevoReg.setIngreso(cuotai.getMontoTotal());
			
		
	}
	@Override
	public void sacarCaja(Cuota cuotae) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public Double consultarCaja() {
		// TODO Auto-generated method stub
		return null;
	}

	

}
