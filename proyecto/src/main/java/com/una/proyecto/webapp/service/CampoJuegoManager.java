package com.una.proyecto.webapp.service;

import java.util.Set;

import org.appfuse.service.GenericManager;

import com.una.proyecto.webapp.model.CampoJuego;
import com.una.proyecto.webapp.model.Partido;

public interface CampoJuegoManager extends GenericManager<CampoJuego, Long> {

	void agregarPartidos(String campoJuego, Set<Partido> partidos);
	
}