package com.meetpix.backend.red.social.serviceImpl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.meetpix.backend.red.social.dto.EventosUsuariosDto;
import com.meetpix.backend.red.social.entity.Evento;
import com.meetpix.backend.red.social.entity.Usuario;
import com.meetpix.backend.red.social.repository.EventoRepository;
import com.meetpix.backend.red.social.repository.UsuarioRepository;
import com.meetpix.backend.red.social.service.EventoService;

@Service
public class EventoServiceImpl implements EventoService {

	@Autowired
	private EventoRepository eventoRepository;
	@Autowired
	private UsuarioRepository usuarioRepository;

	@Override
	@Transactional(readOnly = true)
	public Iterable<Evento> findAllEvento() {
		return eventoRepository.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<Evento> finByIdEvento(Long id) {
		return eventoRepository.findById(id);
	}

	@Override
	@Transactional
	public Evento saveEvento(Evento evento) {
		return eventoRepository.save(evento);
	}

	@Override
	@Transactional
	public void deleteByIdEvento(Long id) {
		eventoRepository.deleteById(id);
	}

	@Override
	public void asociarEventosUsusarios(EventosUsuariosDto eventoUserDto) {
		Evento evento = eventoRepository.findEventoByIdentificador(eventoUserDto.getIdentificador());
		Usuario usuario = usuarioRepository.findUser(eventoUserDto.getNombreUsuario(),
				eventoUserDto.getApellidoUsuario(), eventoUserDto.getCiudadUsuario());
		evento.getUsuarios().add(usuario);
		usuario.getEventos().add(evento);
		eventoRepository.save(evento);
		usuarioRepository.save(usuario);

	}
}
