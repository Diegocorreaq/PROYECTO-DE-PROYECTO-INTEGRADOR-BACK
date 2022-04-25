package com.empresa.service;

import java.util.List;

import com.empresa.entity.Usuario;

public interface UsuarioService {

	public Usuario insertaActualizaUsuario(Usuario obj);
	public List<Usuario> listaUsuario();
	
}
