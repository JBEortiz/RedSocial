package com.meetpix.backend.red.social.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.meetpix.backend.red.social.entity.MensajeEvento;
import com.meetpix.backend.red.social.service.MensajeEventoService;

@RestController
@RequestMapping("/mensajevento")
public class MensajeEventoController {
	@Autowired
	private MensajeEventoService mensajeEventoService;

	/**
	 * @GetMapping Este metodo se encarga de motrar todas las opiniones de los
	 *             usuarios
	 * @return
	 */
	@GetMapping
	public ResponseEntity<?> getAllMensajeEvento() {
		return ResponseEntity.ok().body(mensajeEventoService.findAllMensajeEvento());
	}

	/**
	 * @PostMapping Creamos el post de mensaje del evento que luego asociaremos a un
	 *              evento
	 * 
	 * @param opinion
	 * @return
	 */
	@PostMapping
	public ResponseEntity<MensajeEvento> createMensajeEvento(@RequestBody MensajeEvento mensajeEvento) {
		MensajeEvento mensajeEventoCreado = mensajeEventoService.saveMensajeEvento(mensajeEvento);
		return ResponseEntity.status(HttpStatus.CREATED).body(mensajeEventoCreado);
	}

	/**
	 * @DeleteMapping("/{id}") en caso de querer borrar una opinion exacta
	 * borraremos por id
	 * 
	 * @param id
	 * @return
	 */
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteEvento(@PathVariable Long id) {
		mensajeEventoService.deleteByIdMensajeEvento(id);
		return ResponseEntity.noContent().build();
	}

}
