package ar.edu.unlam.tallerweb1.controladores;

import java.util.ArrayList;
import java.util.Calendar;
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
	private ServicioRegistro servicioRegistro;
	
	@RequestMapping(path="/graficos")
	public ModelAndView mostrarTodosLosGraficos(){
		
		return new ModelAndView("graficos");
	}
	
	@RequestMapping(path="/top5afiliados")
	public ModelAndView top5afiliados(Integer opcion) {
		ModelMap modelo = new ModelMap();
		List<Prestamo> prestamos= new ArrayList<Prestamo>();
		if(opcion==1) {
			prestamos= servicioPrestamo.consultarPrestamoOrdenadoDesc();			
		}
		else {
			prestamos= servicioPrestamo.consultarPrestamoOrdenadoAsc();
		}

		int aux=0,numafil1=0,numafil2=0,numafil3=0,numafil4=0,numafil5=0;
		String nomafil1="",nomafil2="",nomafil3="",nomafil4="",nomafil5="";
		Afiliado afil= new Afiliado();
		for(Prestamo item: prestamos) {
			aux++;
			afil=item.getAfiliado();
			
			switch(aux) {
			case(1):{
				numafil1=item.getValor();
				nomafil1=afil.getApellido().concat(" "+afil.getNombre());
				break;
			}
			case(2):{
				numafil2=item.getValor();
				nomafil2=afil.getApellido().concat(" "+afil.getNombre());
				break;
			}
			case(3):{
				numafil3=item.getValor();
				nomafil3=afil.getApellido().concat(" "+afil.getNombre());
				break;
			}
			case(4):{
				numafil4=item.getValor();
				nomafil4=afil.getApellido().concat(" "+afil.getNombre());
				break;
			}
			case(5):{
				numafil5=item.getValor();
				nomafil5=afil.getApellido().concat(" "+afil.getNombre());
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
	@RequestMapping(path="/top5financieras")
	public ModelAndView top5financieras(Integer opcion) {
		ModelMap modelo = new ModelMap();
		List<Prestamo> prestamos= new ArrayList<Prestamo>();
		if(opcion==3) {
			prestamos=servicioPrestamo.consultarPrestamoFinanOrdenadoDesc();			
		}
		else {
			prestamos=servicioPrestamo.consultarPrestamoFinanOrdenadoAsc();
		}

		int aux=0,numafil1=0,numafil2=0,numafil3=0,numafil4=0,numafil5=0;
		String nomafil1="",nomafil2="",nomafil3="",nomafil4="",nomafil5="";
		Financiera afil= new Financiera();
		for(Prestamo item: prestamos) {
			aux++;
			afil=item.getFinanciera();
			
			switch(aux) {
			case(1):{
				numafil1=item.getValor();
				nomafil1=afil.getNombre();
				break;
			}
			case(2):{
				numafil2=item.getValor();
				nomafil2=afil.getNombre();
				break;
			}
			case(3):{
				numafil3=item.getValor();
				nomafil3=afil.getNombre();
				break;
			}
			case(4):{
				numafil4=item.getValor();
				nomafil4=afil.getNombre();
				break;
			}
			case(5):{
				numafil5=item.getValor();
				nomafil5=afil.getNombre();
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
		if(opcion==3) {			
			return new ModelAndView("top5financieras",modelo);
		}
		else {
			return new ModelAndView("top5financierasmenorprestamo",modelo);
		}
	
	}
	
	//grafico de caja
	
	@RequestMapping(path="/graficocaja")
	public ModelAndView graficoCaja(Integer opcion) {
		ModelMap modelo=new ModelMap();
		List<Registro> registros=new ArrayList<Registro>();
		if(opcion==1) { 
		registros=servicioRegistro.consultarIngresos();
		}else {
		registros=servicioRegistro.consultarEgresos();

		}
		Double ingreso1=0.0,ingreso2=0.0,ingreso3=0.0,ingreso4=0.0,ingreso5=0.0,ingreso6=0.0,ingreso7=0.0,ingreso8=0.0,ingreso9=0.0,ingreso10=0.0,ingreso11=0.0,ingreso12=0.0;//son las filas para mi ingresos
		String mes1="enero",mes2="febrero",mes3="marzo",mes4="abril",mes5="mayo",mes6="junio",mes7="julio",mes8="agosto",mes9="septiembre",mes10="octubre",mes11="noviembre",mes12="diciembre";//son columnas para mi mese
//		el aux servia ara determinar solo 5 afiliados e mi caso no lo necesito
		for(Registro reg: registros) {
			Calendar fecha = Calendar.getInstance ();;
			fecha.setTime(reg.getFecha());
			int mes=fecha.get(Calendar.MONTH)+1;
			
			switch(mes) {
			case(1):{
				if(opcion==1) {
					ingreso1+=reg.getIngreso();
				}else {
					ingreso1+=reg.getEgreso();
				}
				
				break;
			}
			case(2):{
				if(opcion==1) {
					ingreso2+=reg.getIngreso();
				}else {
					ingreso2+=reg.getEgreso();
				}
				break;
			}
			case(3):{
				if(opcion==1) {
					ingreso3+=reg.getIngreso();
				}else {
					ingreso3+=reg.getEgreso();
				}
				break;
			}
			case(4):{
				if(opcion==1) {
					ingreso4+=reg.getIngreso();
				}else {
					ingreso4+=reg.getEgreso();
				}
				break;
			}
			case(5):{
				if(opcion==1) {
					ingreso5+=reg.getIngreso();
				}else {
					ingreso5+=reg.getEgreso();
				}
				break;
			}
			case(6):{
				if(opcion==1) {
					ingreso6+=reg.getIngreso();
				}else {
					ingreso6+=reg.getEgreso();
				}
				break;
			}
			case(7):{
				if(opcion==1) {
					ingreso7+=reg.getIngreso();
				}else {
					ingreso7+=reg.getEgreso();
				}
				break;
			}
			case(8):{
				if(opcion==1) {
					ingreso8+=reg.getIngreso();
				}else {
					ingreso8+=reg.getEgreso();
				}
				break;
			}
			case(9):{
				if(opcion==1) {
					ingreso9+=reg.getIngreso();
				}else {
					ingreso9+=reg.getEgreso();
				}
				break;
			}
			case(10):{
				if(opcion==1) {
					ingreso10+=reg.getIngreso();
				}else {
					ingreso10+=reg.getEgreso();
				}
				break;
			}
			case(11):{
				if(opcion==1) {
					ingreso11+=reg.getIngreso();
				}else {
					ingreso11+=reg.getEgreso();
				}
				break;
			}
			case(12):{
				if(opcion==1) {
					ingreso12+=reg.getIngreso();
				}else {
					ingreso12+=reg.getEgreso();
				}
				break;
			}
			
			
			}
			
		}
		modelo.put("ingreso1", ingreso1);
		modelo.put("ingreso2", ingreso2);
		modelo.put("ingreso3", ingreso3);
		modelo.put("ingreso4", ingreso4);
		modelo.put("ingreso5", ingreso5);
		modelo.put("ingreso6", ingreso6);
		modelo.put("ingreso7", ingreso7);
		modelo.put("ingreso8", ingreso8);
		modelo.put("ingreso9", ingreso9);
		modelo.put("ingreso10", ingreso10);
		modelo.put("ingreso11", ingreso11);
		modelo.put("ingreso12", ingreso12);
		
		modelo.put("mes1", mes1);
		modelo.put("mes2", mes2);
		modelo.put("mes3", mes3);
		modelo.put("mes4", mes4);
		modelo.put("mes5", mes5);
		modelo.put("mes6", mes6);
		modelo.put("mes7", mes7);
		modelo.put("mes8", mes8);
		modelo.put("mes9", mes9);
		modelo.put("mes10", mes10);
		modelo.put("mes11", mes11);
		modelo.put("mes12", mes12);
		
		if(opcion==1) {			
			
			return new ModelAndView("graficocajaingresos",modelo);
		}
		else {
			return new ModelAndView("graficocajaegresos",modelo);		
			}
	
	}
}
