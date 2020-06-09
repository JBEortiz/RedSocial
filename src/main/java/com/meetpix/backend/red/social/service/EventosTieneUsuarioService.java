package com.meetpix.backend.red.social.service;

import java.util.Optional;

import com.meetpix.backend.red.social.entity.EventosTienenUsuario;

public interface EventosTieneUsuarioService {

	Iterable<EventosTienenUsuario> findAllEventosTieneUsuario();

	Optional<EventosTienenUsuario> finByIdEventosTieneUsuario(Long id);

	EventosTienenUsuario saveEventosTieneUsuario(EventosTienenUsuario eventosTienenUsuario);

	void deleteByIdEventosTieneUsuario(Long id);
}
