package com.meetpix.backend.red.social.serviceImpl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.meetpix.backend.red.social.entity.EventosTienenUsuario;
import com.meetpix.backend.red.social.service.EventosTieneUsuarioService;

@Service
public class EventosTienenUsuarioServiceImpl implements EventosTieneUsuarioService {

	@Autowired

	@Override
	public Iterable<EventosTienenUsuario> findAllEventosTieneUsuario() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<EventosTienenUsuario> finByIdEventosTieneUsuario(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public EventosTienenUsuario saveEventosTieneUsuario(EventosTienenUsuario EventosTienenUsuario) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteByIdEventosTieneUsuario(Long id) {
		// TODO Auto-generated method stub

	}

}
