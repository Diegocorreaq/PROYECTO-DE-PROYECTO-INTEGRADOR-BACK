package com.empresa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.empresa.entity.CausaIncidente;
import com.empresa.service.CausaIncidenteService;


@RestController
@RequestMapping("/rest/causaincidente")
@CrossOrigin(origins = "http://localhost:4200")
public class CausaIncidenteController {

	@Autowired
	private CausaIncidenteService service;

	@GetMapping
	@ResponseBody
	public ResponseEntity<List<CausaIncidente>> listaServicio(){
		List<CausaIncidente> lista = service.listaCausaIncidente();
		return ResponseEntity.ok(lista);
	}


	
}




