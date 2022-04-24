package com.empresa.repository;

import org.springframework.data.jpa.repository.JpaRepository;


import com.empresa.entity.TipoUsuario;


public interface TipoUsuarioRepository extends JpaRepository<TipoUsuario, Integer>{
	
	
}
