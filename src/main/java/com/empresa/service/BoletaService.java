package com.empresa.service;

import java.util.List;

import com.empresa.entity.Boleta;

public interface BoletaService {

	public Boleta insertaActualizaBoleta(Boleta obj);
	public List<Boleta> listaBoleta();
	public List<Boleta> listaBoletaPorServicioDepartamentoAnio(int departamento, int servicio, int anio);
	public List<Boleta> listaBoletaPorServicioDepartamentoAnioEstado(int coddepartamento, int idservicio, int anio, int estado);
	
}
