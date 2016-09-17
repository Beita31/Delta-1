package com.una.proyecto.webapp.dao.hibernate;

import java.util.List;

import org.appfuse.dao.hibernate.GenericDaoHibernate;
import com.una.proyecto.webapp.dao.CampoJuegoDao;
import com.una.proyecto.webapp.model.CampoJuego;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

@Repository("campoJuegoDao")
public class CampoJuegoDaoHibernate extends GenericDaoHibernate<CampoJuego, Long> implements CampoJuegoDao {

	public CampoJuegoDaoHibernate() {
		super(CampoJuego.class);
		// TODO Auto-generated constructor stub
	}

	@SuppressWarnings("unchecked")
	public List<CampoJuego> findByName(String name) {
		return getSession().createCriteria(CampoJuego.class).add(Restrictions.eq("nombre", name)).list();
	}

}
