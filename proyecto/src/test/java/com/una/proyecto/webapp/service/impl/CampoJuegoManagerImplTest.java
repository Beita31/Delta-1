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
		final Long id = new Long(1);
		final CampoJuego campoJuego = new CampoJuego();
		campoJuego.setNombre("Premier #5");

		given(dao.get(id)).willReturn(campoJuego);

		// when
		final Set<Partido> partidos = new HashSet<Partido>();
		final Partido partido1 = new Partido();
		partido1.setFecha_hora("2000-12-12");
		partidos.add(partido1);
		final Partido partido2 = new Partido();
		partido2.setFecha_hora("2007-05-19");
		partidos.add(partido2);
		
		
		manager.agregarPartidos("Premier #5", partidos);

		// then

		if(campoJuego.getPartidos()!=null){
			assertTrue(campoJuego.getPartidos().size() == 2);
			assertEquals(campoJuego.getPartidos().isEmpty(), false);
		}
	}
	
}
