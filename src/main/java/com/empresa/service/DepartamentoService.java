package com.empresa.service;

import java.util.List;

import com.empresa.entity.Departamento;

public interface DepartamentoService {

	public Departamento insertaActualizaDepartamento(Departamento obj);
	public List<Departamento> listaDepartamento();
	
}
