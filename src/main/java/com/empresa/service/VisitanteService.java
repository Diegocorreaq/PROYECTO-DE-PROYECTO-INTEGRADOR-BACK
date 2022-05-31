package com.empresa.service;

import java.util.List;

import com.empresa.entity.Visitante;

public interface VisitanteService {

	public Visitante insertaActualizaVisitante(Visitante obj);
	public List<Visitante> listaVisitante();
	public List<Visitante> listaVisitantePorDni(String dni);
	public List<Visitante> listaVistantePorDniNombreApellidoEstado(String dni, String nombre, String apellido, int estado);
	
}
