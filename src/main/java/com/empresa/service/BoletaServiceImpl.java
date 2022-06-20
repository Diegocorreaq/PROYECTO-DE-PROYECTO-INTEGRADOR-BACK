package com.empresa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.empresa.entity.Boleta;
import com.empresa.repository.BoletaRepository;

@Service
public class BoletaServiceImpl implements BoletaService{

	@Autowired BoletaRepository repository;

	@Override
	public Boleta insertaActualizaBoleta(Boleta obj) {
		return repository.save(obj);
	}

	@Override
	public List<Boleta> listaBoleta() {
		return repository.findAll();
	}

	@Override
	public List<Boleta> listaBoletaPorServicioDepartamentoAnio(int servicio, int departamento, int anio) {
		return repository.listaBoletaPorServicioDepartamentoAnio(servicio, departamento, anio);
	}

	@Override
	public List<Boleta> listaBoletaPorServicioDepartamentoAnioEstado(int servicio, int departamento, int anio,
			int estado) {
		return repository.listaBoletaPorServicioDepartamentoAnioEstado(servicio, departamento, anio, estado);
	}
	
}
