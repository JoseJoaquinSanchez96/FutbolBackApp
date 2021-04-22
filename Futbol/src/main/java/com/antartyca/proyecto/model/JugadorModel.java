package com.antartyca.proyecto.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.*;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/*
 * Authors: Eduardo Fachal and Aitor Gonzalez
 * Date: 21/3/2021
 * 
 */

@Entity
@Component
@Table(name = "jugadores")
public class JugadorModel {
	
	@Id
	@Column(name="cod_jugador")
	@SequenceGenerator(sequenceName="jugadores_sequen" , name="jugador_seq")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="jugador_seq")
	@JsonProperty(value ="cod_jugador")
	private int cod_jugador;
	
	@Column
	@JsonProperty(value ="nombre")
	private String nombre;
	
	@Column
	@JsonProperty(value ="telefono")
	private String telefono;
	
	@Column
	@JsonProperty(value ="puesto")
	private String puesto;
	
	@Column
	@JsonProperty(value ="goles")
	private int goles;
	
	@Column
	@JsonProperty(value ="altura")
	private int altura;
	
	@Column
	@JsonProperty(value ="tarjetas")
	private int tarjetas;
	
	@Column
	@JsonProperty(value ="activo")
	private boolean activo = true;
	
	@ManyToOne//(cascade = CascadeType.ALL)
	@JoinColumn(name="cod_equipo")
	@JsonIgnoreProperties("jugadores")
	private EquipoModel equipo;
	
	public JugadorModel() {
		
	}
	
	public JugadorModel(String nom, String tlf, String puest, int gol, int alt, int tarj, boolean act, EquipoModel equi) {
		this.nombre = nom;
		this.telefono  = tlf;
		this.puesto = puest;
		this.equipo = equi;
		this.goles = gol;
		this.altura = alt;
		this.tarjetas = tarj;
		this.activo = act;
	}

	public boolean isActivo() {
		return activo;
	}

	public void setActivo(boolean activo) {
		this.activo = activo;
	}

	public Integer getCod_jugador() {
		return cod_jugador;
	}

	public void setCod_jugador(Integer cod_jugador) {
		this.cod_jugador = cod_jugador;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getPuesto() {
		return puesto;
	}

	public void setPuesto(String puesto) {
		this.puesto = puesto;
	}

	public EquipoModel getEquipo() {
		return equipo;
	}

	public void setEquipo(EquipoModel equipo) {
		this.equipo = equipo;
	}

	public int getGoles() {
		return goles;
	}

	public void setGoles(int goles) {
		this.goles = goles;
	}

	public int getAltura() {
		return altura;
	}

	public void setAltura(int altura) {
		this.altura = altura;
	}

	public int getTarjetas() {
		return tarjetas;
	}

	public void setTarjetas(int tarjetas) {
		this.tarjetas = tarjetas;
	}

	@Override
	public String toString() {
		return "JugadorModel [cod_jugador=" + cod_jugador + ", nombre=" + nombre + ", telefono=" + telefono
				+ ", puesto=" + puesto + ", goles=" + goles + ", altura=" + altura + ", tarjetas=" + tarjetas
				+ ", equipo=" + equipo + "]";
	}

	
}
