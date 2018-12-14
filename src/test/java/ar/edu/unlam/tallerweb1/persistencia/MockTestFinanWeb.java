
package ar.edu.unlam.tallerweb1.persistencia;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;

import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unlam.tallerweb1.controladores.*;
import ar.edu.unlam.tallerweb1.modelo.*;
import ar.edu.unlam.tallerweb1.servicios.*;

public class MockTestFinanWeb {
	
	@Test
	@Transactional
	@Rollback (true)
	public void testValidarNuevoPrestamo() {
		
		ControladorPrestamo controlador = new ControladorPrestamo();
		
		ServicioPrestamo servicioPrestamoMock=mock(ServicioPrestamo.class);
		ServicioAfiliado servicioAfiliadoMock=mock(ServicioAfiliado.class);
		
		controlador.setServicioAfiliado(servicioAfiliadoMock);
		controlador.setServicioPrestamo(servicioPrestamoMock);
		
		Afiliado afiliadoMock=mock(Afiliado.class);
		Financiera financieraMock=mock(Financiera.class);
		List<Prestamo> prestamosMock=new ArrayList<Prestamo>();
		
		double valorPrestamoDisponible = 1000.0;
		Integer valor = 500;
		Integer cuotas = 6;
		
		when(servicioPrestamoMock.prestamoDisponible(afiliadoMock)).thenReturn(valorPrestamoDisponible);
		
		when(servicioAfiliadoMock.consultarAfiliadoDni(afiliadoMock.getDni())).thenReturn(afiliadoMock);
		
		when(servicioPrestamoMock.consultarPrestamoActivos(afiliadoMock)).thenReturn(prestamosMock);
		
		
		ModelAndView modelo= controlador.irValidarNuevoPrestamo(afiliadoMock, valor,cuotas, financieraMock.getNombre());
		
		assertThat(modelo.getModelMap().get("afiliado")).isEqualTo(afiliadoMock);
		
		assertThat(modelo.getViewName()).isEqualTo("/listarprestamos");
		
		assertThat(modelo.getModelMap().get("prestamos")).isEqualTo(prestamosMock);
	}
	
	@Test
	@Transactional
	@Rollback (true)
	public void testAgregadoAfiliadoExitoso() {
		
		ControladorAfiliado controladorAfiliado = new ControladorAfiliado(); 

		ServicioPrestamo servicioPrestamoMock=mock(ServicioPrestamo.class);
		ServicioAfiliado servicioAfiliadoMock=mock(ServicioAfiliado.class);
		//
		controladorAfiliado.setServicioAfiliado(servicioAfiliadoMock);
		controladorAfiliado.setServicioPrestamo(servicioPrestamoMock);
		//
		Afiliado afiliadoMock=mock(Afiliado.class);

		List<Afiliado> afiliadosMock=mock(List.class);
		
		when(servicioAfiliadoMock.guardarAfiliado(afiliadoMock)).thenReturn(true);
		
		when(servicioAfiliadoMock.consultarAfiliado()).thenReturn(afiliadosMock);
		
		ModelAndView modeloagregadoExitosamente = controladorAfiliado.agregadoAfiliadoExitoso(afiliadoMock);
		
		assertThat(modeloagregadoExitosamente.getViewName()).isEqualTo("listarafiliados");
		
		assertThat(modeloagregadoExitosamente.getModelMap().get("afiliados")).isEqualTo(afiliadosMock);

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
	
	@Test
	@Transactional
	@Rollback(true)
	public void testListarCuotasImpagas(){
		
		ControladorPrestamo controladorPrestamo = new ControladorPrestamo();
		
		Prestamo prestamoMock = mock(Prestamo.class);
		Afiliado afiliadoMock = mock(Afiliado.class);
		
		ServicioAfiliado servicioAfiliadoMock = mock(ServicioAfiliado.class);
		ServicioPrestamo servicioPrestamoMock = mock(ServicioPrestamo.class);
		ServicioRefinanciar servicioRefinanciarMock = mock(ServicioRefinanciar.class);

		controladorPrestamo.setServicioPrestamo(servicioPrestamoMock);
		controladorPrestamo.setServicioAfiliado(servicioAfiliadoMock);
		controladorPrestamo.setServicioRefinanciar(servicioRefinanciarMock);
		
		
		when(servicioPrestamoMock.consultarUnPrestamo(prestamoMock.getIdPrestamo())).thenReturn(prestamoMock);
		
		when(servicioAfiliadoMock.consultarAfiliado(prestamoMock.getIdPrestamo())).thenReturn(afiliadoMock);
		
		when(servicioRefinanciarMock.esPrestamoRefinanciado(prestamoMock.getIdPrestamo())).thenReturn(true);
		
		ModelAndView modelo = controladorPrestamo.listaCuotasImpag(afiliadoMock.getDni());
		
		assertThat(modelo.getModelMap().get("afiliado")).isEqualTo(afiliadoMock);
		
		assertThat(modelo.getModelMap().get("prestamo")).isEqualTo(prestamoMock);
		
		assertThat(modelo.getViewName()).isEqualTo("refinanciarerror");
	}
	
	@Test
	@Transactional
	@Rollback(true)
	public void testNuevoPrestamo(){

		ControladorPrestamo controladorPrestamo = new ControladorPrestamo();
		
		Afiliado afiliadoMock = mock(Afiliado.class);
		
		List<Financiera> financierasMock = mock(List.class);
		List<Prestamo> prestamosMock = mock(List.class);
		
		afiliadoMock.setAntiguedad("3");
		
		ServicioAfiliado servicioAfiliadoMock = mock(ServicioAfiliado.class);
		ServicioPrestamo servicioPrestamoMock = mock(ServicioPrestamo.class);
		ServicioFinanciera servicioFinancieraMock = mock(ServicioFinanciera.class);
		
		controladorPrestamo.setServicioPrestamo(servicioPrestamoMock);
		controladorPrestamo.setServicioAfiliado(servicioAfiliadoMock);
		controladorPrestamo.setServicioFinanciera(servicioFinancieraMock);
		
		double prestamoDisponible = 10.0;
		
		when(servicioAfiliadoMock.consultarAfiliadoDni(afiliadoMock.getDni())).thenReturn(afiliadoMock);
		when(servicioPrestamoMock.consultarPrestamo(afiliadoMock.getDni())).thenReturn(prestamosMock);
		when(servicioPrestamoMock.prestamoDisponible(afiliadoMock)).thenReturn(prestamoDisponible);
		when(servicioFinancieraMock.consultarFinanciera()).thenReturn(financierasMock);
		when(servicioAfiliadoMock.validarAfiliadoAntiguedad(afiliadoMock.getAntiguedad())).thenReturn(true);
		ModelAndView modelo = controladorPrestamo.NuevoPrestamo(afiliadoMock);
		
		assertThat(modelo.getViewName()).isEqualTo("nuevoprestamo");
		
		
	}
	
	
}



