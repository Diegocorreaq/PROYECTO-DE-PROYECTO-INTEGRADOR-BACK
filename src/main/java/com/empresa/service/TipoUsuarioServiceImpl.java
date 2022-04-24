package com.empresa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.empresa.entity.TipoUsuario;
import com.empresa.repository.TipoUsuarioRepository;

@Service
public class TipoUsuarioServiceImpl implements TipoUsuarioService {

	@Autowired
	private TipoUsuarioRepository repository;
	@Override
	public List<TipoUsuario> listaTipoUsuario() {
		
		return repository.findAll();
	}

}
