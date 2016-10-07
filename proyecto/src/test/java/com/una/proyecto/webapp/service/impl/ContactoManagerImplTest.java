package com.una.proyecto.webapp.service.impl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.BDDMockito.given;

import org.appfuse.service.impl.BaseManagerMockTestCase;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import java.util.List;

import com.una.proyecto.webapp.dao.ContactoDao;
import com.una.proyecto.webapp.model.CampoJuego;
import com.una.proyecto.webapp.model.Contacto;

public class ContactoManagerImplTest extends BaseManagerMockTestCase {

	@InjectMocks
	private ContactoManagerImpl manager;

	@Mock
	private ContactoDao dao;

	@Test
	public void testObtenerCampoJuego() {
		// given
		final Long id = new Long(115360687);
		final Contacto contacto = new Contacto();
		contacto.setNombre("Premier #5");

		given(dao.get(id)).willReturn(contacto);

		// when
		CampoJuego campoJuego = manager.obtenerCampoJuego("Premier #5");
		
		// then
		assertTrue(campoJuego != null);
		List<Contacto> contacto2 = dao.findByName("Premier #5");
		if(contacto2!= null){
			if(contacto2.size() > 0){
				assertEquals(contacto2.get(0).getCampoJuego(), campoJuego);
			}
		}
	}
	
}
