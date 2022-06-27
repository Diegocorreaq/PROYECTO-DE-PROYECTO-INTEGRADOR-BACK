package com.empresa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.empresa.entity.CausaIncidente;
import com.empresa.repository.CausaIncidenteRepository;

@Service
public class CausaIncidenteServiceImpl implements CausaIncidenteService{
	
	@Autowired CausaIncidenteRepository repository;

	@Override
	public List<CausaIncidente> listaCausaIncidente() {
		return repository.findAll();
	}

}
