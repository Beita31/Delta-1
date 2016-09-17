package com.una.proyecto.webapp.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.appfuse.dao.BaseDaoTestCase;
import com.una.proyecto.webapp.model.Equipo;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;

public class EquipoDaoTest extends BaseDaoTestCase {
    @Autowired
    private EquipoDao equipoDao;

    @Test
    public void testFindEquipoByName() throws Exception {
        List<Equipo> equipos = equipoDao.findByName("Tuercas FC");
        assertTrue(equipos.size() > 0);
    }

    @Test(expected=DataAccessException.class)
    public void testAddAndRemoveEquipo() throws Exception {
        Equipo equipo = new Equipo();
        equipo.setNombre("Tuercas");
        equipo.setId(1);
        equipo = equipoDao.save(equipo);
        flush();
        equipo = equipoDao.get(new Long (equipo.getId()));
        assertEquals("Tuercas FC", equipo.getNombre());
        assertNotNull(equipo.getNombre());
        log.debug("removing equipo...");
        equipoDao.remove(new Long (equipo.getId()));
        flush();
        // should throw DataAccessException
        equipoDao.get(new Long (equipo.getId()));
    }
}