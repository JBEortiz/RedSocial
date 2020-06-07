package com.meetpix.backend.red.social.serviceImpl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.meetpix.backend.red.social.entity.MensajeEvento;
import com.meetpix.backend.red.social.repository.MensajeEventoReposirtory;
import com.meetpix.backend.red.social.service.MensajeEventoService;

@Service
public class MensajeEventoServiceImpl implements MensajeEventoService {

	@Autowired
	private MensajeEventoReposirtory mensajeEventoReposirtory;

	@Override
	@Transactional(readOnly = true)
	public Iterable<MensajeEvento> findAllMensajeEvento() {
		return mensajeEventoReposirtory.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<MensajeEvento> finByIdMensajeEvento(Long id) {
		return mensajeEventoReposirtory.findById(id);
	}

	@Override
	@Transactional
	public MensajeEvento saveMensajeEvento(MensajeEvento mensajeEvento) {
		return mensajeEventoReposirtory.save(mensajeEvento);
	}

	@Override
	@Transactional
	public void deleteByIdMensajeEvento(Long id) {
		mensajeEventoReposirtory.deleteById(id);
	}

}
