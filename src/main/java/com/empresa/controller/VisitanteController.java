package com.empresa.controller;

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

import com.empresa.entity.Visitante;
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
	
	
}




