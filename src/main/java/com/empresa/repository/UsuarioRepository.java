package com.empresa.repository;

import org.springframework.data.jpa.repository.JpaRepository;


import com.empresa.entity.Usuario;


public interface UsuarioRepository extends JpaRepository<Usuario, Integer>{
	
	
}
