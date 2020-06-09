package com.meetpix.backend.red.social.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.meetpix.backend.red.social.dto.EventosUsuariosDto;
import com.meetpix.backend.red.social.entity.Evento;
import com.meetpix.backend.red.social.service.EventoService;

@RestController
@RequestMapping("/evento")
public class EventoController {
	@Autowired
	private EventoService eventoService;

	@GetMapping
	public ResponseEntity<?> getAllEvento() {
		return ResponseEntity.ok().body(eventoService.findAllEvento());
	}

	/**
	 * @GetMapping("/{id}") Este método sólo lo utilizaremos para las pruebas
	 * 
	 * @param id
	 * @return
	 */

	@GetMapping("/by/{id}")
	public ResponseEntity<?> getByIdEvento(@PathVariable Long id) {
		Optional<Evento> eventoId = eventoService.finByIdEvento(id);
		if (eventoId == null) {
			return ResponseEntity.notFound().build();
		}

		return ResponseEntity.ok(eventoId);
	}

	/**
	 * @GetMapping("/{id}") Este metodo sólo lo utilizaremos para cuando clickemos
	 * el evento no nos salga su id
	 * 
	 * @param idDto
	 * @return
	 */
	@PostMapping("/asistenEventos")
	public ResponseEntity<EventosUsuariosDto> findBancos(@RequestBody EventosUsuariosDto eventoUsuarioDto) {
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
	@PostMapping
	public ResponseEntity<?> createEvento(@RequestBody Evento evento) {
		Evento eventoCreado = eventoService.saveEvento(evento);
		return ResponseEntity.status(HttpStatus.CREATED).body(eventoCreado);
	}

	@PutMapping("/{id}")
	public ResponseEntity<?> updateEvento(@RequestBody Evento evento, @PathVariable Long id) {
		Optional<Evento> eventoId = eventoService.finByIdEvento(id);

		Evento eventoModificado = eventoId.get();
		eventoModificado.setNombre(evento.getNombre());
		eventoModificado.setDescripcion(evento.getDescripcion());
		eventoModificado.setDireccion(evento.getDireccion());
		return ResponseEntity.status(HttpStatus.CREATED).body(eventoService.saveEvento(eventoModificado));

	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteCategoria(@PathVariable Long id) {
		eventoService.deleteByIdEvento(id);
		return ResponseEntity.noContent().build();
	}
}
