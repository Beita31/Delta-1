package com.una.proyecto.webapp.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonIgnore;

@XmlRootElement
@Entity
@Table(name = "contacto")
public class Contacto {
	private int id_contacto;
	private CampoJuego campoJuego;
	private String nombre;
	private String telefono;
	private String email;

	public Contacto() {
		// TODO Auto-generated constructor stub
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "product_id", unique = true, nullable = false)
	public int getId_contacto() {
		return id_contacto;
	}

	public void setId_contacto(int id_contacto) {
		this.id_contacto = id_contacto;
	}

	@ManyToOne
	@JoinColumn(name = "campoJuego_id", nullable = false)
	@JsonIgnore
	public CampoJuego getCampoJuego() {
		return campoJuego;
	}

	public void setCampoJuego(CampoJuego campoJuego) {
		this.campoJuego = campoJuego;
	}

	@Column(name = "nombre", length = 100)
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Column(name = "telefono", length = 15)
	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	@Column(name = "email", length = 100)
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((campoJuego == null) ? 0 : campoJuego.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + id_contacto;
		result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
		result = prime * result
				+ ((telefono == null) ? 0 : telefono.hashCode());
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
		Contacto other = (Contacto) obj;
		if (campoJuego == null) {
			if (other.campoJuego != null)
				return false;
		} else if (!campoJuego.equals(other.campoJuego))
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (id_contacto != other.id_contacto)
			return false;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		if (telefono == null) {
			if (other.telefono != null)
				return false;
		} else if (!telefono.equals(other.telefono))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Contacto [id_contacto=" + id_contacto + ", campoJuego="
				+ campoJuego + ", nombre=" + nombre + ", telefono=" + telefono
				+ ", email=" + email + "]";
	}
	
}
