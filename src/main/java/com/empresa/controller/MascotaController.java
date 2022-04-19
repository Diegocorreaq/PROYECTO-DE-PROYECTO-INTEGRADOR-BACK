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

import com.empresa.entity.Mascota;
import com.empresa.service.MascotaService;



@RestController
@RequestMapping("/rest/mascota")
public class MascotaController {

	@Autowired
	private MascotaService service;
	
	
	@GetMapping
	@ResponseBody
	public ResponseEntity<List<Mascota>> listaTodos(){
		return ResponseEntity.ok(service.listaTodos());
	}
	
	@GetMapping("/{id}")
	@ResponseBody
	public ResponseEntity<List<Mascota>> listarPorCod(@PathVariable(name = "id") int cod){
		return ResponseEntity.ok(service.listaPorCod(cod));
	}
	
	@PostMapping
	@ResponseBody
	public ResponseEntity<HashMap<String, Object>> insertarMascota(@RequestBody Mascota obj){
		HashMap<String, Object> salida = new HashMap<String, Object>();
		try {
			List<Mascota> lista = service.listaPorCod(obj.getCodMascota());
			if (CollectionUtils.isEmpty(lista)) {
				obj.setCodMascota(0);
				Mascota objSalida = service.insertaActualizaMascota(obj);
				if (objSalida == null) {
					salida.put("mensaje", "Error al registrar");					
				}else {
					salida.put("mensaje", "Registro exitoso");
				}		
			}else {
				salida.put("mensaje", "El Id ya existe: "+obj.getCodMascota());
			}
		} catch (Exception e) {
			e.printStackTrace();
			salida.put("mensaje", "Error al registrar "+e.getMessage() );
		}
		return ResponseEntity.ok(salida);
	}
	@PutMapping
	@ResponseBody
	public ResponseEntity<HashMap<String, Object>> actualizarMascota(@RequestBody Mascota obj){
		HashMap<String, Object> salida = new HashMap<String, Object>();
		try {
			List<Mascota> lista = service.listaPorCod(obj.getCodMascota());
			if (CollectionUtils.isEmpty(lista)) {
				salida.put("mensaje", "El Id no existe: "+obj.getCodMascota());
			}else {
				Mascota objSalida = service.insertaActualizaMascota(obj);
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
	public ResponseEntity<HashMap<String, Object>> eliminarMascota(@PathVariable(name = "id") int id){
		HashMap<String, Object> salida = new HashMap<String, Object>();
		try {
			List<Mascota> lista = service.listaPorCod(id);
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



