package com.una.proyecto.webapp.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.appfuse.dao.BaseDaoTestCase;
import com.una.proyecto.webapp.model.Jugador;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;

public class JugadorDaoTest extends BaseDaoTestCase {
    @Autowired
    private JugadorDao jugadorDao;

    @Test
    public void testFindJugadorByName() throws Exception {
        List<Jugador> jugadores = jugadorDao.findByName("ESTEBAN");
        assertTrue(jugadores.size() > 0);
    }

    @Test(expected=DataAccessException.class)
    public void testAddAndRemoveJugador() throws Exception {
        Jugador jugador = new Jugador();
        jugador.setNombre("ESTEBAN");
        jugador.setEmail("emhernandezb@gmail.com");
        jugador.setTelefono("87013173");
        jugador.setCuenta("200-04-345-903-2");
        jugador.setContacto(true);
        jugador = jugadorDao.save(jugador);
        flush();
        jugador = jugadorDao.get(new Long (jugador.getId()));
        assertEquals("ESTEBAN", jugador.getNombre());
        assertNotNull(jugador.getNombre());
        log.debug("removing jugador...");
        jugadorDao.remove(new Long (jugador.getId()));
        flush();
        // should throw DataAccessException
        jugadorDao.get(new Long (jugador.getId()));
    }
}
