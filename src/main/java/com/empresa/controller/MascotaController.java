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

import com.empresa.entity.Mascota;
import com.empresa.service.MascotaService;



@RestController
@RequestMapping("/rest/mascota")
@CrossOrigin(origins = "http://localhost:4200")
public class MascotaController {

	@Autowired
	private MascotaService mascotaService;

	@GetMapping
	@ResponseBody
	public ResponseEntity<List<Mascota>> listaMascota(){
		List<Mascota> lista = mascotaService.listaMascota();
		return ResponseEntity.ok(lista);
	}

	@PostMapping
	@ResponseBody
	public  ResponseEntity<Map<String, Object>> insertaMascota(@RequestBody Mascota obj){
		Map<String, Object> salida = new HashMap<>();
		try {
			Mascota objSalida = mascotaService.insertaActualizaMascota(obj);
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




