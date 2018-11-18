package ar.edu.unlam.tallerweb1.controladores;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unlam.tallerweb1.modelo.Cuota;
import ar.edu.unlam.tallerweb1.servicios.ServicioRefinanciar;

@Controller
public class ControladorRefinanciar {
	@Inject 
	private ServicioRefinanciar servicioCuotasImpagas;
	
	@RequestMapping(path = "/refinanciar", method = RequestMethod.POST)
	public ModelAndView listaCuotasImp(Long arefinanciar) {
			ModelMap modelo=new ModelMap();
			
			List<Cuota> impagas=servicioCuotasImpagas.consultarCuota(arefinanciar);
			
			Double suma = 0.0;
			int cantidadCuotas = 0;

			Double tasa=0.35; //anual equivaldria a un 3% de interes mensual del monto prestado.
			
		    for(Cuota i :impagas) {
				suma+=i.getMonto();
				cantidadCuotas++;
			
			}
		    // le extendemo dos cuotas mas.
		    cantidadCuotas+=2;
			double montoTotal=suma+(suma*tasa);
			double nuevaCuota= montoTotal/cantidadCuotas;
				
			modelo.put("cuotas", impagas);
			 
			modelo.put("montototal", montoTotal);
			modelo.put("nuevaCuota",nuevaCuota );
			modelo.put("cantidadCuotas", cantidadCuotas);//se extiende las cuotas? o aumenta la cuota de las restantes.
			
			return new ModelAndView("refinanciar",modelo);
			
			
	}

}
