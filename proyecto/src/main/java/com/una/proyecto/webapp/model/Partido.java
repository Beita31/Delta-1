package com.una.proyecto.webapp.model;

import java.sql.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonIgnore;


@XmlRootElement
@Entity
@Table(name = "partido")
public class Partido {
	private int numero_partido;
	private CampoJuego campoJuego;
	private Date fecha_hora;
	private Set<Equipo> equipos;
	private float por_pagar;
	
	public Partido() {
		// TODO Auto-generated constructor stub
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "partido_id", unique = true, nullable = false)
	public int getNumero_partido() {
		return numero_partido;
	}

	public void setNumero_partido(int numero_partido) {
		this.numero_partido = numero_partido;
	}

	@ManyToOne
	@JoinColumn(name = "campoJuego_id", nullable = false)
	@JsonIgnore
	public CampoJuego getCampoJuego() {
		return campoJuego;
	}

	public void setCampo_juego(CampoJuego campoJuego) {
		this.campoJuego = campoJuego;
	}

	@Column(name = "fecha_hora")
	public Date getFecha_hora() {
		return fecha_hora;
	}

	public void setFecha_hora(Date fecha_hora) {
		this.fecha_hora = fecha_hora;
	}

	@ManyToMany
	@JoinColumn(name = "equipo_id", nullable = false)
	@JsonIgnore
	public Set<Equipo> getEquipos() {
		return equipos;
	}

	public void setEquipo_retador(Set<Equipo> equipos) {
		this.equipos = equipos;
	}

	@Column(name = "por_pagar")
	public float getPor_pagar() {
		return por_pagar;
	}

	public void setPor_pagar(float por_pagar) {
		this.por_pagar = por_pagar;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((campoJuego == null) ? 0 : campoJuego.hashCode());
		result = prime * result + ((equipos == null) ? 0 : equipos.hashCode());
		result = prime * result
				+ ((fecha_hora == null) ? 0 : fecha_hora.hashCode());
		result = prime * result + numero_partido;
		result = prime * result + Float.floatToIntBits(por_pagar);
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
		Partido other = (Partido) obj;
		if (campoJuego == null) {
			if (other.campoJuego != null)
				return false;
		} else if (!campoJuego.equals(other.campoJuego))
			return false;
		if (equipos == null) {
			if (other.equipos != null)
				return false;
		} else if (!equipos.equals(other.equipos))
			return false;
		if (fecha_hora == null) {
			if (other.fecha_hora != null)
				return false;
		} else if (!fecha_hora.equals(other.fecha_hora))
			return false;
		if (numero_partido != other.numero_partido)
			return false;
		if (Float.floatToIntBits(por_pagar) != Float
				.floatToIntBits(other.por_pagar))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Partido [numero_partido=" + numero_partido + ", campoJuego="
				+ campoJuego + ", fecha_hora=" + fecha_hora + ", equipos="
				+ equipos + ", por_pagar=" + por_pagar + "]";
	}

}
