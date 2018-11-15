package ar.edu.unlam.tallerweb1.controladores;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unlam.tallerweb1.modelo.Cuota;
import ar.edu.unlam.tallerweb1.servicios.ServicioRefinanciar;

@Controller
public class ControladorRefinanciar {
	@Inject 
	private ServicioRefinanciar servicioCuotasImpagas;
	
	@RequestMapping("/refinanciar")
	public ModelAndView listaCuotasImp() {
			ModelMap modelo=new ModelMap();
			
			List<Cuota> impagas=servicioCuotasImpagas.consultarCuota();
			
			Double suma = 0.0;
			//tasa de interes por 6 meses
			Double tasa=0.35;
			
		    for(Cuota i :impagas) {
				suma+=i.getMonto();
			
			}

			 Double montoTotal=suma+(suma*tasa);
			 Integer cantidadCuotas=6;
			 Double nuevaCuota=(Double)montoTotal/cantidadCuotas;
				
			modelo.put("cuotas", impagas);
			 
			modelo.put("montototal", montoTotal);
			modelo.put("nuevaCuota",nuevaCuota );
			modelo.put("cantidadCuotas", cantidadCuotas);//se extiende las cuotas? o aumenta la cuota de las restantes.
			
			return new ModelAndView("refinanciar",modelo);
			
			
	}

}
