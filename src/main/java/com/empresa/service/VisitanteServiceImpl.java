package com.empresa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.empresa.entity.Visitante;
import com.empresa.repository.VisitanteRepository;

@Service
public class VisitanteServiceImpl implements VisitanteService {

	@Autowired
	private VisitanteRepository repository;
	
	@Override
	public List<Visitante> listaTodos() {
		return repository.findAll();
	}

	@Override
	public List<Visitante> listaPorId(int id) {
		return repository.findByIdVisitante(id);
	}

	@Override
	public Visitante insertaActualizaVisitante(Visitante obj) {
		return repository.save(obj);
	}

	@Override
	public void eliminaPorId(int id) {
		repository.deleteById(id);

	}

}
