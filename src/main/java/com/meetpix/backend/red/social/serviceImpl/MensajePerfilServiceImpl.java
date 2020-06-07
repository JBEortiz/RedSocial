package com.meetpix.backend.red.social.serviceImpl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.meetpix.backend.red.social.entity.MensajePerfil;
import com.meetpix.backend.red.social.repository.MensajePerfilRepository;
import com.meetpix.backend.red.social.service.MensajePerfilService;

@Service
public class MensajePerfilServiceImpl implements MensajePerfilService {

	@Autowired
	private MensajePerfilRepository mensajepPerfilRepository;

	@Override
	@Transactional(readOnly = true)
	public Iterable<MensajePerfil> findAllMensajePerfil() {
		return mensajepPerfilRepository.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<MensajePerfil> finByIdMensajePerfil(Long id) {
		return mensajepPerfilRepository.findById(id);
	}

	@Override
	@Transactional
	public MensajePerfil saveMensajePerfil(MensajePerfil mensajePerfil) {
		return mensajepPerfilRepository.save(mensajePerfil);
	}

	@Override
	@Transactional
	public void deleteByIdMensajePerfil(Long id) {
		mensajepPerfilRepository.deleteById(id);
	}

}
