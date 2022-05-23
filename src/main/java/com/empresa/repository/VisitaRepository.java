package com.empresa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.empresa.entity.Visita;


public interface VisitaRepository extends JpaRepository<Visita, Integer>{
	
	
}
