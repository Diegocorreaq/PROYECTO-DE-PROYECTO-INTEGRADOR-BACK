package com.empresa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.empresa.entity.CausaIncidente;


public interface CausaIncidenteRepository extends JpaRepository<CausaIncidente, Integer>{
	
	
}
