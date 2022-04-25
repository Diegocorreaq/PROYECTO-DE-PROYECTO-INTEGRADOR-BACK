package com.empresa.repository;

import org.springframework.data.jpa.repository.JpaRepository;


import com.empresa.entity.Visitante;


public interface VisitanteRepository extends JpaRepository<Visitante, Integer>{
	
	
}
