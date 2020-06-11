package com.meetpix.backend.red.social.serviceImpl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.meetpix.backend.red.social.entity.Evento;
import com.meetpix.backend.red.social.entity.MensajeEvento;
import com.meetpix.backend.red.social.repository.EventoRepository;
import com.meetpix.backend.red.social.repository.MensajeEventoReposirtory;
import com.meetpix.backend.red.social.service.MensajeEventoService;

@Service
public class MensajeEventoServiceImpl implements MensajeEventoService {

	@Autowired
	private MensajeEventoReposirtory mensajeEventoReposirtory;
	@Autowired
	private EventoRepository eventoRepository;

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
	public void deleteByIdMensajeEvento(Long id) {
		mensajeEventoReposirtory.deleteById(id);
	}

	@Override
	@Transactional
	public MensajeEvento saveMensajeEvento(MensajeEvento mensajeEvento) {
		return mensajeEventoReposirtory.save(mensajeEvento);
	}

	@Override
	@Transactional
	public MensajeEvento asociarMensajeEvento(Long idEvento, Long idMensaje) {
		Evento evento = eventoRepository.findById(idEvento).get();
		MensajeEvento mensajeEvento = mensajeEventoReposirtory.findById(idMensaje).get();
		if (evento.getMensajes().contains(mensajeEvento)) {
			eventoRepository.save(evento);
		} else {
			evento.getMensajes().add(mensajeEvento);
			eventoRepository.save(evento);
		}
		return mensajeEvento;
	}

	@Override
	@Transactional
	public MensajeEvento deleteMensajeEvento(Long idEvento, Long idMensaje) {
		Evento evento = eventoRepository.findById(idEvento).get();
		MensajeEvento mensajeEvento = mensajeEventoReposirtory.findById(idMensaje).get();
		if (evento.getMensajes().contains(mensajeEvento)) {
			eventoRepository.save(evento);
		} else {
			evento.getMensajes().remove(mensajeEvento);
			eventoRepository.save(evento);
		}
		return mensajeEvento;
	}

}
