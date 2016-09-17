package com.una.proyecto.webapp.service.impl;

import org.appfuse.service.impl.GenericManagerImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.una.proyecto.webapp.dao.JugadorDao;
import com.una.proyecto.webapp.model.Equipo;
import com.una.proyecto.webapp.model.Jugador;
import com.una.proyecto.webapp.service.JugadorManager;

@Transactional
@Service("jugadorManager")
public class JugadorManagerImpl extends GenericManagerImpl<Jugador, Long> implements JugadorManager {
	
	JugadorDao jugadorDao;
	
	@Autowired
	public JugadorManagerImpl(JugadorDao jugadorDao) {
		super(jugadorDao);
		this.jugadorDao = jugadorDao;
	}

	@Override
	public boolean perteneceAEquipo(Jugador jugador, Equipo equipo) {
		for (Jugador jugadorActual : equipo.getJugadores()) {
			if(jugador.equals(jugadorActual))
				return true;
		}
		return false;
	}
	
}
