package com.empresa.repository;

import org.springframework.data.jpa.repository.JpaRepository;


import com.empresa.entity.Servicio;


public interface ServicioRepository extends JpaRepository<Servicio, Integer>{
	
	
}
