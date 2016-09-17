package com.una.proyecto.webapp.dao.hibernate;

import java.util.List;

import org.appfuse.dao.hibernate.GenericDaoHibernate;
import com.una.proyecto.webapp.dao.EquipoDao;
import com.una.proyecto.webapp.model.Equipo;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

@Repository("equipoDao")
public class EquipoDaoHibernate extends GenericDaoHibernate<Equipo, Long> implements EquipoDao {

	public EquipoDaoHibernate() {
		super(Equipo.class);
		// TODO Auto-generated constructor stub
	}

	@SuppressWarnings("unchecked")
	public List<Equipo> findByName(String name) {
		return getSession().createCriteria(Equipo.class).add(Restrictions.eq("nombre", name)).list();
	}

}
