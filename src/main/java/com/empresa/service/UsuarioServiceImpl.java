package com.empresa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.empresa.entity.Usuario;
import com.empresa.repository.UsuarioRepository;

@Service
public class UsuarioServiceImpl implements UsuarioService{

	@Autowired
	private UsuarioRepository repository;
	
	@Override
	public Usuario insertaActualizaUsuario(Usuario obj) {
		return repository.save(obj);
	}

	@Override
	public List<Usuario> listaUsuario() {
		return repository.findAll();
	}

}
