package com.una.proyecto.webapp.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@Entity
@Table(name = "equipo")
public class Equipo {
	private int id;
	private String nombre;
	private Set<Jugador> jugadores;
	private Set<Partido> partidos;

	public Equipo() {
		// TODO Auto-generated constructor stub
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "equipo_id", unique = true, nullable = false)
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Column(name = "nombre", length = 100)
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "equipo", cascade = CascadeType.ALL)
	// @JsonIgnore
	// @XmlTransient
	public Set<Jugador> getJugadores() {
		return jugadores;
	}

	public void setJugadores(Set<Jugador> jugadores) {
		this.jugadores = jugadores;
	}
	
	@ManyToMany(fetch = FetchType.LAZY, mappedBy = "equipos", cascade = CascadeType.ALL)
	// @JsonIgnore
	// @XmlTransient
	public Set<Partido> getPartidos() {
		return partidos;
	}

	public void setpartidos(Set<Partido> partidos) {
		this.partidos = partidos;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result
				+ ((jugadores == null) ? 0 : jugadores.hashCode());
		result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
		result = prime * result
				+ ((partidos == null) ? 0 : partidos.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Equipo other = (Equipo) obj;
		if (id != other.id)
			return false;
		if (jugadores == null) {
			if (other.jugadores != null)
				return false;
		} else if (!jugadores.equals(other.jugadores))
			return false;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		if (partidos == null) {
			if (other.partidos != null)
				return false;
		} else if (!partidos.equals(other.partidos))
			return false;
		
		return true;
	}

	@Override
	public String toString() {
		return "Equipo [id=" + id + ", nombre=" + nombre + ", jugadores="
				+ jugadores + ", partidos=" + partidos + "]";
	}

}
