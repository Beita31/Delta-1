package com.una.proyecto.webapp.service.impl;

import java.util.List;
import java.util.Set;

import org.appfuse.service.impl.GenericManagerImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.una.proyecto.webapp.dao.CampoJuegoDao;
import com.una.proyecto.webapp.model.CampoJuego;
import com.una.proyecto.webapp.model.Partido;
import com.una.proyecto.webapp.service.CampoJuegoManager;

@Transactional
@Service("campoJuegoManager")
public class CampoJuegoManagerImpl extends GenericManagerImpl<CampoJuego, Long> implements CampoJuegoManager {

	CampoJuegoDao campoJuegoDao;
	
	@Autowired
	public CampoJuegoManagerImpl(CampoJuegoDao campoJuegoDao) {
		super(campoJuegoDao);
		this.campoJuegoDao = campoJuegoDao;
	}
	
	@Override
	public void agregarPartidos(String campoJuego, Set<Partido> partidos) {
		List<CampoJuego> campos = campoJuegoDao.findByName(campoJuego);
		if(!campos.isEmpty())
			for (Partido partido : partidos) {
				campos.get(0).getPartidos().add(partido);
			}
		
	}

}
