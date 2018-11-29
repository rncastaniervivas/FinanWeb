package ar.edu.unlam.tallerweb1.controladores;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unlam.tallerweb1.modelo.Cuota;
import ar.edu.unlam.tallerweb1.modelo.Financiera;
import ar.edu.unlam.tallerweb1.servicios.ServicioCaja;
import ar.edu.unlam.tallerweb1.servicios.ServicioCuota;
import ar.edu.unlam.tallerweb1.servicios.ServicioFinanciera;
import ar.edu.unlam.tallerweb1.servicios.ServicioPrestamo;

@Controller
public class ControladorFinanciera {
	
	@Inject
	private ServicioFinanciera servicioFinanciera;
	@Inject
	private ServicioCuota servicioCuota;
	@Inject
	private ServicioCaja servicioCaja;
	@Inject
	private ServicioPrestamo servicioPrestamo;
	
	@RequestMapping("/pagarfinancieras")
	public ModelAndView irAFinanapagar() {
		ModelMap modelo = new ModelMap();
		Financiera financiera =new Financiera();
		modelo.put("financiera", financiera);
		List<Financiera> financieras = servicioFinanciera.consultarFinanciera();
		Double montocaja=servicioCaja.consultarCaja();
		modelo.put("montocaja", montocaja);
		modelo.put("financieras", financieras);
		
		return new ModelAndView("pagarfinancieras",modelo);
	}
	
	@RequestMapping(path="/realizarpagoafinanciera", method=RequestMethod.POST)
	public ModelAndView cuotasAPagar(@ModelAttribute("financiera")Financiera financierac) {
		List<Cuota> cuotas=servicioCuota.consultarPorFinanciera(financierac);
		ModelMap modelo =new ModelMap();
		modelo.put("cuotas", cuotas);
		Double montocaja=servicioCaja.consultarCaja();
		modelo.put("montocaja", montocaja);
		Cuota cuota=new Cuota();
		modelo.put("cuota", cuota);
		Financiera financiera =new Financiera();
		modelo.put("financiera", financiera);
		List<Financiera> financieras = servicioFinanciera.consultarFinanciera();
		modelo.put("financieras", financieras);
		return new ModelAndView("pagarfinancieras",modelo);
	}
	
	@RequestMapping(path="restarsaldo",method=RequestMethod.POST)
	public ModelAndView restarSaldo(@ModelAttribute("cuota")Cuota cuotar) {
	servicioCaja.sacarCaja(cuotar.getMonto());//resta de la caja
	servicioCuota.modificarCubierto(cuotar);//modifica si la cuota esta cubierta
	ModelMap modelo =new ModelMap();
	Financiera financiera =new Financiera();
	modelo.put("financiera", financiera);
	List<Financiera> financieras = servicioFinanciera.consultarFinanciera();
	Double montocaja=servicioCaja.consultarCaja();
	modelo.put("montocaja", montocaja);
	modelo.put("financieras", financieras);
	Cuota cuota=new Cuota();
	modelo.put("cuota", cuota);

	return new ModelAndView ("pagarfinancieras",modelo);
	}
	
	// agregar financiera ////////////////////////////
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
	// buscar financiera financiera
	
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
		// escribir para que pregunte si tiene un prestamo antes de elminar
		boolean tienePrestamo=servicioPrestamo.consultarPorFinanciera(finan.getIdFinanciera());
		if(tienePrestamo == false) {
	servicioFinanciera.eliminarfinanciera(finan);
		}else {
			modelo.put("erroeliminar", "No se puede eliminar debido a que tiene prestamo");
		}
	List<Financiera> lista=servicioFinanciera.consultarFinanciera();
	modelo.put("financieras",lista);
	modelo.put("financiera", financiera);
	return new ModelAndView("financiera",modelo);
	
	}
	//modificar financiera
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
		ModelMap modelo=new ModelMap();
		List<Financiera> miFinan=servicioFinanciera.buscarFinanciera(mfinanciera);
		Financiera financiera=new Financiera();
		modelo.put("financiera", financiera);
		if(miFinan.size() != 0) {
		modelo.put("error","ya existe financiera");
		return new ModelAndView ("modificarfinanciera",modelo);
		}else {
		
		servicioFinanciera.modificarFinanciera(mfinanciera);
		List<Financiera> lista=servicioFinanciera.consultarFinanciera();
		modelo.put("financieras",lista);
		return new ModelAndView("financiera",modelo);	
		
	}
	
	}
}
