package com.una.proyecto.webapp.service.impl;

import java.sql.Date;
import java.util.List;
import java.util.Set;

import org.appfuse.service.impl.GenericManagerImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.una.proyecto.webapp.dao.PartidoDao;
import com.una.proyecto.webapp.model.Equipo;
import com.una.proyecto.webapp.model.Partido;
import com.una.proyecto.webapp.service.PartidoManager;

@Transactional
@Service("partidoManager")
public class PartidoManagerImpl extends GenericManagerImpl<Partido, Long> implements PartidoManager {

	PartidoDao partidoDao;
	
	@Autowired
	public PartidoManagerImpl(PartidoDao partidoDao) {
		super(partidoDao);
		this.partidoDao = partidoDao;
	}
	
	@Override
	public void agregarEquipos(Date fechaPartido, Set<Equipo> equipos) {
		List<Partido> partidos = partidoDao.findByDate(fechaPartido);
		if(!partidos.isEmpty())
			for (Equipo equipo : equipos) {
				partidos.get(0).getEquipos().add(equipo);
			}
	}

}
