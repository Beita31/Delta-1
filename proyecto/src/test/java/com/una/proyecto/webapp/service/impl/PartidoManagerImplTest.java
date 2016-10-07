package com.una.proyecto.webapp.service.impl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.BDDMockito.given;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.HashSet;
import java.util.Set;

import org.appfuse.service.impl.BaseManagerMockTestCase;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import com.una.proyecto.webapp.dao.PartidoDao;
import com.una.proyecto.webapp.model.Equipo;
import com.una.proyecto.webapp.model.Partido;

public class PartidoManagerImplTest extends BaseManagerMockTestCase {

	@InjectMocks
	private PartidoManagerImpl manager;

	@Mock
	private PartidoDao dao;

	@Test
	public void testAgregarEquipos() throws ParseException {
		// given
		final Long id = new Long(1);
		final Partido partido = new Partido();
    	String date = "1996-12-16";
		partido.setFecha_hora(date);

		given(dao.get(id)).willReturn(partido);

		// when
		final Set<Equipo> equipos = new HashSet<Equipo>();
		final Equipo equipo1 = new Equipo();
		equipo1.setNombre("Heredia");
		equipos.add(equipo1);
		final Equipo equipo2 = new Equipo();
		equipo2.setNombre("Limon");
		equipos.add(equipo2);
		
		
		manager.agregarEquipos(date, equipos);

		// then
		if(partido.getEquipos()!=null){
			assertTrue(partido.getEquipos().size() == 2);
			assertEquals(partido.getEquipos().isEmpty(), false);
		}
	}
	
}
