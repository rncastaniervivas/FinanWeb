package ar.edu.unlam.tallerweb1.controladores;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unlam.tallerweb1.modelo.Afiliado;
import ar.edu.unlam.tallerweb1.servicios.ServicioAfiliado;

@Controller
public class ControladorAfiliado {
	
	@Inject 
	private ServicioAfiliado servicioAfiliado;
	
	@RequestMapping ("/agregarafiliado")
	public ModelAndView irAAgregarAfiliado() {
		ModelMap modelo = new ModelMap();
		Afiliado afiliado = new Afiliado();
		
		modelo.put("afiliado", afiliado);
		return new ModelAndView("agregarafiliado", modelo);
		
	}
	
	@RequestMapping (path = "/afiliadoagregado", method = RequestMethod.POST)
	public ModelAndView agregadoExitosamente (@ModelAttribute("afiliado") Afiliado agregarafiliado) {
		ModelMap modelo = new ModelMap();
		Afiliado afiliado = new Afiliado();
		modelo.put("afiliado", afiliado);
		List<Afiliado> listafiliado = servicioAfiliado.buscarAfiliado(agregarafiliado);
		
		if(listafiliado.size() == 0) {
			servicioAfiliado.agregarAfiliado(agregarafiliado);
			List<Afiliado> lista = servicioAfiliado.consultarAfiliado();
			modelo.put("afiliado", lista);
			return new ModelAndView("afiliado", modelo);
		}
		else {
			modelo.put("error", "El afiliado que desea crear ya existe");
		}
		return new ModelAndView("agregarafiliado", modelo);
	}
	
	@RequestMapping (path ="/modificarafiliado", method = RequestMethod.POST)
	public ModelAndView afiliadoAModificar(@ModelAttribute ("afiliado") Afiliado afiliadoM) {
		ModelMap modelo = new ModelMap();
		Afiliado afiliado = new Afiliado();
		Afiliado afiliam = afiliadoM;
		
		modelo.put("afili", afiliam);
		modelo.put("afiliado", afiliado);
		return new ModelAndView("modificarafiliado", modelo);
	}
	
	@RequestMapping (path = "/afiliadomodificado", method = RequestMethod.POST)
	public ModelAndView afiliadoModificado(@ModelAttribute("afiliado") Afiliado mafiliado) {
		servicioAfiliado.modificarAfiliado(mafiliado);
		
		List<Afiliado> lista = servicioAfiliado.consultarAfiliado();
		ModelMap modelo = new ModelMap();
		modelo.put("afiliados", lista);
		
		Afiliado afiliado = new Afiliado();
		modelo.put("afiliado", afiliado);
		return new ModelAndView("afiliado", modelo);
	}
	
	@RequestMapping (path = "/eliminarafiliado", method = RequestMethod.POST)
	public ModelAndView afiliadoEliminado(@ModelAttribute ("afiliado") Afiliado afiliaeliminar) {
		ModelMap modelo = new ModelMap();
		Afiliado afiliado = new Afiliado();
		
		servicioAfiliado.eliminarAfiliado(afiliaeliminar);
		
		List<Afiliado> lista = servicioAfiliado.consultarAfiliado();
		modelo.put("afiliados", lista);
		modelo.put("afiliado", afiliado);
		
		return new ModelAndView("afiliado", modelo);
	}

}
