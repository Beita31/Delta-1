package com.una.proyecto.webapp.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

//Es el equivalente a locacion
@XmlRootElement
@Entity
@Table(name = "campo_juego")
public class CampoJuego {
	private int id;
	private float precio;
	private String direccion;
	private String cuenta_deposito;
	private Set<Contacto> contactos;
	private Set<Partido> partidos;
	private String nombre;
	
	public CampoJuego() {
		// TODO Auto-generated constructor stub
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "campoJuego_id", unique = true, nullable = false)
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	@Column(name = "precio")
	public float getPrecio() {
		return precio;
	}

	public void setPrecio(float precio) {
		this.precio = precio;
	}
	
	@Column(name = "direccion", length = 255)
	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	@Column(name = "cuenta_deposito", length = 255)
	public String getCuenta_deposito() {
		return cuenta_deposito;
	}

	public void setCuenta_deposito(String cuenta_deposito) {
		this.cuenta_deposito = cuenta_deposito;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "campoJuego", cascade = CascadeType.ALL)
	// @JsonIgnore
	// @XmlTransient
	public Set<Contacto> getContactos() {
		return contactos;
	}

	public void setContactos(Set<Contacto> contactos) {
		this.contactos = contactos;
	}
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "campoJuego", cascade = CascadeType.ALL)
	// @JsonIgnore
	// @XmlTransient
	public Set<Partido> getPartidos() {
		return partidos;
	}

	public void setPartidos(Set<Partido> partidos) {
		this.partidos = partidos;
	}

	public String getNombre() {
		return nombre;
	}

	@Column(name = "nombre", length = 255)
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((contactos == null) ? 0 : contactos.hashCode());
		result = prime * result
				+ ((cuenta_deposito == null) ? 0 : cuenta_deposito.hashCode());
		result = prime * result
				+ ((direccion == null) ? 0 : direccion.hashCode());
		result = prime * result + id;
		result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
		result = prime * result
				+ ((partidos == null) ? 0 : partidos.hashCode());
		result = prime * result + Float.floatToIntBits(precio);
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
		CampoJuego other = (CampoJuego) obj;
		if (contactos == null) {
			if (other.contactos != null)
				return false;
		} else if (!contactos.equals(other.contactos))
			return false;
		if (cuenta_deposito == null) {
			if (other.cuenta_deposito != null)
				return false;
		} else if (!cuenta_deposito.equals(other.cuenta_deposito))
			return false;
		if (direccion == null) {
			if (other.direccion != null)
				return false;
		} else if (!direccion.equals(other.direccion))
			return false;
		if (id != other.id)
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
		if (Float.floatToIntBits(precio) != Float.floatToIntBits(other.precio))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "CampoJuego [id=" + id + ", precio=" + precio + ", direccion="
				+ direccion + ", cuenta_deposito=" + cuenta_deposito
				+ ", contactos=" + contactos + ", partidos=" + partidos
				+ ", nombre=" + nombre + "]";
	}

	
	
}
