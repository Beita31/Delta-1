package com.una.proyecto.webapp.dao;

import java.util.List;

import org.appfuse.dao.GenericDao;
import com.una.proyecto.webapp.model.Contacto;

public interface ContactoDao extends GenericDao<Contacto, Long> {
	public List<Contacto> findByName(String name);

}
