package com.meetpix.backend.red.social.dto;

import com.meetpix.backend.red.social.entity.MensajePerfil;
import com.meetpix.backend.red.social.entity.Usuario;

public class MensajePerfilDto {

	private Usuario usuario;
	private String cuerpo;

	public MensajePerfilDto(MensajePerfil mensajePerfil) {
		this.usuario = mensajePerfil.getUsuario();
		this.cuerpo = mensajePerfil.getCuerpo();
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public String getCuerpo() {
		return cuerpo;
	}

	public void setCuerpo(String cuerpo) {
		this.cuerpo = cuerpo;
	}

}
