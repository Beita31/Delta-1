package com.una.proyecto.webapp.service.impl;

import java.util.List;

import org.appfuse.service.impl.GenericManagerImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.una.proyecto.webapp.dao.ContactoDao;
import com.una.proyecto.webapp.model.CampoJuego;
import com.una.proyecto.webapp.model.Contacto;
import com.una.proyecto.webapp.service.ContactoManager;

@Transactional
@Service("contactoManager")
public class ContactoManagerImpl extends GenericManagerImpl<Contacto, Long> implements ContactoManager {

	ContactoDao contactoDao;
	
	@Autowired
	public ContactoManagerImpl(ContactoDao contactoDao) {
		super(contactoDao);
		this.contactoDao = contactoDao;
	}
	
	@Override
	public CampoJuego obtenerCampoJuego(String descripcion) {
		List<Contacto> contacto = contactoDao.findByName(descripcion);
		if(contacto.size() > 0)
			return contacto.get(0).getCampoJuego();
		return null;
	}

}
