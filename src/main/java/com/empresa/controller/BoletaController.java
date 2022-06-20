package com.empresa.controller;


import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.empresa.entity.Boleta;
import com.empresa.entitySecurity.Usuario;
import com.empresa.service.BoletaService;



@RestController
@RequestMapping("/rest/boleta")
@CrossOrigin(origins = "http://localhost:4200")
public class BoletaController {
	

	@Autowired
	private BoletaService boletaService;

	@GetMapping
	@ResponseBody
	public ResponseEntity<List<Boleta>> listaBoleta(){
		List<Boleta> lista = boletaService.listaBoleta();
		return ResponseEntity.ok(lista);
	}

	@PostMapping
	@ResponseBody
	public  ResponseEntity<Map<String, Object>> insertaBoleta(@RequestBody Boleta obj){
		Map<String, Object> salida = new HashMap<>();
		try {
			//SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			List<Date> lstfecha = BoletaController.listaFechaPago(obj.getAnio());
			
			Usuario u = new Usuario();
			u.setIdUsuario(1);
			obj.setFechaRegistro(new Date());
			obj.setUsuario(u);
			obj.setEstado(1);
			//Boleta objSalida = new Boleta();
			for(int i=0; i<lstfecha.size(); i++) {

				 obj.setCodBoleta(numeroMayor()+1);
				 obj.setFechaPago(lstfecha.get(i));
				 obj.setMes(i+1);
				 boletaService.insertaActualizaBoleta(obj);
			 }			
			/*if (objSalida == null) {
				salida.put("mensaje", "No se registró, consulte con el administrador.");
			}else {
				salida.put("mensaje", "Se registró correctamente.");
			}*/
		} catch (Exception e) {
			e.printStackTrace();
			salida.put("mensaje", "No se registró, consulte con el administrador.");
		}
		return ResponseEntity.ok(salida);
	}
	
	@GetMapping("/listaBoletaConParametros")
	@ResponseBody
	public  ResponseEntity<Map<String, Object>> listaBoletaPorServicioDepartamentoAnio(
			@RequestParam (name="servicio", required = false, defaultValue = "")int servicio,
			@RequestParam (name="departamento", required = false, defaultValue = "")int departamento,
			@RequestParam (name="anio", required = false, defaultValue = "")int anio){
		Map<String, Object> salida = new HashMap<>();
		try {
			List<Boleta> lista = boletaService.listaBoletaPorServicioDepartamentoAnio(servicio,departamento,anio);
			if(CollectionUtils.isEmpty(lista)) {
				salida.put("mensaje", "No se registró, consulte con el administrador.");
			}else {
				salida.put("lista", lista);
				salida.put("mensaje", "Existen "+lista.size()+" elementos para mostrar");
			}
		} catch (Exception e) {
			e.printStackTrace();
			salida.put("mensaje", "No se registró, consulte con el administrador.");
		}
		return ResponseEntity.ok(salida);
	}
	@GetMapping("/listaBoletaConParametrosEstado")
	@ResponseBody
	public  ResponseEntity<Map<String, Object>> listaBoletaPorServicioDepartamentoAnioEstado(
			@RequestParam (name="servicio", required = false, defaultValue = "")int servicio,
			@RequestParam (name="departamento", required = false, defaultValue = "")int departamento,
			@RequestParam (name="anio", required = false, defaultValue = "")int anio,
			@RequestParam (name="estado", required = true, defaultValue = "1")int estado){
		Map<String, Object> salida = new HashMap<>();
		try {
			List<Boleta> lista = boletaService.listaBoletaPorServicioDepartamentoAnioEstado(servicio,departamento,anio,estado);
			if(CollectionUtils.isEmpty(lista)) {
				salida.put("mensaje", "No se registró, consulte con el administrador.");
			}else {
				salida.put("lista", lista);
				salida.put("mensaje", "Existen "+lista.size()+" elementos para mostrar");
			}
		} catch (Exception e) {
			e.printStackTrace();
			salida.put("mensaje", "No se registró, consulte con el administrador.");
		}
		return ResponseEntity.ok(salida);
	}
	
	public static List<Date>listaFechaPago(int anio){
		int[]ultimoDiaMes = {31,28,31,30,31,30,31,31,30,31,30,31};
		 if((anio % 400 ==0)||(anio % 4 == 0 && anio % 100 != 0)) {
			 ultimoDiaMes[1] = 29;
		 }
		 ArrayList<Date> fechasPago = new ArrayList<Date>();
		 Calendar objCalendar = Calendar.getInstance();
		 for(int i = 0; i < ultimoDiaMes.length; i++) {
			 objCalendar.set(Calendar.YEAR, anio);
			 objCalendar.set(Calendar.MONTH, i);
			 objCalendar.set(Calendar.DAY_OF_MONTH, ultimoDiaMes[i]);
			 
			 if(objCalendar.get(Calendar.DAY_OF_WEEK)==Calendar.SATURDAY) {
				 objCalendar.set(Calendar.DAY_OF_MONTH, ultimoDiaMes[i]-1);
			 }else if(objCalendar.get(Calendar.DAY_OF_WEEK)==Calendar.SUNDAY) {
				 objCalendar.set(Calendar.DAY_OF_MONTH, ultimoDiaMes[i]-2);
			 }
			 Date fechaCambiada = objCalendar.getTime();
			 fechasPago.add(fechaCambiada);
			 
		 }
		
		return fechasPago;
	}
	public int numeroMayor() {
		Boleta obj =new Boleta();
		obj =  boletaService.listaBoleta().get(boletaService.listaBoleta().size()-1);
		return obj.getCodBoleta();
	}
	
}




