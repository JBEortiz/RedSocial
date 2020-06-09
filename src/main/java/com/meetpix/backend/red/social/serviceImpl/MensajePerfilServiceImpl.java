package com.meetpix.backend.red.social.serviceImpl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.meetpix.backend.red.social.entity.MensajePerfil;
import com.meetpix.backend.red.social.entity.Usuario;
import com.meetpix.backend.red.social.repository.MensajePerfilRepository;
import com.meetpix.backend.red.social.repository.UsuarioRepository;
import com.meetpix.backend.red.social.service.MensajePerfilService;

@Service
public class MensajePerfilServiceImpl implements MensajePerfilService {

	@Autowired
	private MensajePerfilRepository mensajePerfilRepository;

	@Autowired
	private UsuarioRepository usuarioRepository;

	@Override
	@Transactional(readOnly = true)
	public Iterable<MensajePerfil> findAllMensajePerfil() {
		return mensajePerfilRepository.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<MensajePerfil> finByIdMensajePerfil(Long id) {
		return mensajePerfilRepository.findById(id);
	}

	@Override
	@Transactional
	public void deleteByIdMensajePerfil(Long id) {
		mensajePerfilRepository.deleteById(id);
	}

	@Override
	@Transactional
	public MensajePerfil saveMensajePerfil(MensajePerfil mensajePerfil) {
		return mensajePerfilRepository.save(mensajePerfil);
	}

	@Override
	public MensajePerfil asociarMensajePerfil(Long idUsuario, Long idMensaje) {
		Usuario usuario = usuarioRepository.findById(idUsuario).get();
		MensajePerfil mensajePerfil = mensajePerfilRepository.findById(idMensaje).get();

		usuario.getMensajes().add(mensajePerfil);
		usuarioRepository.save(usuario);
		return mensajePerfil;
	}

	@Override
	public MensajePerfil deleteMensajePerfil(Long idUsuario, Long idMensaje) {
		Usuario usuario = usuarioRepository.findById(idUsuario).get();
		MensajePerfil mensajePerfil = mensajePerfilRepository.findById(idMensaje).get();

		usuario.getMensajes().remove(mensajePerfil);
		usuarioRepository.save(usuario);
		return mensajePerfil;
	}

}
