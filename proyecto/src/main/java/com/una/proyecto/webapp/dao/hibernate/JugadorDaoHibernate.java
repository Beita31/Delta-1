package com.una.proyecto.webapp.dao.hibernate;

import java.util.List;

import org.appfuse.dao.hibernate.GenericDaoHibernate;
import com.una.proyecto.webapp.dao.JugadorDao;
import com.una.proyecto.webapp.model.Jugador;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

@Repository("jugadorDao")
public class JugadorDaoHibernate extends GenericDaoHibernate<Jugador, Long> implements JugadorDao {

	public JugadorDaoHibernate() {
		super(Jugador.class);
		// TODO Auto-generated constructor stub
	}

	@SuppressWarnings("unchecked")
	public List<Jugador> findByName(String name) {
		return getSession().createCriteria(Jugador.class).add(Restrictions.eq("nombre", name)).list();
	}

}
