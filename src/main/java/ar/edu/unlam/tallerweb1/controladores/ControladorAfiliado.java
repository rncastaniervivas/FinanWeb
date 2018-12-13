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
import ar.edu.unlam.tallerweb1.modelo.Financiera;
import ar.edu.unlam.tallerweb1.modelo.Prestamo;
import ar.edu.unlam.tallerweb1.servicios.ServicioAfiliado;
import ar.edu.unlam.tallerweb1.servicios.ServicioPrestamo;

@Controller
public class ControladorAfiliado {
	
	@Inject 
	private ServicioAfiliado servicioAfiliado;
	
	@Inject
	private ServicioPrestamo servicioPrestamo;
	
	@RequestMapping ("/agregarafiliado")
	public ModelAndView irAAgregarAfiliado() {
		ModelMap modelo = new ModelMap();
		Afiliado afiliado = new Afiliado();
		modelo.put("afiliado", afiliado);
		return new ModelAndView("agregarafiliado", modelo);
		
	}
	
	@RequestMapping (path = "/afiliadoagregado", method = RequestMethod.POST)
	public ModelAndView agregadoExitosamente (@ModelAttribute("afiliado") Afiliado agregarafiliado) {
		ModelMap modelo=new ModelMap();
		Afiliado afiliado=new Afiliado();
		modelo.put("afiliado", afiliado);
		
		if(servicioAfiliado.guardarAfiliado(agregarafiliado)) {
			
		List<Afiliado> lista =servicioAfiliado.consultarAfiliado();
		
		modelo.put("afiliados", lista);
		
		return new ModelAndView("listarafiliados",modelo);
		
		}else {
			
			modelo.put("error", "Ya existe un Afiliado con ese DNI");
			
		}
		return new ModelAndView ("agregarafiliado",modelo);
	}
	
	@RequestMapping (path ="/modificarafiliado", method = RequestMethod.POST)
	public ModelAndView afiliadoAModificar(@ModelAttribute ("afiliado") Afiliado amAfil) {
		ModelMap modelo = new ModelMap();
		Afiliado afiliado = new Afiliado();
		Afiliado afiliam = amAfil;
		
		modelo.put("afili", afiliam);
		modelo.put("afiliado", afiliado);
		return new ModelAndView("modificarafiliado", modelo);
	}
//	@RequestMapping(path="/modificarafiliado", method=RequestMethod.POST)
//	public ModelAndView amodificar(@ModelAttribute("afiliado")Afiliado amAfiliado){
//		ModelMap modelo=new ModelMap();
//		Afiliado afiliado=new Afiliado();
//		Afiliado amfinan=amAfiliado;
//		modelo.put("afil", amfinan);
//		modelo.put("afiliado", afiliado);
//		return new ModelAndView("modificarfinanciera",modelo);
//	}
	
	@RequestMapping(path="/amodificado", method=RequestMethod.POST)
	public ModelAndView financieramodificada(@ModelAttribute("afiliado")Afiliado mafiliado) {
		ModelMap modelo=new ModelMap();
		Afiliado afiliado=new Afiliado();
		modelo.put("afiliado", afiliado);
		
		if(servicioAfiliado.modificarAfiliado(mafiliado)==false) {
		modelo.put("error","ya existe Afiliado");
		modelo.put("afiliado", mafiliado);
		return new ModelAndView ("modificarafiliado",modelo);
		}
		
		List<Afiliado> lista =servicioAfiliado.consultarAfiliado();
		modelo.put("afiliados", lista);		
		return new ModelAndView("listarafiliados",modelo);	
	
	}
	
	@RequestMapping (path = "/eliminarafiliado", method = RequestMethod.POST)
	public ModelAndView afiliadoEliminado(@ModelAttribute ("afiliado") Afiliado afiliaeliminar) {
		ModelMap modelo = new ModelMap();
		Afiliado afiliado = new Afiliado();

		if(servicioAfiliado.eliminarAfiliado(afiliaeliminar) == false) {
			modelo.put("error", "No se puede eliminar debido a que el afiliado tiene prestamo asignado");
		}
		
		List<Afiliado> lista = servicioAfiliado.consultarAfiliado();
		modelo.put("afiliados", lista);
		modelo.put("afiliado", afiliado);
		
		return new ModelAndView("listarafiliados", modelo);
	}
	

	@RequestMapping (path = "/buscarafiliado", method = RequestMethod.POST)
	public ModelAndView irABuscarAfiliado(Long dni) {
		ModelMap modelo = new ModelMap();
		List<Prestamo> prestamos= servicioPrestamo.consultarPrestamo(dni);
		Afiliado afiliado = new Afiliado();
		afiliado = servicioAfiliado.consultarAfiliadoDni(dni);
		modelo.put("afiliado", afiliado);
		modelo.put("prestamos", prestamos);
		return new ModelAndView("listarprestamos",modelo);
	}
	
	@RequestMapping ("/listarafiliados")
	public ModelAndView listarAfiliado() {
		ModelMap modelo = new ModelMap();
		Afiliado afiliado = new Afiliado();
		
		List<Afiliado> afiliados = servicioAfiliado.consultarAfiliado();
		modelo.put("afiliado", afiliado);
		modelo.put("afiliados",afiliados);
		
		return new ModelAndView("listarafiliados", modelo);
	}

	public ServicioAfiliado getServicioAfiliado() {
		return servicioAfiliado;
	}

	public void setServicioAfiliado(ServicioAfiliado servicioAfiliado) {
		this.servicioAfiliado = servicioAfiliado;
	}
	
	
}
