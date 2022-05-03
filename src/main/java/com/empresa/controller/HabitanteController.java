package com.empresa.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.empresa.entity.Habitante;
import com.empresa.entitySecurity.Usuario;
import com.empresa.service.HabitanteService;



@RestController
@RequestMapping("/rest/habitante")
@CrossOrigin(origins = "http://localhost:4200")
public class HabitanteController {

	@Autowired
	private HabitanteService habitanteService;

	@GetMapping
	@ResponseBody
	public ResponseEntity<List<Habitante>> listaHabitante(){
		List<Habitante> lista = habitanteService.listaHabitante();
		return ResponseEntity.ok(lista);
	}

	@PostMapping
	@ResponseBody
	public  ResponseEntity<Map<String, Object>> insertaHabitante(@RequestBody Habitante obj){
		Map<String, Object> salida = new HashMap<>();
		try {
			Usuario u = new Usuario();
			u.setIdUsuario(1);
			obj.setFechaRegistro(new Date());
			obj.setUsuario(u);
			
			Habitante objSalida = habitanteService.insertaActualizaHabitante(obj);
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
	
	
}




