package com.empresa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.empresa.entity.Incidente;
import com.empresa.repository.IncidenteRepository;

@Service
public class IncidenteServiceImpl implements IncidenteService{
	
	@Autowired IncidenteRepository repository;

	@Override
	public Incidente insertaActualizaIncidente(Incidente obj) {
		return repository.save(obj);
	}

	@Override
	public List<Incidente> listaIncidente() {
		return repository.findAll();
	}

	@Override
	public List<Incidente> listaIncidentePorCausaIncidenteEstado(int coddepartamento, int idCausaIncidente,
			int estado) {
		return repository.listaIncidentePorCausaIncidenteEstado(coddepartamento, idCausaIncidente, estado);
	}

}
