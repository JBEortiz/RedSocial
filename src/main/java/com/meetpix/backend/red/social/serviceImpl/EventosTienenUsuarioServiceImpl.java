package com.meetpix.backend.red.social.serviceImpl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.meetpix.backend.red.social.entity.EventosTienenUsuario;
import com.meetpix.backend.red.social.repository.EventosTienenUsuarioRepository;
import com.meetpix.backend.red.social.service.EventosTieneUsuarioService;

@Service
public class EventosTienenUsuarioServiceImpl implements EventosTieneUsuarioService {

	@Autowired
	private EventosTienenUsuarioRepository eventosTienenUsuarioRepository;

	@Override
	public Iterable<EventosTienenUsuario> findAllEventosTieneUsuario() {
		return eventosTienenUsuarioRepository.findAll();
	}

	@Override
	public Optional<EventosTienenUsuario> finByIdEventosTieneUsuario(Long id) {
		return eventosTienenUsuarioRepository.findById(id);
	}

	@Override
	public EventosTienenUsuario saveEventosTieneUsuario(EventosTienenUsuario eventosTienenUsuario) {
		return eventosTienenUsuarioRepository.save(eventosTienenUsuario);
	}

	@Override
	public void deleteByIdEventosTieneUsuario(Long id) {
		eventosTienenUsuarioRepository.deleteById(id);
	}

}
