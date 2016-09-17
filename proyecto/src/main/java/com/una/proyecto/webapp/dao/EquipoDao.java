package com.una.proyecto.webapp.dao;

import java.util.List;

import org.appfuse.dao.GenericDao;
import com.una.proyecto.webapp.model.Equipo;

public interface EquipoDao extends GenericDao<Equipo, Long> {
	public List<Equipo> findByName(String name);

}
