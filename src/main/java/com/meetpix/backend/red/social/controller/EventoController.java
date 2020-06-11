package com.meetpix.backend.red.social.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.meetpix.backend.red.social.dto.EventoDto;
import com.meetpix.backend.red.social.dto.EventosUsuariosDto;
import com.meetpix.backend.red.social.entity.Evento;
import com.meetpix.backend.red.social.service.EventoService;

@CrossOrigin(origins = { "http://localhost:4200" })
@RestController
@RequestMapping("/api/eventos")
public class EventoController {
	@Autowired
	private EventoService eventoService;

	/*
	 * Este método sólo lo utilizaremos para las pruebas
	 */
	@GetMapping
	public ResponseEntity<?> getAllEvento() {
		return ResponseEntity.ok().body(eventoService.findAllEvento());
	}

	/**
	 * @GetMapping("/eventos") Este método sólo lo para el findAllEventos
	 * 
	 * @param id
	 * @return
	 */

	@GetMapping("/eventos")
	public ResponseEntity<?> findAllEventos() {
		ModelMapper modelMapper = new ModelMapper();
		List<Evento> eventosAll = (List<Evento>) eventoService.findAllEvento();
		List<EventoDto> eventoDto = new ArrayList<EventoDto>();
		for (Evento evento : eventosAll) {
			eventoDto.add(modelMapper.map(evento, EventoDto.class));
		}
		return new ResponseEntity<>(eventoDto, HttpStatus.OK);
	}

	@GetMapping("/eventos/{id}")
	public ResponseEntity<?> getByIdEvento(@PathVariable Long id) {
		Optional<Evento> eventoId = eventoService.finByIdEvento(id);
		if (eventoId == null) {
			return ResponseEntity.notFound().build();
		}

		return ResponseEntity.ok(eventoId);
	}

	/**
	 * @PostMapping("/asistenEventos") Este método lo utilizaremos para cuando
	 * queramos apuntar un usuario a un evento
	 * 
	 * @return
	 */
	@PostMapping("/asistenEventos")
	public ResponseEntity<EventosUsuariosDto> assitenEventos(@RequestBody EventosUsuariosDto eventoUsuarioDto) {
		try {
			eventoService.asociarEventosUsusarios(eventoUsuarioDto);
			return new ResponseEntity<EventosUsuariosDto>(HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<EventosUsuariosDto>(HttpStatus.NO_CONTENT);
		}
	}

	/**
	 * @PostMapping dentro de la página evento tendremos un pequeño formulario para
	 *              poder crear eventos
	 * @param evento
	 * @return
	 */
	@PostMapping("/eventos/create")
	public ResponseEntity<?> createEvento(@RequestBody Evento evento) {
		Evento eventoCreado = eventoService.saveEvento(evento);
		return ResponseEntity.status(HttpStatus.CREATED).body(eventoCreado);
	}

	/*
	 * @PutMapping("/{id}") método para modifciar evento por id
	 */
	@PutMapping("/eventos/{id}")
	public ResponseEntity<?> updateEvento(@RequestBody Evento evento, @PathVariable Long id) {
		Optional<Evento> eventoId = eventoService.finByIdEvento(id);

		Evento eventoModificado = eventoId.get();
		eventoModificado.setNombre(evento.getNombre());
		eventoModificado.setDescripcion(evento.getDescripcion());
		eventoModificado.setDireccion(evento.getDireccion());
		return ResponseEntity.status(HttpStatus.CREATED).body(eventoService.saveEvento(eventoModificado));

	}

	/*
	 * @DeleteMapping("/{id}") borrar por id podemos hacer este metodo para borrar
	 * en la vista getAll o dentro del evento con getById
	 */
	@DeleteMapping("/eventos/{id}")
	public ResponseEntity<?> deleteCategoria(@PathVariable Long id) {
		eventoService.deleteByIdEvento(id);
		return ResponseEntity.noContent().build();
	}
}
