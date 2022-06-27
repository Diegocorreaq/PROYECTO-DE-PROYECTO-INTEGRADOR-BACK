package com.empresa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.empresa.entity.Incidente;



public interface IncidenteRepository extends JpaRepository<Incidente, Integer>{
	
	@Query("select i from Incidente i where (?1 = -1 or i.departamento.codDepartamento = ?1) and (?2 = -1 or i.causaIncidente.idCausaIncidente = ?2)  and (i.estado = ?3) ")
	public List<Incidente> listaIncidentePorCausaIncidenteEstado(int coddepartamento, int idCausaIncidente, int estado); 
	
	

	
	
	

}
