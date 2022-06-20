package com.empresa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.empresa.entity.Servicio;
import com.empresa.repository.ServicioRepository;

@Service
public class ServicioServiceImpl implements ServicioService{

	@Autowired ServicioRepository repository;
	
	@Override
	public List<Servicio> listaServicio() {
		return repository.findAll();
	}

}
