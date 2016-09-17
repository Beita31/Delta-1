package com.una.proyecto.webapp.service;

import org.appfuse.service.GenericManager;

import com.una.proyecto.webapp.model.Equipo;
import com.una.proyecto.webapp.model.Jugador;

public interface JugadorManager extends GenericManager<Jugador, Long> {

	boolean perteneceAEquipo(Jugador jugador, Equipo equipo);
}
