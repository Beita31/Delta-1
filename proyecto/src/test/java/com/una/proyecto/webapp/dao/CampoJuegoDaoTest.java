package com.una.proyecto.webapp.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.appfuse.dao.BaseDaoTestCase;
import com.una.proyecto.webapp.model.CampoJuego;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;

public class CampoJuegoDaoTest extends BaseDaoTestCase {
    @Autowired
    private CampoJuegoDao campoJuegoDao;

    @Test
    public void testFindCampoJuegoByName() throws Exception {
        List<CampoJuego> camposJuegos = campoJuegoDao.findByName("Premier #5");
        assertTrue(camposJuegos.size() > 0);
    }

    @Test(expected=DataAccessException.class)
    public void testAddAndRemoveCampoJuego() throws Exception {
        CampoJuego campoJuego = new CampoJuego();
        campoJuego.setNombre("Premier #5");
        campoJuego.setDireccion("San Pablo, Heredia. 100 m norte del cementerio.");
        campoJuego.setPrecio(new Float("7500"));
        campoJuego.setCuenta_deposito("234-05-555-113-7");
        campoJuego = campoJuegoDao.save(campoJuego);
        flush();
        campoJuego = campoJuegoDao.get(new Long (campoJuego.getId()));
        assertEquals("Premier #5", campoJuego.getNombre());
        assertNotNull(campoJuego.getNombre());
        log.debug("removing campo de juego...");
        campoJuegoDao.remove(new Long (campoJuego.getId()));
        flush();
        // should throw DataAccessException
        campoJuegoDao.get(new Long (campoJuego.getId()));
    }
}
