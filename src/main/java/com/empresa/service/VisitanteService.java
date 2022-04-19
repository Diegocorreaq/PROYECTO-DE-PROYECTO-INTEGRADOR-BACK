package com.empresa.service;

import java.util.List;

import com.empresa.entity.Visitante;

public interface VisitanteService {
	
	public abstract List<Visitante> listaTodos();
	public abstract List<Visitante> listaPorId(int id);
	public abstract Visitante insertaActualizaVisitante(Visitante obj);
	public abstract void eliminaPorId(int id);
	
}
