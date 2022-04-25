package com.empresa.service;

import java.util.List;

import com.empresa.entity.Habitante;

public interface HabitanteService {

	public Habitante insertaActualizaHabitante(Habitante obj);
	public List<Habitante> listaHabitante();
	
}
