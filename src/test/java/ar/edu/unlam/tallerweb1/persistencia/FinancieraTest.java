package ar.edu.unlam.tallerweb1.persistencia;

import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unlam.tallerweb1.controladores.ControladorCaja;
import ar.edu.unlam.tallerweb1.controladores.ControladorFinanciera;
import ar.edu.unlam.tallerweb1.modelo.Afiliado;
import ar.edu.unlam.tallerweb1.modelo.Cuota;
import ar.edu.unlam.tallerweb1.modelo.Financiera;
import ar.edu.unlam.tallerweb1.modelo.Prestamo;
import ar.edu.unlam.tallerweb1.servicios.ServicioCuota;
import ar.edu.unlam.tallerweb1.servicios.ServicioFinanciera;
import ar.edu.unlam.tallerweb1.servicios.ServicioPrestamo;
import ar.edu.unlam.tallerweb1.servicios.ServicioRegistro;

import static org.mockito.Mockito.*;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;
public class FinancieraTest {

	@Test
	@Transactional
	@Rollback (true)
	public void testQueVerificaQueSePagaALaFinanciera() {
		ControladorFinanciera controlador=new ControladorFinanciera();
		
		ServicioFinanciera servicioFinancieraMock=mock(ServicioFinanciera.class);
		ServicioCuota servicioCuotaMock=mock(ServicioCuota.class);
		ServicioRegistro servicioRegistroMock=mock(ServicioRegistro.class);
		ServicioPrestamo servicioPrestamoMock=mock(ServicioPrestamo.class);
		
		Afiliado afiliadoMock=mock(Afiliado.class);
		afiliadoMock.setNombre("martin");
		
		Cuota cuotaMock=mock(Cuota.class);
		cuotaMock.setCubierto(false);
		cuotaMock.setMonto(1000);
		cuotaMock.setIdCuota(2l);
		
		List<Cuota> cuotas=new ArrayList<Cuota>();
		cuotas.add(cuotaMock);
		
		Financiera financieraMock=mock(Financiera.class);
		financieraMock.setIdFinanciera(1l);
		financieraMock.setNombre("Naranja");
		
		Prestamo prestamoMock=mock(Prestamo.class);
		prestamoMock.setValor(1000);
		prestamoMock.setIdPrestamo(1L);
		prestamoMock.setCuota(cuotas);
		prestamoMock.setFinanciera(financieraMock);
		cuotaMock.setPrestamo(prestamoMock);
		
		servicioCuotaMock.insertarCuota(cuotas);
		servicioPrestamoMock.crearNuevoPrestamo(afiliadoMock,prestamoMock.getValor(), 1,financieraMock.getNombre());
		servicioCuotaMock.modificarCubierto(cuotaMock);
		Long idPrestamo=null;
		String nombreF=null;
		servicioRegistroMock.insertarEgresos(cuotaMock, idPrestamo,nombreF);
		
		controlador.setServicioCuota(servicioCuotaMock);
		controlador.setServicioFinanciera(servicioFinancieraMock);
		controlador.setServicioRegistro(servicioRegistroMock);
	
		when(servicioFinancieraMock.guardarFinanciera(financieraMock)).thenReturn(true);
		
		when(servicioCuotaMock.consultarCuotaporId(cuotaMock.getIdCuota())).thenReturn(cuotaMock);
		
		when(servicioFinancieraMock.buscarFinancieraPorNombre("Naranja")).thenReturn(financieraMock);
		
		ModelAndView modelo=controlador.restarSaldo(cuotaMock, idPrestamo,nombreF);
		
		assertThat(modelo.getViewName()).isEqualTo("pagarfinancieras");
				
	}
	
	
	@Test
	@Transactional
	@Rollback (true)
	public void testQueVerificaQueSeAgregolafinanciera() {
		
		ControladorFinanciera controlador=new ControladorFinanciera();
		ServicioFinanciera servicioFinancieraMock=mock(ServicioFinanciera.class);
		
		Financiera financieraMock=mock(Financiera.class);
		financieraMock.setNombre("Dummy");
		financieraMock.setMontoCapital(100000);
				
		when(servicioFinancieraMock.guardarFinanciera(financieraMock)).thenReturn(true);
		
		controlador.setServicioFinanciera(servicioFinancieraMock);
		
		ModelAndView modelo=controlador.agregado(financieraMock);
		
		assertThat(modelo.getViewName()).isEqualTo("financiera");
		
	}
	
	@Test
	@Transactional
	@Rollback (true)
	public void testQueVerificaMontoCaja() {
		ControladorCaja controlador=new ControladorCaja();
		ServicioRegistro servicioRegistroMock=mock(ServicioRegistro.class);
		
		Double ingresos=500.0;
		Double egresos=100.0;
		controlador.setServicioRegistro(servicioRegistroMock);
		
		when(servicioRegistroMock.montoDeIngresos()).thenReturn(ingresos);
		
		when(servicioRegistroMock.montoDeEgresos()).thenReturn(egresos);
		
		when(servicioRegistroMock.montoCaja()).thenReturn(400.00);
		
		ModelAndView modelo=controlador.mostrarRegistrosCaja();
		
		assertThat(modelo.getModelMap().get("montoI")).isEqualTo(ingresos);
		
		assertThat(modelo.getModelMap().get("montoE")).isEqualTo(egresos);
		
		assertThat(modelo.getModelMap().get("caja")).isEqualTo(400.00);
	
		
		
		
	}
}
