package ar.edu.unlam.tallerweb1.servicios;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.unlam.tallerweb1.dao.*;
import ar.edu.unlam.tallerweb1.modelo.*;

@Service("servicioCuota")
@Transactional
public class ServicioCuotaImpl implements ServicioCuota{
	
	@Inject
	private CuotaDao servicioCuotaDao;
	@Inject
	private ServicioRegistro servicioRegistro;
	@Inject
	private PrestamoDao servicioPrestamoDao;
	@Inject
	private AfiliadoDao servicioAfiliadoDao;
	@Inject
	private FinancieraDao servicioFinancieraDao;
	@Override
	public Cuota consultarCuotaporId(Long idCuota){
		return servicioCuotaDao.consultarCuotaporId(idCuota);
	}
	
	@Override
	public List<Cuota> consultarCuotaPagada(Long arefinanciar){
		return servicioCuotaDao.consultarCuotaPagada(arefinanciar);
	}
	@Override
	public void pagarCuotaSeleccionada(Confirmpagocuota confirm) {
		List<Long> idCuotas = new ArrayList<Long>();
		String doc= Long.toString(confirm.getDni());
		Cuota cuotaitem= new Cuota();
		Prestamo prestamo0=servicioPrestamoDao.consultarUnPrestamo(confirm.getIdPrestamo());
		double nuevosaldo=prestamo0.getSaldo();
		for(String item: confirm.getCheck()) {
			idCuotas.add(Long.parseLong(item));
			
		}
		for(Long item2: idCuotas) {
			cuotaitem=servicioCuotaDao.consultarCuotaporId(item2);
			cuotaitem.setEstado(true);
			cuotaitem.setCubierto(true);
			cuotaitem.setFechaDePago(new Date());
			servicioCuotaDao.modificarElCubierto(cuotaitem);
			servicioRegistro.insertarIngresos(cuotaitem, confirm.getIdPrestamo(), doc);
			nuevosaldo-=cuotaitem.getMonto();
			prestamo0.setSaldo(nuevosaldo);
		}
		
		List<Cuota> cuotaspagas=servicioCuotaDao.consultarCuotaPagada(prestamo0.getIdPrestamo());
		if(cuotaspagas.size()==prestamo0.getCuotas()) {
			prestamo0.setEstado("pagado");
		}
		servicioPrestamoDao.modificarPrestamo(prestamo0);
		
	}
	
	@Override
	public void insertarCuota(List<Cuota> cuotas){
		servicioCuotaDao.insertarCuota(cuotas);
	}
	
	@Override
	public List<Cuota> consultarCuota(Long arefinanciar) {
		
		return servicioCuotaDao.consultarCuota(arefinanciar);
	}
	
	@Override
	public List<Cuota> consultarPorFinanciera(Financiera financiera) {
		return servicioCuotaDao.consultarPorFinanciera(financiera);
	}

	@Override
	public void modificarCubierto(Cuota cuota) {
		servicioCuotaDao.modificarElCubierto(cuota);
		
	}

	@Override
	public Cuota buscarCuota(Cuota cuota) {
		servicioCuotaDao.buscarCuota(cuota);
		return null;
	}
		
	@Override
	public List<Cuota> consultarCuotaDelUltimoPrestamo() {
		return servicioCuotaDao.consultarCuotaDelUltimoPrestamo();
	}
	
	@Override
	public List<Cuota> consultarCuotaImpagas(Long idPrestamo){
		return servicioCuotaDao.consultarCuotaImpagas(idPrestamo);
	}


	@Override
	public boolean pagarporinput(double pago, Long idPrestamo) {
		Prestamo prestamo=servicioPrestamoDao.consultarUnPrestamo(idPrestamo);
		
		List<Cuota> listCuotas=servicioCuotaDao.consultarCuotaImpagas(idPrestamo);
		
		double saldo=prestamo.getSaldo();
		
		double pago1=pago;
		
//		String doc= Long.toString(prestamo.getDni());
//				servicioRegistro.insertarIngresos(cuotaitem, confirm.getIdPrestamo(), doc);
		
		if(saldo<pago1) {
			return false;
		}
		if(saldo==pago1) {
			prestamo.setSaldo(0.0);
			prestamo.setEstado("pagado");
			for(Cuota cuotaitem: listCuotas) {
				cuotaitem.setEstado(true);
				cuotaitem.setCubierto(true);
				cuotaitem.setFechaDePago(new Date());
				servicioCuotaDao.modificarElCubierto(cuotaitem);			
			}
			return true;
		}
		if(saldo>pago1) {			
			saldo-=pago1;
			prestamo.setSaldo(saldo);
			int cuotas = listCuotas.size();
			double porCientoInteres = prestamo.getInteres()/12;
			double valor = saldo;
			double cuota = fijarNumero(valor*((porCientoInteres*Math.pow(1+porCientoInteres, cuotas))/(Math.pow(1+porCientoInteres, cuotas)-1)),2);
			double salini=valor;
			double interes = fijarNumero(salini*porCientoInteres,2);
			double amortizacion = fijarNumero(cuota-interes,2);
			double salfin = salini-amortizacion;
			
			for(Cuota cuotaitem:listCuotas){
				cuotaitem.setInteres(interes);
				cuotaitem.setMonto(cuota);
				cuotaitem.setMontoTotal(amortizacion);//amortizacion
				
				salini=salfin;
				interes = fijarNumero(salini*porCientoInteres,2);
				amortizacion = fijarNumero(cuota-interes,2);
				salfin = fijarNumero(salini-amortizacion,2);
				
				servicioCuotaDao.modificarElCubierto(cuotaitem);
			}
			return true;
		}
		
		return false;
	}

	public static double fijarNumero(double numero, int digitos) {// para fijar el numero dependiendo de los digitos que se manden
        double resultado;
        resultado = numero * Math.pow(10, digitos);
        resultado = Math.round(resultado);
        resultado = resultado/Math.pow(10, digitos);
        return resultado;
    }

	
}
