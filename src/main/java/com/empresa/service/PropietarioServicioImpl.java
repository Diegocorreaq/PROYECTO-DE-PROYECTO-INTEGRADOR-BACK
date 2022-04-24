package com.empresa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.empresa.entity.Habitante;
import com.empresa.repository.PropietarioRepository;

@Service
public class PropietarioServicioImpl implements PropietarioService {
	@Autowired
	private PropietarioRepository repository;

	@Override
	public List<Habitante> listaTodos() {
		return repository.findAll();
	}

	@Override
	public List<Habitante> listaPorId(int id) {
		return repository.findByIdPropietario(id);
	}

	@Override
	public Habitante insertaActualizaPropietario(Habitante obj) {
		return repository.save(obj);
	}

	@Override
	public void eliminaPorId(int id) {
		repository.deleteById(id);

	}

}
