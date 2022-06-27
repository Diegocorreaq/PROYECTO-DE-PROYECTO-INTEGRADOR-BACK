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
import com.empresa.entitySecurity.Usuario;
import com.empresa.service.IncidenteService;

@RestController
@RequestMapping("/rest/incidente")
@CrossOrigin(origins = "http://localhost:4200")

public class IncidenteController {
	@Autowired
	private IncidenteService incidenteService;

	@GetMapping
	@ResponseBody
	public ResponseEntity<List<Incidente>> listaBoleta(){
		List<Incidente> lista = incidenteService.listaIncidente();
		return ResponseEntity.ok(lista);
	}
	
	@PostMapping
	@ResponseBody
	public  ResponseEntity<Map<String, Object>> insertaIncidente(@RequestBody Incidente obj){
		Map<String, Object> salida = new HashMap<>();
		try {
			Usuario u = new Usuario();
			u.setIdUsuario(1);
			obj.setFechaRegistro(new Date());
			obj.setUsuario(u);
			Incidente objSalida = incidenteService.insertaActualizaIncidente(obj);
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
	
	@PutMapping("/actualizaIncidente")
	@ResponseBody
	public ResponseEntity<Map<String, Object>> actualizaIncidente(@RequestBody Incidente obj) {
		Map<String, Object> salida = new HashMap<>();
		try {
			Incidente objSalida =  incidenteService.insertaActualizaIncidente(obj);
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
	@GetMapping("/listaIncidenteConParametrosEstado")
	@ResponseBody
	public  ResponseEntity<Map<String, Object>> listaIncidentePorDepartamentoCausaIncidenteEstado(
			@RequestParam (name="departamento", required = false, defaultValue = "-1")int coddepartamento,
			@RequestParam (name="causaincidente", required = false, defaultValue = "-1")int idCausaIncidente,
			@RequestParam (name="estado", required = true, defaultValue = "1")int estado){
		Map<String, Object> salida = new HashMap<>();
		try {
			List<Incidente> lista = incidenteService.listaIncidentePorCausaIncidenteEstado(coddepartamento,idCausaIncidente,estado);
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
