package com.empresa.service;

import java.util.List;

import com.empresa.entity.Propietario;

public interface PropietarioService {
	
	public abstract List<Propietario> listaTodos();
	public abstract List<Propietario> listaPorId(int id);
	public abstract Propietario insertaActualizaPropietario(Propietario obj);
	public abstract void eliminaPorId(int id);
	
}
