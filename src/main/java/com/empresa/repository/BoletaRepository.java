package com.empresa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.empresa.entity.Boleta;



public interface BoletaRepository extends JpaRepository<Boleta, Integer>{
	@Query("select b from Boleta b where (?1 is '' or b.departamento = ?1) and (?2 is '' or b.servicio like ?2) and (?3 is '' or b.anio = ?3)")
	public List<Boleta> listaBoletaPorServicioDepartamentoAnio(int servicio, int departamento, int anio);
	
	@Query("select b from Boleta b where (?1 is '' or b.departamento = ?1) and (?2 is '' or b.servicio like ?2) and (?3 is '' or b.anio = ?3) and (b.estado = ?4) ")
	public List<Boleta> listaBoletaPorServicioDepartamentoAnioEstado(int servicio, int departamento, int anio, int estado);
	
	
}
