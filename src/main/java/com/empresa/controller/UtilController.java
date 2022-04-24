package com.empresa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.empresa.entity.TipoUsuario;
import com.empresa.service.TipoUsuarioService;

@RestController
@RequestMapping("/rest/util")
@CrossOrigin(origins = "http://localhost:4200")

public class UtilController {
	@Autowired TipoUsuarioService tipoUsuarioService;
	
	@GetMapping("/tipousuario")
	@ResponseBody
	public ResponseEntity<List<TipoUsuario>> listaTipoUsuario(){
		List<TipoUsuario> lista = tipoUsuarioService.listaTipoUsuario();
		return ResponseEntity.ok(lista);
	}

}
