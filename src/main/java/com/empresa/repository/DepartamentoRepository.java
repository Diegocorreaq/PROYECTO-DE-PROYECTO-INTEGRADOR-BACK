package com.empresa.repository;

import org.springframework.data.jpa.repository.JpaRepository;


import com.empresa.entity.Departamento;


public interface DepartamentoRepository extends JpaRepository<Departamento, Integer>{
	
	
}
