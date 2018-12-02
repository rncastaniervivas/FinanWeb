package ar.edu.unlam.tallerweb1.persistencia;

import static org.junit.Assert.*;

import org.junit.Test;

package ar.edu.unlam.tallerweb1.persistencia;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.hibernate.SessionFactory;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unlam.tallerweb1.controladores.*;
import ar.edu.unlam.tallerweb1.modelo.*;
import ar.edu.unlam.tallerweb1.servicios.*;

public class PrestamoTest {
	
	@Test
	@Transactional
	@Rollback (true)
	public void testPruebaQueSeCreoUnPrestamo() {
		
		ControladorPrestamo controlador = new ControladorPrestamo();
		
		HttpSession httpMock = mock (HttpSession.class);
		
		HttpServletRequest httpRequestMock = mock(HttpServletRequest.class);
		
//		ServicioLogin servicioLoginMock = mock(ServicioLogin.class);
		ServicioPrestamo servicioPrestamoMock=mock(ServicioPrestamo.class);
		
//		Usuario usuarioMock = mock(Usuario.class);
		Prestamo prestamoMock=mock(Prestamo.class);

		
		
		
//		ModelAndView modelo = controlador.validarLogin(usuarioMock, httpRequestMock);
		
//		assertThat(modelo.getViewName()).isEqualTo("login");
		
	}

}

