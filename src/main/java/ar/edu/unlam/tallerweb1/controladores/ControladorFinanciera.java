package ar.edu.unlam.tallerweb1.controladores;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unlam.tallerweb1.modelo.Financiera;
import ar.edu.unlam.tallerweb1.servicios.ServicioFinanciera;

@Controller
public class ControladorFinanciera {
	
	@Inject
	private ServicioFinanciera servicioFinanciera;
	
	@RequestMapping("/financierapagar")
	public ModelAndView irAFinanapagar() {
		ModelMap modelo = new ModelMap();
		
		List<Financiera> financieras = servicioFinanciera.consultarFinanciera();
		modelo.put("financieras", financieras);
		
		return new ModelAndView("finanapagar",modelo);
	}
	
	@RequestMapping("/realizarpagoafinanciera")
	public ModelAndView irARealizarpagoafinanciera() {
		return new ModelAndView("realizarpagoafinan");
	}
}
