package com.empresa.service;

import java.util.List;

import com.empresa.entity.Incidente;

public interface IncidenteService {

	public Incidente insertaActualizaIncidente(Incidente obj);
	public List<Incidente> listaIncidente();
	public List<Incidente> listaIncidentePorCausaIncidenteEstado(int coddepartamento, int idCausaIncidente, int estado);
	
}
