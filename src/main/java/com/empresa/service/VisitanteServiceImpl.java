package com.empresa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.empresa.entity.Visitante;
import com.empresa.repository.VisitanteRepository;

@Service
public class VisitanteServiceImpl implements VisitanteService {

	@Autowired VisitanteRepository repository;
	
	@Override
	public Visitante insertaActualizaVisitante(Visitante obj) {
		return repository.save(obj);
	}

	@Override
	public List<Visitante> listaVisitante() {
		return repository.findAll();
	}

	@Override
	public List<Visitante> listaVistantePorDniNombreApellidoEstado(String dni, String nombre, String apellido,
			int estado) {
		return repository.listaVistantePorDniNombreApellidoEstado(dni, nombre, apellido, estado);
	}

	@Override
	public List<Visitante> listaVisitantePorDni(String dni) {
		return repository.listaVistantePorDni(dni);
	}

}
