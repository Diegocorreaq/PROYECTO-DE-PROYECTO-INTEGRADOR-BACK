package com.empresa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.empresa.entity.Visitante;


public interface VisitanteRepository extends JpaRepository<Visitante, Integer>{
	
	public List<Visitante> findByIdVisitante(int id);
	
}
