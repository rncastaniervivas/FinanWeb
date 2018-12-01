package ar.edu.unlam.tallerweb1.controladores;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unlam.tallerweb1.modelo.Afiliado;
import ar.edu.unlam.tallerweb1.modelo.Confirmpagocuota;
import ar.edu.unlam.tallerweb1.modelo.Cuota;
import ar.edu.unlam.tallerweb1.modelo.Prestamo;
import ar.edu.unlam.tallerweb1.servicios.ServicioAfiliado;
import ar.edu.unlam.tallerweb1.servicios.ServicioCuota;
import ar.edu.unlam.tallerweb1.servicios.ServicioPrestamo;
import ar.edu.unlam.tallerweb1.servicios.ServicioRefinanciar;

@Controller
public class ControladorPrestamo {
	
	@Inject
	private ServicioPrestamo servicioPrestamo;
	
	@Inject
	private ServicioCuota servicioCuota;
	
	@Inject
	private ServicioAfiliado servicioAfiliado;
	
	@Inject
	private ServicioRefinanciar servicioRefinanciar;
	
	@RequestMapping("/listarprestamos")
	public ModelAndView listarPrestamo() {
		ModelMap modelo = new ModelMap();
		
		List<Prestamo> prestamos= servicioPrestamo.consultarPrestamoTodosLosAfiliados();
		
		modelo.put("prestamos", prestamos);
		return new ModelAndView("listarprestamos",modelo);
	}
	
	@RequestMapping(path="/misprestamos")
	public ModelAndView misprestamos(Long dni, HttpServletRequest request) {
		ModelMap modelo = new ModelMap();
		Long dni0=(Long) request.getSession().getAttribute("dni");
		List<Prestamo> prestamos= servicioPrestamo.consultarPrestamo(dni0);
		modelo.put("prestamos", prestamos);

		
		return new ModelAndView("listarprestamos",modelo);
	}
	@RequestMapping(path = "/cancelarprestamo", method = RequestMethod.POST)
	public ModelAndView cancelarprestamo(Long idPrestamo2) {
		
		Prestamo miprestamo= servicioPrestamo.consultarUnPrestamo(idPrestamo2);

		miprestamo.setEstado("pagado");
		miprestamo.setCuotas(0);
		miprestamo.setInteres(0);
		miprestamo.setValor(0);
		
		servicioPrestamo.modificarPrestamo(miprestamo);

		return new ModelAndView("redirect:/misprestamos");
		
	}
	@RequestMapping(path = "/pagarcuota", method = RequestMethod.POST)
	public ModelAndView pagarcuota(Long idPrestamo1) {
		ModelMap modelo = new ModelMap();
//		prestamo con afiliado si no es nulo ahi si lo trae
		
		List<Cuota> cuotasnopagas=servicioCuota.consultarCuota(idPrestamo1);
		List<Cuota> cuotaspagas=servicioCuota.consultarCuotaPagada(idPrestamo1);
		Prestamo prestamo0=servicioPrestamo.consultarUnPrestamo(idPrestamo1);
		Afiliado afiliado0=prestamo0.getAfiliado();
		
//		String codigohtml="";
//		codigohtml+=
		
		modelo.put("prestamo", prestamo0);
//		modelo.put("codigohtml", codigohtml);
		modelo.put("afiliado", afiliado0);
		
		modelo.put("cuotaspagas", cuotaspagas);
		
		modelo.put("cuotasnopagas", cuotasnopagas);		

		return new ModelAndView("confirmarpagocuota",modelo);
		
	}

	@RequestMapping(path = "/finalizarpagocuota", method=RequestMethod.POST)
	public ModelAndView finalizarpagocuota(@ModelAttribute("confirm") Confirmpagocuota confirm,HttpServletRequest request) {
		ModelMap modelo= new ModelMap();
		
		List<Long> idCuotas = new ArrayList<Long>();
		
		Cuota cuotaitem= new Cuota();
		
		for(String item: confirm.getCheck()) {
			idCuotas.add(Long.parseLong(item));
			
		}
		
		for(Long item2: idCuotas) {
			cuotaitem=servicioCuota.consultarCuotaporId(item2);
			cuotaitem.setEstado(true);
			cuotaitem.setFechaDePago(new Date());
			servicioCuota.modificarCubierto(cuotaitem);
		}
		
		Prestamo prestamo0=servicioPrestamo.consultarUnPrestamo(confirm.getIdPrestamo());
		
		List<Cuota> cuotaspagas=servicioCuota.consultarCuotaPagada(prestamo0.getIdPrestamo());
		if(cuotaspagas.size()==prestamo0.getCuotas()) {
			prestamo0.setEstado("pagado");
		}
		servicioPrestamo.modificarPrestamo(prestamo0);
		return new ModelAndView("redirect:/listarprestamos");
	}
		@RequestMapping(path = "/totalapagarcuota", method=RequestMethod.POST)
		public ModelAndView totalapagarcuota(@ModelAttribute("confirm") Confirmpagocuota confirm,HttpServletRequest request) {
			
		ModelMap modelo = new ModelMap();
		
		List<Long> idCuotas = new ArrayList<Long>();
		List<Cuota> cuotasnopagas= new ArrayList<Cuota>();
		
		double contcuota=0.0;
		Cuota cuotaitem= new Cuota();
		
		for(String item: confirm.getCheck()) {
			idCuotas.add(Long.parseLong(item));
			
		}
		for(Long item2: idCuotas) {
			cuotaitem=servicioCuota.consultarCuotaporId(item2);
			cuotasnopagas.add(cuotaitem);
			contcuota+=cuotaitem.getMonto();
		}
		
		Afiliado afiliado0=servicioAfiliado.consultarAfiliadoDni(confirm.getDni());
		Prestamo prestamo0=servicioPrestamo.consultarUnPrestamo(confirm.getIdPrestamo());
		
		modelo.put("cuotasnopagas", cuotasnopagas);
		modelo.put("prestamo", prestamo0);
		modelo.put("idCuotas", idCuotas);
		modelo.put("afiliado", afiliado0);
		modelo.put("totalcuota", contcuota);
		modelo.put("montoprestamo", prestamo0.getValor());
		modelo.put("dnitot", confirm.getDni());
		
		return new ModelAndView("totalcuotapaga",modelo);
		
		
	}
	
	@RequestMapping(path = "/refinanciar", method = RequestMethod.POST)
	public ModelAndView listaCuotasImpag(Long idPrestamo) {
		ModelMap modelo=new ModelMap();
		List<Cuota> impagas=servicioRefinanciar.consultaCuota(idPrestamo);
		Afiliado afiliado = servicioAfiliado.consultarAfiliado(idPrestamo);
		Double montoTotalARefinanciar = servicioRefinanciar.montoARefinanciar(idPrestamo);
		
		int cuotasRestante = impagas.size();
		
	    modelo.put("afiliado", afiliado);
	    modelo.put("idPrestamoRef", idPrestamo);
		modelo.put("cuotas", impagas);	
		modelo.put("MontoARefinanciar", montoTotalARefinanciar);
		modelo.put("cuotasRestante",cuotasRestante);
		return new ModelAndView("refinanciar",modelo);
	
	}

	@RequestMapping(path = "/hacer-refinanciacion", method = RequestMethod.POST)
	public ModelAndView refinanciarAlta(Long dni, Long idPrestamoRef, double newCapital, Integer cuotas, double interes) {
		ModelMap modelo = new ModelMap();
		
		servicioRefinanciar.refinanciar(dni, idPrestamoRef, newCapital, cuotas, interes);
		
		List<Cuota> nueCuotas = servicioCuota.consultarCuotaDelUltimoPrestamo();
		modelo.put("cuotas", nueCuotas);
		return new ModelAndView("listarcuotas",modelo);
	}
	
	// Lo uso solo para mostrar las cuotas del nuevo prestamo.
	@RequestMapping("/ultimoprestamo")
	public ModelAndView irAListarcuotasDeUltimoPrestamo() {

		ModelMap modelo=new ModelMap();
		List<Cuota> cuotasDelUltimoPrestamo = servicioCuota.consultarCuotaDelUltimoPrestamo();
		modelo.put("cuotas", cuotasDelUltimoPrestamo);
		
		return new ModelAndView("listarcuotas",modelo);
	}
	
	// si ingresa por la url "/refinanciar" sin pasar por los prestamos lo redirige al home.
	@RequestMapping("/refinanciar")
	public ModelAndView irAHome() {
			
		return new ModelAndView("home");
	}

	@RequestMapping(path = "/nuevoprestamo", method=RequestMethod.POST)
	public ModelAndView irANuevoPrestamo(@ModelAttribute("afiliado") Afiliado afiliado) {
		ModelMap modelo=new ModelMap();
		Afiliado miAfiliado = servicioAfiliado.consultarAfiliadoDni(afiliado.getDni());
		List<Prestamo> prestamos = servicioPrestamo.consultarPrestamo(miAfiliado.getDni());
		
		double prestamoDisponible = servicioPrestamo.prestamoDisponible(afiliado);
		
		modelo.put("disponible", prestamoDisponible);
		modelo.put("prestamos", prestamos);
		modelo.put("afiliado", afiliado);
		return new ModelAndView("nuevoprestamo",modelo);
	}
	
	@RequestMapping(path = "/validar-nuevo-prestamo", method=RequestMethod.POST)
	public ModelAndView irValidarNuevoPrestamo(@ModelAttribute("afiliado") Afiliado afiliado, Integer valor, Integer cuotas) {
		
		ModelMap modelo=new ModelMap();
		
		if(valor <= servicioPrestamo.prestamoDisponible(afiliado)){
			Afiliado miafiliado = servicioAfiliado.consultarAfiliadoDni(afiliado.getDni());
			servicioPrestamo.crearNuevoPrestamo(afiliado, valor, cuotas);
			List<Prestamo> prestamos = servicioPrestamo.consultarPrestamoActivos(miafiliado);
			modelo.put("afiliado", miafiliado);
			modelo.put("prestamos", prestamos);
			return new ModelAndView("/listarprestamos",modelo);
		}else{
			Afiliado miAfiliado = servicioAfiliado.consultarAfiliadoDni(afiliado.getDni());
			List<Prestamo> prestamos = servicioPrestamo.consultarPrestamo(miAfiliado.getDni());
			double prestamoDisponible = servicioPrestamo.prestamoDisponible(miAfiliado);
			
			modelo.put("disponible", prestamoDisponible);
			modelo.put("prestamos", prestamos);
			modelo.put("afiliado", miAfiliado);
			modelo.put("error", "Error monto excedido");
			return new ModelAndView("/nuevoprestamo",modelo);
		}
		
	}
		
	
	
}
