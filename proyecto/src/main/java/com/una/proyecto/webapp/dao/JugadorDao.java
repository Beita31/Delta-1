package com.una.proyecto.webapp.dao;

import java.util.List;

import org.appfuse.dao.GenericDao;
import com.una.proyecto.webapp.model.Jugador;

public interface JugadorDao extends GenericDao<Jugador, Long> {
	public List<Jugador> findByName(String name);

}
