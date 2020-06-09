package com.meetpix.backend.red.social.service;

import java.util.Optional;

import com.meetpix.backend.red.social.entity.MensajeEvento;

public interface MensajeEventoService {

	Iterable<MensajeEvento> findAllMensajeEvento();

	Optional<MensajeEvento> finByIdMensajeEvento(Long id);

	void deleteByIdMensajeEvento(Long id);

	MensajeEvento saveMensajeEvento(MensajeEvento mensajeEvento);

	MensajeEvento asociarMensajeEvento(Long idEvento, Long idMensaje);

	MensajeEvento deleteMensajeEvento(Long idEvento, Long idMensaje);

}
