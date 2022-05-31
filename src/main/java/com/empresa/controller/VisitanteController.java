package com.empresa.controller;

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

import com.empresa.entity.Visitante;
import com.empresa.entitySecurity.Usuario;
import com.empresa.service.VisitanteService;



@RestController
@RequestMapping("/rest/visitante")
@CrossOrigin(origins = "http://localhost:4200")
public class VisitanteController {

	@Autowired
	private VisitanteService visitanteService;

	@GetMapping
	@ResponseBody
	public ResponseEntity<List<Visitante>> listaHabitante(){
		List<Visitante> lista = visitanteService.listaVisitante();
		return ResponseEntity.ok(lista);
	}

	@PostMapping
	@ResponseBody
	public  ResponseEntity<Map<String, Object>> insertaHabitante(@RequestBody Visitante obj){
		Map<String, Object> salida = new HashMap<>();
		try {
			Usuario u = new Usuario();
			u.setIdUsuario(1);
			obj.setFechaRegistro(new Date());
			obj.setUsuario(u);
			obj.setEstado(1);
			Visitante objSalida = visitanteService.insertaActualizaVisitante(obj);
			if (objSalida == null) {
				salida.put("mensaje", "No se registró, consulte con el administrador.");
			}else {
				salida.put("mensaje", "Se registró correctamente.");
			}
		} catch (Exception e) {
			e.printStackTrace();
			salida.put("mensaje", "No se registró, consulte con el administrador.");
		}
		return ResponseEntity.ok(salida);
	}
	
	@GetMapping("/listaVisitanteConParametros")
	@ResponseBody
	public  ResponseEntity<Map<String, Object>> listaVistantePorDniNombreApellidoEstado(
			@RequestParam (name="dni", required = false, defaultValue = "")String dni,
			@RequestParam (name="nombre", required = false, defaultValue = "")String nombre,
			@RequestParam (name="apellido", required = false, defaultValue = "")String apellido,
			@RequestParam (name="estado", required = true, defaultValue = "1")int estado){
		Map<String, Object> salida = new HashMap<>();
		try {
			List<Visitante> lista = visitanteService.listaVistantePorDniNombreApellidoEstado(dni,"%"+ nombre+"%","%"+ apellido+"%", estado);
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
	@GetMapping("/listaVisitantePorDni")
	@ResponseBody
	public  ResponseEntity<Map<String, Object>> listaVistantePorDni(
			@RequestParam (name="dni", required = true, defaultValue = "")String dni){
		Map<String, Object> salida = new HashMap<>();
		try {
			List<Visitante> lista = visitanteService.listaVisitantePorDni(dni);
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
	
}




