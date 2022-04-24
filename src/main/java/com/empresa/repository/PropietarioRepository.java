package com.empresa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.empresa.entity.Habitante;


public interface PropietarioRepository extends JpaRepository<Habitante, Integer>{
	
	public List<Habitante> findByIdPropietario(int id);
	
}
