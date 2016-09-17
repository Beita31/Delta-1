package com.una.proyecto.webapp.dao;

import java.sql.Date;
import java.util.List;

import org.appfuse.dao.GenericDao;

import com.una.proyecto.webapp.model.Partido;

public interface PartidoDao extends GenericDao<Partido, Long> {
	public List<Partido> findByDate(Date fecha_hora);

}
