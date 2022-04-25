package com.empresa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.empresa.entity.TipoHabitante;
import com.empresa.repository.TipoHabitanteRepository;

@Service
public class TipoHabitanteServiceImpl implements TipoHabitanteService {

	@Autowired
	private TipoHabitanteRepository repository;
	@Override
	public List<TipoHabitante> listaTipoHabitante() {
		return repository.findAll();
	}

}
