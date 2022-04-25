package com.empresa.service;

import java.util.List;

import com.empresa.entity.Mascota;

public interface MascotaService {

	public Mascota insertaActualizaMascota(Mascota obj);
	public List<Mascota> listaMascota();
	
}
