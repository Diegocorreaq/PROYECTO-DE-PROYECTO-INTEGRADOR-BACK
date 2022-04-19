package com.empresa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.empresa.entity.Mascota;
import com.empresa.repository.MascotaRepository;

@Service
public class MascotaServiceImpl implements MascotaService {

	@Autowired
	private MascotaRepository repository;
	
	@Override
	public List<Mascota> listaTodos() {
		return repository.findAll();
	}

	@Override
	public List<Mascota> listaPorCod(int cod) {
		return repository.findByCodMascota(cod);
	}

	@Override
	public Mascota insertaActualizaMascota(Mascota obj) {
		return repository.save(obj);
	}

	@Override
	public void eliminaPorId(int cod) {
		repository.deleteById(cod);

	}

}
