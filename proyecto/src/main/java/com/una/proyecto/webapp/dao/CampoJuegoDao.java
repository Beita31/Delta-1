package com.una.proyecto.webapp.dao;

import java.util.List;

import org.appfuse.dao.GenericDao;
import com.una.proyecto.webapp.model.CampoJuego;;

public interface CampoJuegoDao extends GenericDao<CampoJuego, Long> {
	public List<CampoJuego> findByName(String name);

}
