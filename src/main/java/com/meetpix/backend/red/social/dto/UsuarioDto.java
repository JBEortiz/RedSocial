package com.meetpix.backend.red.social.dto;

import java.util.List;

import com.meetpix.backend.red.social.entity.MensajePerfil;
import com.meetpix.backend.red.social.entity.Usuario;

public class UsuarioDto {

	private String nombre;
	private String apellido;
	private String ciudad;
	private String descripcion;
	private String trabajo;
	private int edad;
	List<MensajePerfil> mensajes;

	public UsuarioDto(Usuario ususrio) {
		super();
		this.nombre = ususrio.getNombre();
		this.apellido = ususrio.getApellido();
		this.ciudad = ususrio.getCiudad();
		this.descripcion = ususrio.getDescripcion();
		this.trabajo = ususrio.getTrabajo();
		this.edad = ususrio.getEdad();
		this.mensajes = ususrio.getMensajes();
	}

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

}
