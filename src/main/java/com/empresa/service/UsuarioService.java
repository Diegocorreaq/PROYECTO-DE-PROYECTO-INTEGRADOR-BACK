package com.empresa.service;

import java.util.List;

import com.empresa.entitySecurity.Opcion;
import com.empresa.entitySecurity.Rol;
import com.empresa.entitySecurity.Usuario;

public interface UsuarioService {

	public abstract List<Opcion> traerEnlacesDeUsuario(int idUsuario);

	public abstract List<Rol> traerRolesDeUsuario(int idUsuario);

	public abstract Usuario buscaPorLogin(String login);
	
	public abstract List<Usuario> listarTodos();
	
	public Usuario insertaActualizaUsuario(Usuario obj) ;


}
