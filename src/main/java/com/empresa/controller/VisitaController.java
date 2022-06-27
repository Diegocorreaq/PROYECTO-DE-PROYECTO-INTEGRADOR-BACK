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
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.empresa.entity.Incidente;
import com.empresa.entity.Visita;
import com.empresa.entitySecurity.Usuario;
import com.empresa.service.VisitaService;



@RestController
@RequestMapping("/rest/visita")
@CrossOrigin(origins = "http://localhost:4200")
public class VisitaController {

	@Autowired
	private VisitaService visitaService;

	@GetMapping
	@ResponseBody
	public ResponseEntity<List<Visita>> listaVisita(){
		List<Visita> lista = visitaService.listaVisita();
		return ResponseEntity.ok(lista);
	}

	@PostMapping
	@ResponseBody
	public  ResponseEntity<Map<String, Object>> insertaVisita(@RequestBody Visita obj){
		Map<String, Object> salida = new HashMap<>();
		try {
			Usuario u = new Usuario();
			u.setIdUsuario(1);
			obj.setFechaRegistro(new Date());
			obj.setUsuario(u);
			obj.setComentario("Sin comentarios");
			Visita objSalida = visitaService.insertaActualizaVisita(obj);
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
	@PutMapping("/actualizaVisita")
	@ResponseBody
	public ResponseEntity<Map<String, Object>> actualizaIncidente(@RequestBody Visita obj) {
		Map<String, Object> salida = new HashMap<>();
		try {
			Visita objSalida =  visitaService.insertaActualizaVisita(obj);
			if (objSalida == null) {
				salida.put("mensaje", "No se actualizó, consulte con el administrador.");
			} else {
				salida.put("mensaje", "Se actualizó correctamente.");
			}
		} catch (Exception e) {
			e.printStackTrace();
			salida.put("mensaje", "No se actualizó, consulte con el administrador.");
		}
		return ResponseEntity.ok(salida);
	}
	
	
	@GetMapping("/listaVisitaConParametrosEstado")
	@ResponseBody
	public  ResponseEntity<Map<String, Object>> listaVisitaConParametros(
			@RequestParam (name="coddepartamento", required = false, defaultValue = "-1")int coddepartamento,
			@RequestParam (name="dni", required = false, defaultValue = "")String dni,
			@RequestParam (name="nombre", required = false, defaultValue = "")String nombre,
			@RequestParam (name="apellido", required = false, defaultValue = "")String apellido,
			@RequestParam (name="estado", required = true, defaultValue = "1")int estado){
		Map<String, Object> salida = new HashMap<>();
		try {
			List<Visita> lista = visitaService.listaVisitaConParametros(coddepartamento, dni, nombre, apellido, estado);
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




