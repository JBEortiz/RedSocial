package com.meetpix.backend.red.social.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "EVENTOS_TIENEN_USUARIO")
public class EventosTienenUsuario implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	/*
	 * TODO Una forma de controlar el ManyToMany n-m hacinedo una clase intermedia
	 */
	@JoinColumn(name = "id_usuario")
	@ManyToOne(fetch = FetchType.LAZY)
	private Usuario usuario;
	@JoinColumn(name = "id_evento")
	@ManyToOne(fetch = FetchType.LAZY)
	private Evento evento;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Evento getEvento() {
		return evento;
	}

	public void setEvento(Evento evento) {
		this.evento = evento;
	}

}
