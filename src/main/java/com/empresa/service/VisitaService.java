package com.empresa.service;

import java.util.List;

import com.empresa.entity.Visita;

public interface VisitaService {

	public Visita insertaActualizaVisita(Visita obj);
	public List<Visita> listaVisita();
	public List<Visita> listaVisitaConParametros(int coddepartamento, String dni, String nombre, String apellido, int estado);
	
}
