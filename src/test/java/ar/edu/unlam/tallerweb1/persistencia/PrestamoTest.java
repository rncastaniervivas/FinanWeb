//package ar.edu.unlam.tallerweb1.persistencia;
//
//import static org.junit.Assert.*;
//
//import org.junit.Test;
//
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpSession;
//
//import org.hibernate.SessionFactory;
//
//import static org.assertj.core.api.Assertions.assertThat;
//import static org.mockito.Mockito.*;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import org.springframework.test.annotation.Rollback;
//import org.springframework.transaction.annotation.Transactional;
//import org.springframework.web.servlet.ModelAndView;
//
//import ar.edu.unlam.tallerweb1.controladores.*;
//import ar.edu.unlam.tallerweb1.dao.*;
//import ar.edu.unlam.tallerweb1.modelo.*;
//import ar.edu.unlam.tallerweb1.servicios.*;
//
//public class PrestamoTest {
//	
//	@Test
//	@Transactional
//	@Rollback (true)
//	public void testPruebaQueSeValidoUnPrestamo() {
//		
//		ControladorPrestamo controlador = new ControladorPrestamo();
//		
//		ServicioPrestamo servicioPrestamoMock=mock(ServicioPrestamo.class);
//		ServicioAfiliado servicioAfiliadoMock=mock(ServicioAfiliado.class);
//		
//		controlador.setServicioAfiliado(servicioAfiliadoMock);
//		controlador.setServicioPrestamo(servicioPrestamoMock);
//		
//		Afiliado afiliadoMock=mock(Afiliado.class);
//		
//		Prestamo prestamoMock=mock(Prestamo.class);
//		//
//		Financiera financieraMock=mock(Financiera.class);
//		financieraMock.setIdFinanciera(1l);
//		financieraMock.setNombre("Naranja");
//		financieraMock.setMontoCapital(1000000);
//		//
//		prestamoMock.setAfiliado(afiliadoMock);
//		prestamoMock.setCuotas(6);
//		prestamoMock.setDni(9L);
//		prestamoMock.setEstado("activo");
//		prestamoMock.setInteres(2.00);
//		prestamoMock.setValor(200);
//		prestamoMock.setCuota(null);
//		//
//		prestamoMock.setFinanciera(financieraMock);
//		
//		List<Prestamo> prestamos=new ArrayList<Prestamo>();
//		
//		prestamos.add(prestamoMock);
//		afiliadoMock.setApellido("ApellidoMock");
//		afiliadoMock.setAntiguedad("10años");
//		afiliadoMock.setDni(9L);
//		afiliadoMock.setSueldo(10000.00);
//		afiliadoMock.setClasificacion("cliente");
//		afiliadoMock.setNombre("NombreMock");
//		afiliadoMock.setPrestamo(prestamos);		
//		
//		servicioAfiliadoMock.guardarAfiliado(afiliadoMock);
//		
//		when(servicioAfiliadoMock.consultarAfiliadoDni(afiliadoMock.getDni())).thenReturn(afiliadoMock);
//		
//		when(servicioPrestamoMock.consultarPrestamo(afiliadoMock.getDni())).thenReturn(prestamos);
//		
//		when(servicioPrestamoMock.prestamoDisponible(afiliadoMock)).thenReturn(3000.00);
//		
//		ModelAndView modelo= controlador.irValidarNuevoPrestamo(afiliadoMock, 500,6, "Naranja");
//		
//		
//		assertThat(modelo.getViewName()).isEqualTo("/listarprestamos");
//		
//		
//	}
//
//}
//
