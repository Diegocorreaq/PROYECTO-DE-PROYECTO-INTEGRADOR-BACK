package com.empresa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.empresa.entity.Habitante;
import com.empresa.repository.HabitanteRepository;

@Service
public class HabitanteServiceImpl implements HabitanteService {

	@Autowired HabitanteRepository repositorio;

	@Override
	public Habitante insertaActualizaHabitante(Habitante obj) {
		return repositorio.save(obj);
	}

	@Override
	public List<Habitante> listaHabitante() {
		return repositorio.findAll();
	}
	
	
}
