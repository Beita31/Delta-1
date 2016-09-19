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

import com.una.proyecto.webapp.dao.EquipoDao;
import com.una.proyecto.webapp.model.Equipo;
import com.una.proyecto.webapp.model.Partido;
import com.una.proyecto.webapp.model.Jugador;

public class EquipoManagerImplTest extends BaseManagerMockTestCase {

	@InjectMocks
	private EquipoManagerImpl manager;

	@Mock
	private EquipoDao dao;

	@Test
	public void testAgregarPartidos() {
		// given
		final Long id = 1L;
		final Equipo equipo = new Equipo();
		equipo.setNombre("Lagartos");

		given(dao.get(id)).willReturn(equipo);

		// when
		final Set<Partido> partidos = new HashSet<Partido>();
		final Partido partido1 = new Partido();
		partido1.setNumero_partido(200);
		partidos.add(partido1);
		final Partido partido2 = new Partido();
		partido2.setNumero_partido(201);
		partidos.add(partido2);
		
		
		manager.agregarPartidos("Lagartos", partidos);

		// then

		assertTrue(equipo.getPartidos().size() == 2);
		assertEquals(equipo.getPartidos().isEmpty(), false);
	}
	
	@Test
	public void testAgregarJugadores() {
		// given
		final Long id = 1L;
		final Equipo equipo = new Equipo();
		equipo.setNombre("Lagartos");

		given(dao.get(id)).willReturn(equipo);

		// when
		final Set<Jugador> jugadores = new HashSet<Jugador>();
		final Jugador jug1 = new Jugador();
		jug1.setNombre("Keylor Navas");
		jugadores.add(jug1);
		final Jugador jug2 = new Jugador();
		jug2.setNombre("Bryan Ruiz");
		jugadores.add(jug2);
		
		
		manager.agregarJugadores("Lagartos", jugadores);

		// then

		assertTrue(equipo.getJugadores().size() == 2);
		assertEquals(equipo.getJugadores().isEmpty(), false);
	}
	
}