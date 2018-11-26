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
		
		Prestamo nprestamo = prestamo;
		
		// calculamos el valor de la cuota mensual.
		double montoMensual = nprestamo.getValor()/nprestamo.getCuotas();
		// calculamos el valor mensual de interes (el interes es igual para todos las cuotas)
		double valorInteres = nprestamo.getValor() * nprestamo.getInteres();
		// capturamos la fecha actual
		double total = montoMensual + valorInteres;
		
		Calendar fechven = Calendar.getInstance();
		
		List<Cuota> cuotas = new ArrayList<Cuota>();
		//// CUOTA DE PRUEBA
//		Cuota lcuota=new Cuota();
//		fechven.add(Calendar.DAY_OF_YEAR, 30);
//		lcuota.setMonto(montoMensual);
//		lcuota.setInteres(valorInteres);
//		lcuota.setMontoTotal(total);
//		lcuota.setEstado(false);
//		lcuota.setFechaDeVencimiento(fechven.getTime());
//		lcuota.setPrestamo(nprestamo);
//		
//		request.setAttribute("lcuota", lcuota);
		///// CUOTA DE PRUEBA
		for(int i=0; i<nprestamo.getCuotas(); i++){
			
			Cuota ncuota = new Cuota();
			fechven.add(Calendar.DAY_OF_YEAR, 30);
			ncuota.setMonto(montoMensual);
			ncuota.setInteres(valorInteres);
			ncuota.setMontoTotal(total);
			ncuota.setEstado(false);
			ncuota.setFechaDeVencimiento(fechven.getTime());
			ncuota.setPrestamo(nprestamo);
			
			cuotas.add(ncuota);
			
		}
		servicioCuota.insertarCuota(cuotas);
		
//		servicioPrestamo.crearNuevoPrestamo(nprestamo);
		
		modelo.put("cuotas", cuotas);
		
		return new ModelAndView("realizarpagoafinan", modelo);		
	}
	
	@RequestMapping(path = "/refinanciar", method = RequestMethod.POST)
	public ModelAndView listaCuotasImp(Long idPrestamo, Long dni) {
			ModelMap modelo=new ModelMap();
			
			//Prestamo prestamo = new Prestamo();
			
			List<Cuota> impagas=servicioCuota.consultarCuota(idPrestamo);
			
			Afiliado afiliado = servicioAfiliado.consultarAfiliadoDni(dni);
			
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
