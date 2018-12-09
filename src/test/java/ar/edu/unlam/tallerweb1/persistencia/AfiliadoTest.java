//package ar.edu.unlam.tallerweb1.persistencia;
//
//import org.junit.Test;
//import org.springframework.test.annotation.Rollback;
//import org.springframework.transaction.annotation.Transactional;
//import org.springframework.web.servlet.ModelAndView;
//
//import ar.edu.unlam.tallerweb1.controladores.ControladorAfiliado;
//import ar.edu.unlam.tallerweb1.modelo.Afiliado;
//import ar.edu.unlam.tallerweb1.modelo.Prestamo;
//import ar.edu.unlam.tallerweb1.servicios.ServicioAfiliado;
//import ar.edu.unlam.tallerweb1.servicios.ServicioPrestamo;
//
//import static org.junit.Assert.*;
//import static org.assertj.core.api.Assertions.assertThat;
//import static org.mockito.Mockito.*;
//
//public class AfiliadoTest {
//	@Test
//	@Transactional
//	@Rollback (true)
//	public void testQueSeGeneraUnAfiliado() {
//		ControladorAfiliado controller = new ControladorAfiliado();
//		
//		ServicioAfiliado servicioAfiliadoMock = mock (ServicioAfiliado.class);
//		
//		controller.setServicioAfiliado(servicioAfiliadoMock);
//		
//		Afiliado afiliadoMock = mock (Afiliado.class);
//		
//		afiliadoMock.setNombre("AfiliadoPrueba");
//		afiliadoMock.setApellido("Perez");
//		afiliadoMock.setDni(30102103L);
//		afiliadoMock.setPuesto("Director");
//		afiliadoMock.setSueldo(40000.0);
//		afiliadoMock.setAntiguedad("23");
//		
//		servicioAfiliadoMock.guardarAfiliado(afiliadoMock);
//		
//		when(servicioAfiliadoMock.consultarAfiliadoDni(afiliadoMock.getDni())).thenReturn(afiliadoMock);
//		ModelAndView model = controller.agregadoExitosamente(afiliadoMock);
//		
//		assertThat(model.getViewName()).isEqualTo("listarafiliados");	
//	}
//	
//	@Test
//	@Transactional
//	@Rollback(true)
//	public void testQuePruebaEliminarUsuarioConPrestamo() {
//		ControladorAfiliado controller = new ControladorAfiliado();
//		
//		ServicioAfiliado servicioAfiliadoMock = mock (ServicioAfiliado.class);
//		ServicioPrestamo servicioPrestamoMock = mock (ServicioPrestamo.class);
//		
//		Afiliado afiliadoMock = mock (Afiliado.class);
//		Prestamo prestamoMock = mock(Prestamo.class);
//		
//		afiliadoMock.setNombre("Prueba");
//		afiliadoMock.setApellido("Mock");
//		afiliadoMock.setDni(123456L);
//		afiliadoMock.setAntiguedad("2");
//		afiliadoMock.setSueldo(10000.0);
//		
//		prestamoMock.setValor(1000);
//		prestamoMock.setCuotas(3);
//		
//		servicioAfiliadoMock.guardarAfiliado(afiliadoMock);
//		servicioPrestamoMock.crearNuevoPrestamo(prestamoMock);
//		
//	}
//
//}
