package com.empresa.repository;

import org.springframework.data.jpa.repository.JpaRepository;


import com.empresa.entity.Habitante;


public interface HabitanteRepository extends JpaRepository<Habitante, Integer>{
	
	
}
