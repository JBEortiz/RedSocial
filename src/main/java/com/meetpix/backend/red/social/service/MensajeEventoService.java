package com.meetpix.backend.red.social.service;

import java.util.Optional;

import com.meetpix.backend.red.social.entity.MensajeEvento;

public interface MensajeEventoService {

	Iterable<MensajeEvento> findAllMensajeEvento();

	Optional<MensajeEvento> finByIdMensajeEvento(Long id);

	MensajeEvento saveMensajeEvento(MensajeEvento mensajeEvento);

	void deleteByIdMensajeEvento(Long id);
}
