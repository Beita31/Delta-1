package com.una.proyecto.webapp.service;

import java.sql.Date;
import java.util.Set;

import org.appfuse.service.GenericManager;

import com.una.proyecto.webapp.model.Equipo;
import com.una.proyecto.webapp.model.Partido;

public interface PartidoManager extends GenericManager<Partido, Long> {

	void agregarEquipos(Date fechaPartido, Set<Equipo> equipos);
}