package ar.edu.unlam.tallerweb1.persistencia;

import static org.junit.Assert.*;

import org.junit.Test;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.hibernate.SessionFactory;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unlam.tallerweb1.controladores.*;
import ar.edu.unlam.tallerweb1.dao.*;
import ar.edu.unlam.tallerweb1.modelo.*;
import ar.edu.unlam.tallerweb1.servicios.*;

public class PrestamoTest {
	
	@Test
	@Transactional
	@Rollback (true)
	public void testPruebaQueSeCreoUnPrestamo() {
		
		ControladorPrestamo controlador = new ControladorPrestamo();
		
		ServicioPrestamo servicioPrestamoMock=mock(ServicioPrestamo.class);
		
		Afiliado afiliadoMock=mock(Afiliado.class);
		
		afiliadoMock.setApellido("ApellidoMock");
		afiliadoMock.setAntiguedad("10años");
		afiliadoMock.setDni(9L);
		afiliadoMock.setSueldo(10000.00);
		afiliadoMock.setClasificacion("cliente");
		afiliadoMock.setNombre("NombreMock");
		afiliadoMock.setIdAfiliado(1L);

		when(servicioPrestamoMock.prestamoDisponible(afiliadoMock)).thenReturn(3000.00);
		
		ModelAndView modelo= controlador.irValidarNuevoPrestamo(afiliadoMock, 500,6);
		
		assertThat(modelo.getViewName()).isEqualTo("nuevoprestamo");
		
		
	}

}

