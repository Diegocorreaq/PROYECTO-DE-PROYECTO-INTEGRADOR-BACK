package com.empresa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.empresa.entity.Visitante;


public interface VisitanteRepository extends JpaRepository<Visitante, Integer>{
	@Query("select v from Visitante v where (?1 is '' or v.dni = ?1) and (?2 is '' or v.nombre like ?2) and (?3 is '' or v.apellido like ?3) and (v.estado = ?4) ")
	public List<Visitante> listaVistantePorDniNombreApellidoEstado(String dni, String nombre, String apellido, int estado);
	
	
	@Query("select v from Visitante v where (v.dni = ?1)")
	public List<Visitante> listaVistantePorDni(String dni);
	
}
