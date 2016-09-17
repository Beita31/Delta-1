package com.una.proyecto.webapp.dao.hibernate;

import java.sql.Date;
import java.util.List;

import org.appfuse.dao.hibernate.GenericDaoHibernate;

import com.una.proyecto.webapp.dao.PartidoDao;
import com.una.proyecto.webapp.model.Partido;

import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

@Repository("partidoDao")
public class PartidoDaoHibernate extends GenericDaoHibernate<Partido, Long> implements PartidoDao {

	public PartidoDaoHibernate() {
		super(Partido.class);
		// TODO Auto-generated constructor stub
	}

	@SuppressWarnings("unchecked")
	public List<Partido> findByDate(Date fecha_hora) {
		return getSession().createCriteria(Partido.class).add(Restrictions.eq("fecha_hora", fecha_hora)).list();
	}

}
