package ar.edu.unlam.tallerweb1.controladores;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unlam.tallerweb1.modelo.Afiliado;
import ar.edu.unlam.tallerweb1.modelo.Cuota;
import ar.edu.unlam.tallerweb1.modelo.Prestamo;
import ar.edu.unlam.tallerweb1.servicios.ServicioAfiliado;
import ar.edu.unlam.tallerweb1.servicios.ServicioCuota;
import ar.edu.unlam.tallerweb1.servicios.ServicioPrestamo;

@Controller
public class ControladorPrestamo {
	
	@Inject
	private ServicioPrestamo servicioPrestamo;
	
	@Inject
	private ServicioCuota servicioCuota;
	
	@Inject
	private ServicioAfiliado servicioAfiliado;
	
	@RequestMapping("/listarprestamos")
	public ModelAndView listarPrestamo() {
		ModelMap modelo = new ModelMap();
		
		List<Prestamo> prestamos= servicioPrestamo.consultarPrestamo();
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
		
		Prestamo miprestamo= servicioPrestamo.consultarUnPrestamo(idPrestamo1);
		
		//lo que esta comentado seria pagar pero no se por que me salta error
		
		List<Cuota> miscuotas=servicioCuota.consultarCuota(idPrestamo1);
		
		int cantcuotas;

		int valorprestamo=miprestamo.getValor();		
		
		cantcuotas=miprestamo.getCuotas();
		
		boolean estado=true;
		
		for (Cuota item : miscuotas) {
			if(estado) {
				if(cantcuotas==1) {
					item.setEstado(true);
					valorprestamo=0;
					miprestamo.setEstado("Pagado");
				}
				
				estado=item.getEstado();
				if(estado==false) {
					item.setEstado(true);
					valorprestamo-=item.getMontoTotal();
					cantcuotas--;
				}
			}
			
			
		}
		miprestamo.setValor(valorprestamo);	
		
		miprestamo.setCuotas(cantcuotas);
		
		servicioPrestamo.modificarPrestamo(miprestamo);

		return new ModelAndView("redirect:/misprestamos",modelo);
		
	}
	
	
	@RequestMapping("/nuevoprestamo")
	public ModelAndView nuevoPrestamo() {
ModelMap modelo = new ModelMap();
		
		Prestamo prestamo = new Prestamo();
		modelo.put("prestamo", prestamo);
		return new ModelAndView("crearprestamo", modelo);			
	}
	
	@RequestMapping(path = "/crearprestamo", method=RequestMethod.POST)
	public ModelAndView crearPrestamo(@ModelAttribute("prestamo") Prestamo prestamo, HttpServletRequest request) {
		ModelMap modelo = new ModelMap();
		
		int cantcuotas=prestamo.getCuotas();
		
		double interesCuota=0;
		
		switch(cantcuotas) {
		case 6:interesCuota=2.0;
		break;
		case 12:interesCuota=4.0;
		break;
		case 24:interesCuota=8.0;
		break;
		case 32:interesCuota=16.0;
		break;
		case 72:interesCuota=32.0;
		break;
		default:{
			modelo.put("error", "Error en Cantidad Cuota");
			return new ModelAndView("crearprestamo", modelo);
		}
		}
		
		
		
		Prestamo nprestamo = prestamo;
		nprestamo.setInteres(cantcuotas*interesCuota);
		Afiliado afiliado0=servicioAfiliado.consultarAfiliadoDni(prestamo.getDni());
		
		double montoMensual = nprestamo.getValor()/nprestamo.getCuotas();
		// calculamos el valor mensual de interes (el interes es igual para todos las cuotas)
		//double valorInteres = nprestamo.getValor() * nprestamo.getInteres();
		// capturamos la fecha actual
		double total = montoMensual + interesCuota;
		
		double sueldo=afiliado0.getSueldo();
		sueldo=sueldo*0.3;
		if(sueldo<total) {
			modelo.put("error", "Cada cuota excede el 30% del sueldo");
			return new ModelAndView("crearprestamo", modelo);
		}
		nprestamo.setDni(prestamo.getDni());
		
		nprestamo.setAfiliado(afiliado0);
		nprestamo.setEstado("pendiente");
		
		// calculamos el valor de la cuota mensual.
		
		
		Calendar fechven = Calendar.getInstance();
		
		List<Cuota> cuotas = new ArrayList<Cuota>();	
		
		
		for(int i=0; i<nprestamo.getCuotas(); i++){
			
			Cuota ncuota = new Cuota();
			fechven.add(Calendar.DAY_OF_YEAR, 30);
			ncuota.setMonto(montoMensual);
			ncuota.setInteres(interesCuota);
			ncuota.setMontoTotal(total);
			ncuota.setEstado(false);
			ncuota.setFechaDeVencimiento(fechven.getTime());
			ncuota.setPrestamo(nprestamo);	
			cuotas.add(ncuota);
			
		}
		servicioCuota.insertarCuota(cuotas);
		
		
		
		//servicioPrestamo.crearNuevoPrestamo(nprestamo);
		
		modelo.put("cuotas", cuotas);
		
		return new ModelAndView("redirect:/misprestamos");
	}
	
	@RequestMapping(path = "/refinanciar", method = RequestMethod.POST)
	public ModelAndView listaCuotasImp(Long idPrestamo) {
		ModelMap modelo=new ModelMap();
		
		//Prestamo prestamo = new Prestamo();
		
		List<Cuota> impagas=servicioCuota.consultarCuota(idPrestamo);
		
		Afiliado afiliado = servicioAfiliado.consultarAfiliado(idPrestamo);
		
		Double montoTotalARefinanciar = 0.0;
		int cuotasRestante = 0;
		
	    for(Cuota i :impagas) {
			montoTotalARefinanciar += i.getMontoTotal();
			cuotasRestante++;
		}
	    //modelo.put("prestamo", prestamo);
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
		
		Integer nCapital = (int)newCapital;

		// Se modificar la clasificacion del Afiliado (Perdida).
		Afiliado afiliado = servicioAfiliado.consultarAfiliadoDni(dni);
		afiliado.setClasificacion("Perdida");
		servicioAfiliado.modificarAfiliado(afiliado);

		// aqui tiene que estar el modificar el estado del prestamo (Refinanciado).
		Prestamo prestamo = servicioPrestamo.consultarUnPrestamo(idPrestamoRef);
		prestamo.setEstado("Refinanciado");
		servicioPrestamo.modificarPrestamo(prestamo);
		
		Prestamo prestamoRef = new Prestamo();
		prestamoRef.setValor(nCapital);
		prestamoRef.setCuotas(cuotas);
		prestamoRef.setInteres(interes);
		prestamoRef.setAfiliado(afiliado);
		//prestamoRef.setCuota(cuotasRef);
		
		// Creo un nuevo prestamo con sus respectivos cuotas.
		Calendar fechven = Calendar.getInstance();
		
		List<Cuota> cuotasRef = new ArrayList<Cuota>();
		
		double montoMensual = nCapital/cuotas;
		double valorInteres = (nCapital*interes)/12;
		double total = montoMensual + valorInteres;
		
		for(int i=0; i<cuotas; i++){
			fechven.add(Calendar.DAY_OF_YEAR, 30);
			
			Cuota ncuota = new Cuota();
			
			ncuota.setMonto(montoMensual);
			ncuota.setInteres(valorInteres);
			ncuota.setMontoTotal(total);
			ncuota.setEstado(false);
			ncuota.setFechaDeVencimiento(fechven.getTime());
			ncuota.setPrestamo(prestamoRef);

			cuotasRef.add(ncuota);
		}
		//servicioPrestamo.crearNuevoPrestamo(prestamoRef);
		servicioCuota.insertarCuota(cuotasRef);
		
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
	
	
}
