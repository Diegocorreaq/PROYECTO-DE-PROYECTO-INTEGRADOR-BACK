package com.empresa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.empresa.entity.Departamento;
import com.empresa.repository.DepartamentoRepository;

@Service
public class DepartamentoServiceImpl implements DepartamentoService {
	
	@Autowired
	private DepartamentoRepository repository;

	@Override
	public List<Departamento> listaTodos() {
		return repository.findAll();
	}

	@Override
	public List<Departamento> listaPorCod(int cod) {		
		return repository.findByCodDepartamento(cod);
	}

	@Override
	public Departamento insertaActualizaDepartamento(Departamento obj) {
		return repository.save(obj);
	}

	@Override
	public void eliminaPorId(int cod) {
		repository.deleteById(cod);

	}

}
