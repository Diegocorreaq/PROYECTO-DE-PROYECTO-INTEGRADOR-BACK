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
	
	
}




