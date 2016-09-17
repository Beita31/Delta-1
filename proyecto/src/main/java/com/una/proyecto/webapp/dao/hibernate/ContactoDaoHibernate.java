package com.una.proyecto.webapp.dao.hibernate;

import java.util.List;

import org.appfuse.dao.hibernate.GenericDaoHibernate;
import com.una.proyecto.webapp.dao.ContactoDao;
import com.una.proyecto.webapp.model.Contacto;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

@Repository("contactoDao")
public class ContactoDaoHibernate extends GenericDaoHibernate<Contacto, Long> implements ContactoDao {

	public ContactoDaoHibernate() {
		super(Contacto.class);
		// TODO Auto-generated constructor stub
	}

	@SuppressWarnings("unchecked")
	public List<Contacto> findByName(String name) {
		return getSession().createCriteria(Contacto.class).add(Restrictions.eq("nombre", name)).list();
	}

}
