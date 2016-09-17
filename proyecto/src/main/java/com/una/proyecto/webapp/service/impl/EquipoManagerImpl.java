package com.una.proyecto.webapp.service.impl;

import java.util.List;
import java.util.Set;

import org.appfuse.service.impl.GenericManagerImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.una.proyecto.webapp.model.Equipo;
import com.una.proyecto.webapp.model.Jugador;
import com.una.proyecto.webapp.model.Partido;
import com.una.proyecto.webapp.service.EquipoManager;

import com.una.proyecto.webapp.dao.EquipoDao;

@Transactional
@Service("equipoManager")
public class EquipoManagerImpl extends GenericManagerImpl<Equipo, Long> implements EquipoManager {

	EquipoDao equipoDao;
	
	@Autowired
	public EquipoManagerImpl(EquipoDao equipoDao) {
		super(equipoDao);
		this.equipoDao = equipoDao;
	}
	
	@Override
	public void agregarJugadores(String nombreEquipo, Set<Jugador> jugadores) {
		List<Equipo> equipos = equipoDao.findByName(nombreEquipo);
		if(!equipos.isEmpty())
			for (Jugador jugador : jugadores) {
				equipos.get(0).getJugadores().add(jugador);
			}
	}

	@Override
	public void agregarPartidos(String nombreEquipo, Set<Partido> partidos) {
		List<Equipo> equipos = equipoDao.findByName(nombreEquipo);
		if(!equipos.isEmpty())
			for (Partido partido : partidos) {
				equipos.get(0).getPartidos().add(partido);
			}
		
	}

}
