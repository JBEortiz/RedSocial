package com.meetpix.backend.red.social.dto;

import com.meetpix.backend.red.social.entity.MensajeEvento;
import com.meetpix.backend.red.social.entity.Usuario;

public class MensajeEventoDto {

	private String cuerpo;
	private Usuario usuario;

	public MensajeEventoDto(MensajeEvento mensajeEvento) {
		super();
		this.cuerpo = mensajeEvento.getCuerpo();
		this.usuario = mensajeEvento.getUsuario();
	}

	public String getCuerpo() {
		return cuerpo;
	}

	public void setCuerpo(String cuerpo) {
		this.cuerpo = cuerpo;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

}
