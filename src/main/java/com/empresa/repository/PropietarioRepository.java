package com.empresa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.empresa.entity.Propietario;


public interface PropietarioRepository extends JpaRepository<Propietario, Integer>{
	
	public List<Propietario> findByIdPropietario(int id);
	
}
