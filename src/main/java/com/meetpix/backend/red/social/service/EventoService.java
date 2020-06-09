package com.meetpix.backend.red.social.service;

import java.util.Optional;

import com.meetpix.backend.red.social.dto.EventosUsuariosDto;
import com.meetpix.backend.red.social.entity.Evento;

public interface EventoService {

	Iterable<Evento> findAllEvento();

	Optional<Evento> finByIdEvento(Long id);

	Evento saveEvento(Evento evento);

	void deleteByIdEvento(Long id);

	void asociarEventosUsusarios(EventosUsuariosDto eventoUserDto);

}
