package com.una.proyecto.webapp.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.appfuse.dao.BaseDaoTestCase;
import com.una.proyecto.webapp.model.Contacto;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;

public class ContactoDaoTest extends BaseDaoTestCase {
    @Autowired
    private ContactoDao contactoDao;

    @Test
    public void testFindContactoByName() throws Exception {
        List<Contacto> contactos = contactoDao.findByName("Esteban");
        assertTrue(contactos.size() > 0);
    }

    @Test(expected=DataAccessException.class)
    public void testAddAndRemoveContacto() throws Exception {
        Contacto contacto = new Contacto();
        contacto.setNombre("Esteban");
        contacto.setEmail("emhernandezb@gmail.com");
        contacto.setTelefono("87013173");
        contacto = contactoDao.save(contacto);
        flush();
        contacto = contactoDao.get(new Long (contacto.getId_contacto()));
        assertEquals("Esteban", contacto.getNombre());
        assertNotNull(contacto.getNombre());
        log.debug("removing contacto...");
        contactoDao.remove(new Long (contacto.getId_contacto()));
        flush();
        // should throw DataAccessException
        contactoDao.get(new Long (contacto.getId_contacto()));
    }
}
