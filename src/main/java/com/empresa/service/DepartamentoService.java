package com.empresa.service;

import java.util.List;

import com.empresa.entity.Departamento;


public interface DepartamentoService {
	
	public abstract List<Departamento> listaTodos();
	public abstract List<Departamento> listaPorCod(int cod);
	public abstract Departamento insertaActualizaDepartamento(Departamento obj);
	public abstract void eliminaPorId(int cod);
	
}
