package ar.edu.unlam.tallerweb1.controladores;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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
	// agregar financiera
	@RequestMapping("/agregarfinanciera")
	public ModelAndView seAgregafinanciera() {
		ModelMap modelo=new ModelMap();
		Financiera financiera =new Financiera();
		modelo.put("financiera", financiera);
		return new ModelAndView("agregarfinanciera",modelo);
	}
	
	@RequestMapping(path="/agregado", method=RequestMethod.POST)
	public ModelAndView agregado(@ModelAttribute("financiera") Financiera agregarfinanciera) {
		ModelMap modelo=new ModelMap();
		Financiera financiera=new Financiera();
		modelo.put("financiera", financiera);
		List<Financiera> mifinanciera=servicioFinanciera.buscarFinanciera(agregarfinanciera);
		if(mifinanciera.size() == 0) {
		servicioFinanciera.guardarFinanciera(agregarfinanciera);
		List<Financiera> lista =servicioFinanciera.consultarFinanciera();
		modelo.put("financieras", lista);
		return new ModelAndView("financiera",modelo);
		}else {
			modelo.put("error", "Ya existe financiera");
			
		}
		return new ModelAndView ("agregarfinanciera",modelo);
	}
	// buscar financiera fiannciera
	
	@RequestMapping(path="/encontrado", method=RequestMethod.POST)
	public ModelAndView encontrarFinanciera(@ModelAttribute("financiera")Financiera bfinanciera) {
		ModelMap modelo=new ModelMap();
		Financiera financiera=new Financiera();
		modelo.put("financiera", financiera);
		List<Financiera> lista=servicioFinanciera.consultarFinanciera();
		modelo.put("financieras", lista);
		List<Financiera> listab=servicioFinanciera.buscarFinanciera(bfinanciera);
		if(listab.size() != 0) {
		modelo.put("financieras", listab);	
		
		}else {
		modelo.put("error", "No se encotro la financiera");	
		}
		return new ModelAndView("financiera",modelo);
	}
	// financiera
	@RequestMapping("financiera")
	public ModelAndView abmfinanciera() {
		ModelMap modelo=new ModelMap();
		Financiera financiera=new Financiera();
		modelo.put("financiera", financiera);
		List<Financiera> lista=servicioFinanciera.consultarFinanciera();
		modelo.put("financieras",lista);
		return new ModelAndView("financiera",modelo);
		
		
	}
	
	// eliminar una financiera
	
	@RequestMapping(path="/eliminado", method=RequestMethod.POST)
	public ModelAndView financieraeliminada(@ModelAttribute("financiera")Financiera finan) {
		ModelMap modelo=new ModelMap();
		Financiera financiera=new Financiera();
	servicioFinanciera.eliminarfinanciera(finan);
	List<Financiera> lista=servicioFinanciera.consultarFinanciera();
	modelo.put("financieras",lista);
	modelo.put("financiera", financiera);
	return new ModelAndView("financiera",modelo);
	
	}
	//modificar fianciera
	@RequestMapping(path="/modificarfinanciera", method=RequestMethod.POST)
	public ModelAndView amodificar(@ModelAttribute("financiera")Financiera amFinanc){
		ModelMap modelo=new ModelMap();
		Financiera financiera=new Financiera();
		Financiera amfinan=amFinanc;
		modelo.put("finan", amfinan);
		modelo.put("financiera", financiera);
		return new ModelAndView("modificarfinanciera",modelo);
	}
	
	@RequestMapping(path="/modificado", method=RequestMethod.POST)
	public ModelAndView financieramodificada(@ModelAttribute("financiera")Financiera mfinanciera) {
		servicioFinanciera.modificarFinanciera(mfinanciera);
	
		List<Financiera> lista=servicioFinanciera.consultarFinanciera();
		ModelMap modelo=new ModelMap();
		modelo.put("financieras",lista);
		Financiera financiera=new Financiera();
		modelo.put("financiera", financiera);
		return new ModelAndView("financiera",modelo);	
		
	}
}
