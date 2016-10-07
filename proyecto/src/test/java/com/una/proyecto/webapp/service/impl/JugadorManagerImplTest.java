package com.una.proyecto.webapp.service.impl;

import static org.junit.Assert.assertEquals;
import static org.mockito.BDDMockito.given;

import java.util.HashSet;
import java.util.Set;

import org.appfuse.service.impl.BaseManagerMockTestCase;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import com.una.proyecto.webapp.dao.JugadorDao;
import com.una.proyecto.webapp.model.Equipo;
import com.una.proyecto.webapp.model.Jugador;

public class JugadorManagerImplTest extends BaseManagerMockTestCase {

	@InjectMocks
	private JugadorManagerImpl manager;

	@Mock
	private JugadorDao dao;

	@Test
	public void testPerteneceAEquipo() {
		// given
		final Long id = new Long (115360687);
		final Jugador jugador = new Jugador();
		final Equipo equipo = new Equipo();
		Set<Jugador> jugadores = new HashSet<Jugador>();
		final Jugador jugador2 = new Jugador();
		jugador2.setId(new Long(115360688));
		jugadores.add(jugador2);
		equipo.setJugadores(jugadores);

		given(dao.get(id)).willReturn(jugador);

		// when
		boolean pertenece = manager.perteneceAEquipo(jugador, equipo);
		
		// then
		
		assertEquals(pertenece, true);
		
	}
	
}
