package ar.edu.unlam.tallerweb1.controladores;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unlam.tallerweb1.modelo.*;
import ar.edu.unlam.tallerweb1.servicios.*;

@Controller
public class ControladorGrafico {
	
	@Inject
	private ServicioPrestamo servicioPrestamo;
	
	@Inject
	private ServicioCuota servicioCuota;
	
	@Inject
	private ServicioAfiliado servicioAfiliado;
	
	@Inject
	private ServicioRefinanciar servicioRefinanciar;	
	
	@RequestMapping(path="/top5afiliados")
	public ModelAndView grafica(Integer opcion) {
		ModelMap modelo = new ModelMap();
		List<Prestamo> prestamos= new ArrayList<Prestamo>();
		if(opcion==1) {
			prestamos= servicioPrestamo.consultarPrestamoOrdenadoDesc();			
		}
		else {
			prestamos= servicioPrestamo.consultarPrestamoOrdenadoAsc();
		}
	//nomafil1

		int aux=0,numafil1=0,numafil2=0,numafil3=0,numafil4=0,numafil5=0;
		String nomafil1="",nomafil2="",nomafil3="",nomafil4="",nomafil5="";
		Afiliado afil= new Afiliado();
		for(Prestamo item: prestamos) {
			aux++;
			switch(aux) {
			case(1):{
				numafil1=item.getValor();
				afil=item.getAfiliado();
				nomafil1=afil.getApellido().concat(""+afil.getNombre());
				break;
			}
			case(2):{
				numafil2=item.getValor();
				afil=item.getAfiliado();
				nomafil2=afil.getApellido().concat(""+afil.getNombre());
				break;
			}
			case(3):{
				numafil3=item.getValor();
				afil=item.getAfiliado();
				nomafil3=afil.getApellido().concat(""+afil.getNombre());
				break;
			}
			case(4):{
				numafil4=item.getValor();
				afil=item.getAfiliado();
				nomafil4=afil.getApellido().concat(""+afil.getNombre());
				break;
			}
			case(5):{
				numafil5=item.getValor();
				afil=item.getAfiliado();
				nomafil5=afil.getApellido().concat("-"+afil.getNombre());
				break;
			}
			}
			
			
		}
		modelo.put("numafil5", numafil5);
		modelo.put("numafil4", numafil4);
		modelo.put("numafil3", numafil3);
		modelo.put("numafil2", numafil2);
		modelo.put("numafil1", numafil1);
		
		modelo.put("nomafil5", nomafil5);
		modelo.put("nomafil4", nomafil4);
		modelo.put("nomafil3", nomafil3);
		modelo.put("nomafil2", nomafil2);
		modelo.put("nomafil1", nomafil1);
		if(opcion==1) {			
			return new ModelAndView("top5afiliados",modelo);
		}
		else {
			return new ModelAndView("top5afiliadosmenorprestamo",modelo);
		}
	
	}
}
