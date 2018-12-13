package ar.edu.unlam.tallerweb1.controladores;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unlam.tallerweb1.modelo.Afiliado;
import ar.edu.unlam.tallerweb1.modelo.Confirmpagocuota;
import ar.edu.unlam.tallerweb1.modelo.Cuota;
import ar.edu.unlam.tallerweb1.modelo.Financiera;
import ar.edu.unlam.tallerweb1.modelo.Prestamo;
import ar.edu.unlam.tallerweb1.servicios.ServicioAfiliado;
import ar.edu.unlam.tallerweb1.servicios.ServicioCuota;
import ar.edu.unlam.tallerweb1.servicios.ServicioFinanciera;
import ar.edu.unlam.tallerweb1.servicios.ServicioPrestamo;
import ar.edu.unlam.tallerweb1.servicios.ServicioRefinanciar;
import ar.edu.unlam.tallerweb1.servicios.ServicioRegistro;

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
	@Inject
	private ServicioRegistro servicioRegistro;
	@Inject
	private ServicioFinanciera servicioFinanciera;
	
	@RequestMapping("/listarprestamos")
	public ModelAndView listarPrestamo() {
		ModelMap modelo = new ModelMap();
		
		List<Prestamo> prestamos= servicioPrestamo.consultarPrestamoTodosLosAfiliados();
		
		modelo.put("prestamos", prestamos);
		
		return new ModelAndView("listarprestamos",modelo);
	}
	
	@RequestMapping(path="/misprestamos")
	public ModelAndView misprestamos(Long dni) {
		ModelMap modelo = new ModelMap();
		List<Prestamo> prestamos= servicioPrestamo.consultarPrestamo(dni);
		modelo.put("prestamos", prestamos);
		
		return new ModelAndView("listarprestamos",modelo);
	}
	@RequestMapping(path = "/cancelarprestamo", method = RequestMethod.POST)
	public ModelAndView cancelarprestamo(Long idPrestamo2) {
		
		ModelMap modelo = new ModelMap(); 
		Prestamo miprestamo=servicioPrestamo.consultarUnPrestamo(idPrestamo2);
		List<Cuota> cuotas=new ArrayList<Cuota>(); 
		cuotas=servicioCuota.consultarCuotaImpagas(idPrestamo2);		
		int valor=0;
		for(Cuota item:cuotas) {
			if((item.getFechaDeVencimiento().compareTo(new Date()))<0 && valor<1) {
				
				modelo.put("error", "El prestamo elegido para cancelar adeuda una o mas cuotas por favor pague primero la cuota vencida");
				
				return new ModelAndView("listarprestamos",modelo);
			}
			valor++;
		}
		modelo.put("afiliado", miprestamo.getAfiliado());
		modelo.put("prestamo", miprestamo);
		
		modelo.put("cuotasnopagas", cuotas);		

		return new ModelAndView("confirmarpagocancelacion",modelo);
		
		
	}
	@RequestMapping(path = "/pagarcuota", method = RequestMethod.POST)
	public ModelAndView pagarcuota(Long idPrestamo1) {
		ModelMap modelo = new ModelMap();
		
		List<Cuota> cuotasnopagas=servicioCuota.consultarCuota(idPrestamo1);
		List<Cuota> cuotaspagas=servicioCuota.consultarCuotaPagada(idPrestamo1);
		Prestamo prestamo0=servicioPrestamo.consultarUnPrestamo(idPrestamo1);
		Afiliado afiliado0=prestamo0.getAfiliado();
		
		modelo.put("prestamo", prestamo0);
		
		modelo.put("afiliado", afiliado0);
		
		modelo.put("cuotaspagas", cuotaspagas);
		
		modelo.put("cuotasnopagas", cuotasnopagas);		

		return new ModelAndView("confirmarpagocuota",modelo);
		
	}
	
	@RequestMapping(path = "/pagarporvalor", method=RequestMethod.POST)
	public ModelAndView pagarporvalor(@ModelAttribute("confirm") Prestamo prestamo) {
		
		boolean result=servicioCuota.pagarporinput(prestamo.getSaldo(),prestamo.getIdPrestamo());
		return new ModelAndView("redirect:/listarprestamos");
	}
	
	@RequestMapping(path = "/finalizarpagocuota", method=RequestMethod.POST)
	public ModelAndView finalizarpagocuota(@ModelAttribute("confirm") Confirmpagocuota confirm) {
		
		servicioCuota.pagarCuotaSeleccionada(confirm);
		return new ModelAndView("redirect:/listarprestamos");
	}
	
	@RequestMapping(path = "/totalapagarcuota", method=RequestMethod.POST)
	public ModelAndView totalapagarcuota(@ModelAttribute("confirm") Confirmpagocuota confirm) {
			
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
		Prestamo prestamo = servicioPrestamo.consultarUnPrestamo(idPrestamo);
		Afiliado afiliado = servicioAfiliado.consultarAfiliadoDni(prestamo.getDni());
		if (prestamo.getEstado().contentEquals("refinanciado")) {
			modelo.put("afiliado", afiliado);
			modelo.put("prestamo", prestamo);
			return new ModelAndView("refinanciarerror",modelo);
		}else{
			List<Cuota> impagas=servicioRefinanciar.consultaCuota(idPrestamo);
			//Double montoTotalARefinanciar = servicioRefinanciar.montoARefinanciar(idPrestamo);
			int cuotasRestante = impagas.size();
			
		    modelo.put("afiliado", afiliado);
		    modelo.put("prestamoARef", prestamo);
			modelo.put("cuotas", impagas);	
			modelo.put("cuotasRestante",cuotasRestante);
			return new ModelAndView("refinanciar",modelo);
		}
	}
	
	@RequestMapping(path = "/verifica-refinanciacion", method = RequestMethod.POST)
	public ModelAndView verificarRefinanciacion(Long dni, Long idPrestamoRef, Integer cuotas) {
		ModelMap modelo = new ModelMap();
		
		Afiliado afiliado = servicioAfiliado.consultarAfiliadoDni(dni);
		Prestamo prestamoARef = servicioPrestamo.consultarUnPrestamo(idPrestamoRef);
		List<Cuota> listCuotas = servicioRefinanciar.generarCuotas(idPrestamoRef,cuotas);
		
		modelo.put("prestamoARef", prestamoARef);
		modelo.put("afiliado", afiliado);
		modelo.put("cuotas", listCuotas);
		return new ModelAndView("listarcuotas",modelo);
	}

	@RequestMapping(path = "/hacer-refinanciacion", method = RequestMethod.POST)
	public ModelAndView refinanciarAlta(Long dni, Long idPrestamoARef, Integer cuotas) {
		ModelMap modelo = new ModelMap();
		
		servicioRefinanciar.refinanciar(dni, idPrestamoARef, cuotas);
		
		List<Prestamo> prestamos= servicioPrestamo.consultarPrestamo(dni);
		modelo.put("prestamos", prestamos);
		
		return new ModelAndView("listarprestamos",modelo);
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
//	@RequestMapping("/refinanciar")
//	public ModelAndView irAHome() {
//			
//		return new ModelAndView("home");
//	}

	@RequestMapping(path = "/nuevoprestamo", method=RequestMethod.POST)
	public ModelAndView irANuevoPrestamo(@ModelAttribute("afiliado") Afiliado afiliado) {
		ModelMap modelo=new ModelMap();
		Afiliado miAfiliado = servicioAfiliado.consultarAfiliadoDni(afiliado.getDni());
		List<Prestamo> prestamos = servicioPrestamo.consultarPrestamo(miAfiliado.getDni());
		
		double prestamoDisponible = servicioPrestamo.prestamoDisponible(afiliado);
		
		modelo.put("disponible", prestamoDisponible);
		modelo.put("prestamos", prestamos);
		modelo.put("afiliado", afiliado);
		//enviar financiera con disponible
		List<Financiera> financieras=servicioFinanciera.consultarFinanciera();
		modelo.put("financieras",financieras);
		////
		return new ModelAndView("nuevoprestamo",modelo);
	}
	
	@RequestMapping(path = "/validar-nuevo-prestamo", method=RequestMethod.POST)
	public ModelAndView irValidarNuevoPrestamo(@ModelAttribute("afiliado") Afiliado afiliado, Integer valor, Integer cuotas,String nombreF) {
		Afiliado nvo=servicioAfiliado.consultarIdAfiliado(afiliado.getIdAfiliado());
		ModelMap modelo=new ModelMap();
		
		if(valor <= servicioPrestamo.prestamoDisponible(nvo)){
			Afiliado miafiliado = servicioAfiliado.consultarAfiliadoDni(nvo.getDni());
			List<Cuota> listCuotas = servicioRefinanciar.generarCuotasPrestamoNuevo(valor,cuotas);

			modelo.put("afiliado", miafiliado);
			modelo.put("valor", valor);
			modelo.put("cuotas", listCuotas);
			modelo.put("nombreF", nombreF);
			return new ModelAndView("/confirmarprestamo",modelo);
		}else{
			Afiliado miAfiliado = servicioAfiliado.consultarAfiliadoDni(afiliado.getDni());
			List<Prestamo> prestamos = servicioPrestamo.consultarPrestamo(miAfiliado.getDni());
			double prestamoDisponible = servicioPrestamo.prestamoDisponible(miAfiliado);
			
			modelo.put("disponible", prestamoDisponible);
			modelo.put("prestamos", prestamos);
			modelo.put("afiliado", miAfiliado);
			modelo.put("error", "Error monto excedido");
			//enviar financiera con disponible
			List<Financiera> financieras=servicioFinanciera.consultarFinanciera();
			modelo.put("financieras",financieras);
			////
			return new ModelAndView("/nuevoprestamo",modelo);
		}
		
	}
	@RequestMapping(path = "/confirmar-nuevo-prestamo", method=RequestMethod.POST)
	public ModelAndView irValidarConfirmarPrestamo(@ModelAttribute("afiliado") Afiliado afiliado, Integer valor, Integer cuotas,String nombreF) {
		
		ModelMap modelo=new ModelMap();
		
		Afiliado miAfiliado = servicioAfiliado.consultarAfiliadoDni(afiliado.getDni());
		String nombreFinan=nombreF;
		servicioPrestamo.crearNuevoPrestamo(miAfiliado, valor, cuotas,nombreFinan);
		
		List<Prestamo> prestamos = servicioPrestamo.consultarPrestamoActivos(miAfiliado);
		
		modelo.put("prestamos", prestamos);
		
		return new ModelAndView("listarprestamos",modelo);
	}
	public ServicioPrestamo getServicioPrestamo() {
		return servicioPrestamo;
	}

	public void setServicioPrestamo(ServicioPrestamo servicioPrestamo) {
		this.servicioPrestamo = servicioPrestamo;
	}

	public ServicioCuota getServicioCuota() {
		return servicioCuota;
	}

	public void setServicioCuota(ServicioCuota servicioCuota) {
		this.servicioCuota = servicioCuota;
	}

	public ServicioAfiliado getServicioAfiliado() {
		return servicioAfiliado;
	}

	public void setServicioAfiliado(ServicioAfiliado servicioAfiliado) {
		this.servicioAfiliado = servicioAfiliado;
	}

	public ServicioRefinanciar getServicioRefinanciar() {
		return servicioRefinanciar;
	}

	public void setServicioRefinanciar(ServicioRefinanciar servicioRefinanciar) {
		this.servicioRefinanciar = servicioRefinanciar;
	}
//
	public ServicioRegistro getServicioRegistro() {
		return servicioRegistro;
	}

	public void setServicioRegistro(ServicioRegistro servicioRegistro) {
		this.servicioRegistro = servicioRegistro;
	}

	public ServicioFinanciera getServicioFinanciera() {
		return servicioFinanciera;
	}

	public void setServicioFinanciera(ServicioFinanciera servicioFinanciera) {
		this.servicioFinanciera = servicioFinanciera;
	}
//		
	
	
}
