
package ar.edu.unlam.tallerweb1.persistencia;

import static org.junit.Assert.*;

import org.junit.Test;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.hibernate.SessionFactory;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;

import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unlam.tallerweb1.controladores.*;
import ar.edu.unlam.tallerweb1.dao.*;
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
		
		Prestamo prestamoMock=mock(Prestamo.class);
		//
		Financiera financieraMock=mock(Financiera.class);
		financieraMock.setIdFinanciera(1l);
		financieraMock.setNombre("Naranja");
		financieraMock.setMontoCapital(1000000);
		//
		prestamoMock.setAfiliado(afiliadoMock);
		prestamoMock.setCuotas(6);
		prestamoMock.setDni(9L);
		prestamoMock.setEstado("activo");
		prestamoMock.setInteres(2.00);
		prestamoMock.setValor(200);
		prestamoMock.setCuota(null);
		//
		prestamoMock.setFinanciera(financieraMock);
		
		List<Prestamo> prestamos=new ArrayList<Prestamo>();
		
		prestamos.add(prestamoMock);
		afiliadoMock.setApellido("ApellidoMock");
		afiliadoMock.setAntiguedad("10a�os");
		afiliadoMock.setDni(9L);
		afiliadoMock.setSueldo(10000.00);
		afiliadoMock.setClasificacion("cliente");
		afiliadoMock.setNombre("NombreMock");
		afiliadoMock.setPrestamo(prestamos);		
		
		servicioAfiliadoMock.guardarAfiliado(afiliadoMock);
		
		when(servicioAfiliadoMock.consultarAfiliadoDni(afiliadoMock.getDni())).thenReturn(afiliadoMock);
		
		when(servicioPrestamoMock.consultarPrestamo(afiliadoMock.getDni())).thenReturn(prestamos);
		
		when(servicioPrestamoMock.prestamoDisponible(afiliadoMock)).thenReturn(3000.00);
		
		ModelAndView modelo= controlador.irValidarNuevoPrestamo(afiliadoMock, 500,6, "Naranja");
		
		assertThat(modelo.getViewName()).isEqualTo("/listarprestamos");

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
		
		afiliadoMock.setApellido("ApellidoMock");
		afiliadoMock.setAntiguedad("10a�os");
		afiliadoMock.setDni(9L);
		afiliadoMock.setSueldo(100000.00);
		afiliadoMock.setClasificacion("cliente");
		afiliadoMock.setNombre("NombreMock");
		afiliadoMock.setNombre("NombreMock");
		List<Afiliado> afiliados=new ArrayList<Afiliado>();
		afiliados.add(afiliadoMock);
		afiliados.add(afiliadoMock);
		
		when(servicioAfiliadoMock.guardarAfiliado(afiliadoMock)).thenReturn(true);
		when(servicioAfiliadoMock.consultarAfiliado()).thenReturn(afiliados);
		ModelAndView modeloagregadoExitosamente=controladorAfiliado.agregadoAfiliadoExitoso(afiliadoMock);
		assertThat(modeloagregadoExitosamente.getViewName()).isEqualTo("listarafiliados");

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
		
		ServicioAfiliado servicioAfiliadoMock = mock(ServicioAfiliado.class);
		ServicioPrestamo servicioPrestamoMock = mock(ServicioPrestamo.class);
		ServicioRefinanciar servicioRefinanciarMock = mock(ServicioRefinanciar.class);

		controladorPrestamo.setServicioPrestamo(servicioPrestamoMock);
		controladorPrestamo.setServicioAfiliado(servicioAfiliadoMock);
		controladorPrestamo.setServicioRefinanciar(servicioRefinanciarMock);
		
		prestamoMock.setEstado("activo");
		prestamoMock.setDni(9L);
		
		Long idPrestamo = 1L;
		Long dni = 9L;
		when(servicioPrestamoMock.consultarUnPrestamo(prestamoMock.getIdPrestamo())).thenReturn(prestamoMock);
		when(servicioAfiliadoMock.consultarAfiliadoDni(dni)).thenReturn(null);
		when(servicioRefinanciarMock.consultaCuota(idPrestamo)).thenReturn(null);
		when(servicioRefinanciarMock.montoARefinanciar(idPrestamo)).thenReturn(null);
		
		ModelAndView modelo = controladorPrestamo.listaCuotasImpag(9L);
		
		//aca un assert  verificar que no exista esta cosa _> cuotas
	}
	
}