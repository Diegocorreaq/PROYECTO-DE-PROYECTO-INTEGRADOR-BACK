package com.empresa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.empresa.entity.Mascota;
import com.empresa.repository.MascotaRepository;

@Service
public class MascotaServiceImpl implements MascotaService {

	@Autowired MascotaRepository repository;
	
	@Override
	public Mascota insertaActualizaMascota(Mascota obj) {
		return repository.save(obj);
	}

	@Override
	public List<Mascota> listaMascota() {
		return repository.findAll();
	}

}
