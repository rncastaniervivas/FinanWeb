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

public class PrestamoTest {
	
	@Test
	@Transactional
	@Rollback (true)
	public void testPruebaQueSeCreoUnPrestamo() {
		
		ControladorAfiliado controladorAfiliado = new ControladorAfiliado();
		ControladorCaja controladorCaja=new ControladorCaja();
		ControladorFinanciera controladorFinanciera=new ControladorFinanciera();
		ControladorPrestamo controladorPrestamo=new ControladorPrestamo(); 
		
		ServicioPrestamo servicioPrestamoMock=mock(ServicioPrestamo.class);
		ServicioAfiliado servicioAfiliadoMock=mock(ServicioAfiliado.class);
		ServicioCaja servicioCajaMock=mock(ServicioCaja.class);
		ServicioCuota servicioCuotaMock=mock(ServicioCuota.class);
		ServicioFinanciera servicioFinancieraMock=mock(ServicioFinanciera.class);
		//

		controladorAfiliado.setServicioAfiliado(servicioAfiliadoMock);
		controladorAfiliado.setServicioPrestamo(servicioPrestamoMock);
		//
		
		Afiliado afiliadoMock=mock(Afiliado.class);
		
		afiliadoMock.setApellido("ApellidoMock");
		afiliadoMock.setAntiguedad("10años");
		afiliadoMock.setDni(9L);
		afiliadoMock.setSueldo(100000.00);
		afiliadoMock.setClasificacion("cliente");
		afiliadoMock.setNombre("NombreMock");
		afiliadoMock.setNombre("NombreMock");
		List<Afiliado> afiliados=new ArrayList<Afiliado>();
		afiliados.add(afiliadoMock);
		afiliados.add(afiliadoMock);
//		when(servicioAfiliadoMock.consultarAfiliadoDni(afiliadoMock.getDni())).thenReturn(afiliadoMock);
//		when(servicioPrestamoMock.prestamoDisponible(afiliadoMock)).thenReturn(3000.00);
		
		List<Prestamo> listaprestamovacia=new ArrayList<Prestamo>();
		Prestamo prestamoMockvacio= mock(Prestamo.class);
//		Prestamo prestamoMock= mock(Prestamo.class);
//		prestamoMock.setAfiliado(afiliadoMock);
//		prestamoMock.setCuotas(6);
//		prestamoMock.setDni(1L);
//		prestamoMock.setEstado("activo");
//		prestamoMock.set
		
		when(servicioAfiliadoMock.guardarAfiliado(afiliadoMock)).thenReturn(true);
		when(servicioAfiliadoMock.consultarAfiliado()).thenReturn(afiliados);
		ModelAndView modeloagregadoExitosamente=controladorAfiliado.agregadoExitosamente(afiliadoMock);
		assertThat(modeloagregadoExitosamente.getViewName()).isEqualTo("listarafiliados");
		
		when(servicioAfiliadoMock.eliminarAfiliado(afiliadoMock)).thenReturn(true);
		ModelAndView modeloafiliadoEliminado=controladorAfiliado.afiliadoEliminado(afiliadoMock);
		assertThat(modeloafiliadoEliminado.getViewName()).isEqualTo("listarafiliados");
		
/*
 if(valor <= servicioPrestamo.prestamoDisponible(afiliado)){
			Afiliado miafiliado = servicioAfiliado.consultarAfiliadoDni(afiliado.getDni());
			servicioPrestamo.crearNuevoPrestamo(afiliado, valor, cuotas,nombreF);
			List<Prestamo> prestamos = servicioPrestamo.consultarPrestamoActivos(miafiliado);
			modelo.put("afiliado", miafiliado);
			modelo.put("prestamos", prestamos);
			return new ModelAndView("/listarprestamos",modelo);
 */
		Integer valorprestamonuevo= 10000;
		Integer cuotas=6;
		String nombreF="Naranja";
		when(servicioAfiliadoMock.consultarAfiliadoDni(afiliadoMock.getDni())).thenReturn(afiliadoMock);
		when(servicioPrestamoMock.prestamoDisponible(afiliadoMock)).thenReturn(30000.00);
		when(servicioPrestamoMock.consultarPrestamoActivos(afiliadoMock)).thenReturn(listaprestamovacia);
		
		ModelAndView modelocrearPrestamo=controladorPrestamo.irValidarNuevoPrestamo(afiliadoMock, valorprestamonuevo, cuotas, nombreF);
		assertThat(modelocrearPrestamo.getViewName()).isEqualTo("listarprestamos");
		
		
		
		
	}
	@Test
	@Transactional
	@Rollback (true)
	public void testPruebaQueSeValidoUnPrestamo() {
		
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
		afiliadoMock.setAntiguedad("10años");
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

}

