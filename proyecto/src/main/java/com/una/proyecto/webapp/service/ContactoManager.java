package com.una.proyecto.webapp.service;

import org.appfuse.service.GenericManager;

import com.una.proyecto.webapp.model.CampoJuego;
import com.una.proyecto.webapp.model.Contacto;

public interface ContactoManager extends GenericManager<Contacto, Long> {

	CampoJuego obtenerCampoJuego(String contacto);
	
}