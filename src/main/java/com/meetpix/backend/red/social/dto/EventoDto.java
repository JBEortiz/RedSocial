package com.meetpix.backend.red.social.dto;

import java.util.List;

import com.meetpix.backend.red.social.entity.Evento;
import com.meetpix.backend.red.social.entity.MensajeEvento;

/*
 * 
 */
public class EventoDto {

	private String nombre;
	private String descripcion;
	private String direccion;
	private List<MensajeEvento> mensajes;

	public EventoDto(Evento evento) {
		super();
		this.nombre = evento.getNombre();
		this.descripcion = evento.getDescripcion();
		this.direccion = evento.getDireccion();
		this.mensajes = evento.getMensajes();
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public List<MensajeEvento> getMensajes() {
		return mensajes;
	}

	public void setMensajes(List<MensajeEvento> mensajes) {
		this.mensajes = mensajes;
	}

}
