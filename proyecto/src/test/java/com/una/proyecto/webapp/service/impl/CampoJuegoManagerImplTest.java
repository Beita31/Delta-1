package com.una.proyecto.webapp.service.impl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.BDDMockito.given;

import java.util.HashSet;
import java.util.Set;

import org.appfuse.service.impl.BaseManagerMockTestCase;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import com.una.proyecto.webapp.dao.CampoJuegoDao;
import com.una.proyecto.webapp.model.CampoJuego;
import com.una.proyecto.webapp.model.Partido;

public class CampoJuegoManagerImplTest extends BaseManagerMockTestCase {

	@InjectMocks
	private CampoJuegoManagerImpl manager;

	@Mock
	private CampoJuegoDao dao;

	@Test
	public void testAgregarPartidos() {
		// given
		final Long id = 1L;
		final CampoJuego campoJuego = new CampoJuego();
		campoJuego.setNombre("Premier #7");

		given(dao.get(id)).willReturn(campoJuego);

		// when
		final Set<Partido> partidos = new HashSet<Partido>();
		final Partido partido1 = new Partido();
		partido1.setNumero_partido(200);
		partidos.add(partido1);
		final Partido partido2 = new Partido();
		partido2.setNumero_partido(201);
		partidos.add(partido2);
		
		
		manager.agregarPartidos("Premier #7", partidos);

		// then

		assertTrue(campoJuego.getPartidos().size() == 2);
		assertEquals(campoJuego.getPartidos().isEmpty(), false);
	}
	
}