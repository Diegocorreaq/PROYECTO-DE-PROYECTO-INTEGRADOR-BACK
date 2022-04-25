package com.empresa.repository;

import org.springframework.data.jpa.repository.JpaRepository;


import com.empresa.entity.Mascota;


public interface MascotaRepository extends JpaRepository<Mascota, Integer>{
	
	
}
