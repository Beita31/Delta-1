package com.una.proyecto.webapp.service;

import java.util.Set;

import org.appfuse.service.GenericManager;

import com.una.proyecto.webapp.model.Equipo;
import com.una.proyecto.webapp.model.Jugador;
import com.una.proyecto.webapp.model.Partido;

public interface EquipoManager extends GenericManager<Equipo, Long> {

	void agregarJugadores(String nombreEquipo, Set<Jugador> jugadores);
	void agregarPartidos(String nombreEquipo, Set<Partido> partidos);
	
}