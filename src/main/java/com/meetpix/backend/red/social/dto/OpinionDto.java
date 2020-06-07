package com.meetpix.backend.red.social.dto;

import com.meetpix.backend.red.social.entity.Opinion;
import com.meetpix.backend.red.social.entity.Usuario;

public class OpinionDto {

	private String cuerpo;
	private Usuario usuario;

	public OpinionDto(Opinion opinion) {
		super();
		this.cuerpo = opinion.getCuerpo();
		this.usuario = opinion.getUsuario();
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
