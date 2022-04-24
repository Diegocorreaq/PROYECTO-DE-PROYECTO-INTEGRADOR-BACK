package com.empresa.service;

import java.util.List;

import com.empresa.entity.Habitante;

public interface PropietarioService {
	
	public abstract List<Habitante> listaTodos();
	public abstract List<Habitante> listaPorId(int id);
	public abstract Habitante insertaActualizaPropietario(Habitante obj);
	public abstract void eliminaPorId(int id);
	
}
