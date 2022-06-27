package com.empresa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.empresa.entity.Visita;


public interface VisitaRepository extends JpaRepository<Visita, Integer>{
	
	@Query("select v from Visita v where (?1 = -1 or v.departamento.codDepartamento = ?1) "
			+ "and (?2 is '' or v.visitante.dni = ?2) and (?3 is '' or v.visitante.nombre like ?3) and (?4 is '' or v.visitante.apellido like ?4)and (v.visitante.estado = ?5)")
	public List<Visita> listaVisitaConParametros(int coddepartamento, String dni, String nombre, String apellido, int estado);
	
	
}
