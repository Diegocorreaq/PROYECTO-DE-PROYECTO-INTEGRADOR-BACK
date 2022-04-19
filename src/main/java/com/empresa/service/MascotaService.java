package com.empresa.service;

import java.util.List;

import com.empresa.entity.Mascota;



public interface MascotaService {
	
	public abstract List<Mascota> listaTodos();
	public abstract List<Mascota> listaPorCod(int cod);
	public abstract Mascota insertaActualizaMascota(Mascota obj);
	public abstract void eliminaPorId(int cod);
	
}
