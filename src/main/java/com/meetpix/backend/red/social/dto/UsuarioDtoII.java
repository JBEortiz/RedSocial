package com.meetpix.backend.red.social.dto;

import java.util.List;

import com.meetpix.backend.red.social.entity.Evento;
import com.meetpix.backend.red.social.entity.MensajePerfil;

public class UsuarioDtoII {
	
	private String nombre;
	private String apellido;
	private String ciudad;
	private String descripcion;
	private String trabajo;
	private int edad;
	private List<MensajePerfil> mensajes;
	private List<Evento> eventos;
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public String getCiudad() {
		return ciudad;
	}
	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public String getTrabajo() {
		return trabajo;
	}
	public void setTrabajo(String trabajo) {
		this.trabajo = trabajo;
	}
	public int getEdad() {
		return edad;
	}
	public void setEdad(int edad) {
		this.edad = edad;
	}
	public List<MensajePerfil> getMensajes() {
		return mensajes;
	}
	public void setMensajes(List<MensajePerfil> mensajes) {
		this.mensajes = mensajes;
	}
	public List<Evento> getEventos() {
		return eventos;
	}
	public void setEventos(List<Evento> eventos) {
		this.eventos = eventos;
	}
	

}
