package ar.edu.unlam.tallerweb1.controladores;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unlam.tallerweb1.modelo.Caja;
import ar.edu.unlam.tallerweb1.modelo.Registro;
import ar.edu.unlam.tallerweb1.servicios.ServicioCaja;
import ar.edu.unlam.tallerweb1.servicios.ServicioRegistro;

@Controller
public class ControladorCaja {
	@Inject
	private ServicioRegistro servicioRegistro;
	@RequestMapping("/caja")
	public ModelAndView irAFinanapagar() {
		ModelMap modelo = new ModelMap();
		
		List<Registro> misReg=servicioRegistro.consultarTodosRegistros();
		modelo.put("registros", misReg);
		Double miCaja=servicioRegistro.montoDeIngresos();
		modelo.put("caja", miCaja);
		Double montoI=servicioRegistro.montoDeIngresos();
		Double montoE=servicioRegistro.montoDeEgresos();
		modelo.put("montoI", montoI);
		modelo.put("montoE", montoE);
		return new ModelAndView("caja",modelo);
	}

}
