package com.empresa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.empresa.entity.Visita;
import com.empresa.repository.VisitaRepository;

@Service
public class VisitaServiceImpl implements VisitaService {

	@Autowired VisitaRepository repository;
	
	@Override
	public Visita insertaActualizaVisita(Visita obj) {
		return repository.save(obj);
	}

	@Override
	public List<Visita> listaVisita() {
		return repository.findAll();
	}

}
