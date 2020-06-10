package com.meetpix.backend.red.social.service;

import java.util.Optional;

import com.meetpix.backend.red.social.entity.Usuario;

public interface UsuarioService {

	Iterable<Usuario> findAllUsuario();

	Optional<Usuario> finByIdUsuario(Long id);

	void deleteByIdUsuario(Long id);

	Usuario saveUsuario(Usuario usuario);

}
