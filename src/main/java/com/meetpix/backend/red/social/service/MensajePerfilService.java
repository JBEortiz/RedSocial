package com.meetpix.backend.red.social.service;

import java.util.Optional;

import com.meetpix.backend.red.social.entity.MensajePerfil;

public interface MensajePerfilService {

	Iterable<MensajePerfil> findAllMensajePerfil();

	Optional<MensajePerfil> finByIdMensajePerfil(Long id);

	MensajePerfil saveMensajePerfil(MensajePerfil mensajePerfil);

	void deleteByIdMensajePerfil(Long id);

	MensajePerfil asociarMensajePerfil(Long idUsuario, Long idMensaje);

	MensajePerfil deleteMensajePerfil(Long idUsuario, Long idMensaje);

}
