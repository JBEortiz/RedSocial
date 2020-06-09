package com.meetpix.backend.red.social.dto;

/*
 * 
 */

public class EventosUsuariosDto {

	private String identificador;
	private String nombreUsuario;
	private String apellidoUsuario;
	private String ciudadUsuario;

	public String getIdentificador() {
		return identificador;
	}

	public void setIdentificador(String identificador) {
		this.identificador = identificador;
	}

	public String getNombreUsuario() {
		return nombreUsuario;
	}

	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}

	public String getApellidoUsuario() {
		return apellidoUsuario;
	}

	public void setApellidoUsuario(String apellidoUsuario) {
		this.apellidoUsuario = apellidoUsuario;
	}

	public String getCiudadUsuario() {
		return ciudadUsuario;
	}

	public void setCiudadUsuario(String ciudadUsuario) {
		this.ciudadUsuario = ciudadUsuario;
	}

}
