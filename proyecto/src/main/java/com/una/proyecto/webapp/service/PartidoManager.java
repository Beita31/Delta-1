package com.una.proyecto.webapp.service;

import java.util.Set;

import org.appfuse.service.GenericManager;

import com.una.proyecto.webapp.model.Equipo;
import com.una.proyecto.webapp.model.Partido;

public interface PartidoManager extends GenericManager<Partido, Long> {

	void agregarEquipos(String fechaPartido, Set<Equipo> equipos);
}
