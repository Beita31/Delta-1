package com.una.proyecto.webapp.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.List;

import org.appfuse.dao.BaseDaoTestCase;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;

import com.una.proyecto.webapp.model.Partido;

public class PartidoDaoTest extends BaseDaoTestCase {
    @Autowired
    private PartidoDao partidoDao;
    
    @Test
    public void testFindPartidoByDate() throws Exception {
        List<Partido> partidos = partidoDao.findByDate("1996-12-16");
        assertTrue(partidos.size() > 0);
    }

    @Test(expected=DataAccessException.class)
    public void testAddAndRemovePartido() throws Exception {
        Partido partido = new Partido();
        partido.setPor_pagar(new Float("14000"));
        partido.setFecha_hora("1996-12-16");
        partido = partidoDao.save(partido);
        flush();
        partido = partidoDao.get(partido.getNumero_partido());
        assertEquals("1996-12-16", partido.getFecha_hora());
        assertNotNull(partido.getNumero_partido());
        log.debug("removing partido...");
        partidoDao.remove(partido.getNumero_partido());
        flush();
        // should throw DataAccessException
        partidoDao.get(partido.getNumero_partido());
    }
}
