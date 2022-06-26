package com.empresa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.empresa.entity.Boleta;



public interface BoletaRepository extends JpaRepository<Boleta, Integer>{
	@Query("select b from Boleta b where (?1 = -1 or b.departamento = ?1) and (?2 = -1 or b.servicio = ?2) and (?3 = -1 or b.anio = ?3)")
	public List<Boleta> listaBoletaPorServicioDepartamentoAnio(int departamento, int servicio, int anio);
	
	@Query("select b from Boleta b where (?1 = -1 or b.departamento.codDepartamento = ?1) and (?2 = -1 or b.servicio.idServicio = ?2) and (?3 = -1 or b.anio = ?3) and (b.estado = ?4) ")
	public List<Boleta> listaBoletaPorServicioDepartamentoAnioEstado(int coddepartamento, int idservicio, int anio, int estado);
	

	
	
	

}
