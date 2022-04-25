package com.empresa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.empresa.entity.Departamento;
import com.empresa.repository.DepartamentoRepository;

@Service
public class DepartamentoServiceImpl implements DepartamentoService {

	@Autowired DepartamentoRepository	repository;
	
	@Override
	public Departamento insertaActualizaDepartamento(Departamento obj) {
		return repository.save(obj);
	}

	@Override
	public List<Departamento> listaDepartamento() {
		return repository.findAll();
	}

}
