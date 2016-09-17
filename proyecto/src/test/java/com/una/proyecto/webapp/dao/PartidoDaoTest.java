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
    	SimpleDateFormat sdf = new SimpleDateFormat("dd-M-yyyy hh:mm:ss");
    	String dateInString = "31-08-2016 10:20:56";
    	Date date = (Date)sdf.parse(dateInString);
        List<Partido> partidos = partidoDao.findByDate(date);
        assertTrue(partidos.size() > 0);
    }

    @Test(expected=DataAccessException.class)
    public void testAddAndRemovePartido() throws Exception {
        Partido partido = new Partido();
        partido.setNumero_partido(15);
        partido.setPor_pagar(new Float("14000"));
        SimpleDateFormat sdf = new SimpleDateFormat("dd-M-yyyy hh:mm:ss");
    	String dateInString = "31-08-2016 10:20:56";
    	Date date = (Date)sdf.parse(dateInString);
        partido.setFecha_hora(date);
        partido = partidoDao.save(partido);
        flush();
        partido = partidoDao.get(new Long (partido.getNumero_partido()));
        assertEquals(date, partido.getFecha_hora());
        assertNotNull(partido.getFecha_hora());
        log.debug("removing partido...");
        partidoDao.remove(new Long (partido.getNumero_partido()));
        flush();
        // should throw DataAccessException
        partidoDao.get(new Long (partido.getNumero_partido()));
    }
}