package com.empresa.controller;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.empresa.entity.Habitante;
import com.empresa.service.PropietarioService;



@RestController
@RequestMapping("/rest/propietario")
public class PropietarioController {

	@Autowired
	private PropietarioService service;
	
	
	@GetMapping
	@ResponseBody
	public ResponseEntity<List<Habitante>> listaTodos(){
		return ResponseEntity.ok(service.listaTodos());
	}
	
	@GetMapping("/{id}")
	@ResponseBody
	public ResponseEntity<List<Habitante>> listarPorID(@PathVariable(name = "id") int id){
		return ResponseEntity.ok(service.listaPorId(id));
	}
	
	@PostMapping
	@ResponseBody
	public ResponseEntity<HashMap<String, Object>> insertarPropietario(@RequestBody Habitante obj){
		HashMap<String, Object> salida = new HashMap<String, Object>();
		try {
			List<Habitante> lista = service.listaPorId(obj.getIdPropietario());
			if (CollectionUtils.isEmpty(lista)) {
				obj.setIdPropietario(0);
				Habitante objSalida = service.insertaActualizaPropietario(obj);
				if (objSalida == null) {
					salida.put("mensaje", "Error al registrar");					
				}else {
					salida.put("mensaje", "Registro exitoso");
				}		
			}else {
				salida.put("mensaje", "El Id ya existe: "+obj.getIdPropietario());
			}
		} catch (Exception e) {
			e.printStackTrace();
			salida.put("mensaje", "Error al registrar "+e.getMessage() );
		}
		return ResponseEntity.ok(salida);
	}
	@PutMapping
	@ResponseBody
	public ResponseEntity<HashMap<String, Object>> actualizarPropietario(@RequestBody Habitante obj){
		HashMap<String, Object> salida = new HashMap<String, Object>();
		try {
			List<Habitante> lista = service.listaPorId(obj.getIdPropietario());
			if (CollectionUtils.isEmpty(lista)) {
				salida.put("mensaje", "El Id no existe: "+obj.getIdPropietario());
			}else {
				Habitante objSalida = service.insertaActualizaPropietario(obj);
				if (objSalida == null) {
					salida.put("mensaje", "Error al actualizar");					
				}else {
					salida.put("mensaje", "Actualización exitosa");
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			salida.put("mensaje", "Error al actualizar "+e.getMessage() );
		}
		return ResponseEntity.ok(salida);
	}
	
	@DeleteMapping("/{id}")
	@ResponseBody
	public ResponseEntity<HashMap<String, Object>> eliminarPropietario(@PathVariable(name = "id") int id){
		HashMap<String, Object> salida = new HashMap<String, Object>();
		try {
			List<Habitante> lista = service.listaPorId(id);
			if (CollectionUtils.isEmpty(lista)) {				
				salida.put("mensaje", "El Id no existe: "+id);
			}else {				
				service.eliminaPorId(id);
				salida.put("mensaje", "Eliminación exitosa");
			}
		} catch (Exception e) {
			e.printStackTrace();
			salida.put("mensaje", "Error al eliminar "+e.getMessage() );
		}
		return ResponseEntity.ok(salida);
	}
}



