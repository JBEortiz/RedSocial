package com.meetpix.backend.red.social.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.meetpix.backend.red.social.entity.MensajeEvento;
import com.meetpix.backend.red.social.service.MensajeEventoService;

@CrossOrigin(origins = { "http://localhost:4200" })
@RestController
@RequestMapping("/api/evento")
public class MensajeEventoController {
	@Autowired
	private MensajeEventoService mensajeEventoService;

	/**
	 * @GetMapping Este método se encarga de mostrar todas los mensajes de los
	 *             usuarios
	 * @return
	 */
	@GetMapping("/mensajeEvent")
	public ResponseEntity<?> getAllMensajeEvento() {
		return ResponseEntity.ok().body(mensajeEventoService.findAllMensajeEvento());
	}

	/**
	 * @PostMapping Creamos el post de mensaje del evento que luego asociaremos a un
	 *              evento , tendremos un método que asocie un mensaje a un evento
	 * @param mensajeEvento
	 * @return
	 */
//	
	@PostMapping("/mensajeEvent")
	public ResponseEntity<?> createMensajeEvento(@RequestBody MensajeEvento mensajeEvento) {
		MensajeEvento mensajeEventoCreado = mensajeEventoService.saveMensajeEvento(mensajeEvento);
		return ResponseEntity.status(HttpStatus.CREATED).body(mensajeEventoCreado);
	}

	@PutMapping("/asociarMensajeEvento/{idEvento}/{idMensaje}")
	public ResponseEntity<MensajeEvento> addMensaje(@PathVariable Long idEvento, @PathVariable Long idMensaje) {
		MensajeEvento mensajeEvento = mensajeEventoService.asociarMensajeEvento(idEvento, idMensaje);
		if (idEvento <= 0 || idEvento == null || idMensaje <= 0 || idMensaje == null) {
			return new ResponseEntity<MensajeEvento>(HttpStatus.NO_CONTENT);

		}
		return ResponseEntity.status(HttpStatus.CREATED).body(mensajeEvento);
	}

	@PutMapping("/deleteMensajeEvento/{idEvento}/{idMensaje}")
	public ResponseEntity<MensajeEvento> deleteMensaje(@PathVariable Long idEvento, @PathVariable Long idMensaje) {
		MensajeEvento mensajeEventoDelete = mensajeEventoService.deleteMensajeEvento(idEvento, idMensaje);
		mensajeEventoService.deleteByIdMensajeEvento(idMensaje);

		if (idEvento <= 0 || idEvento == null || idMensaje <= 0 || idMensaje == null) {
			return new ResponseEntity<MensajeEvento>(HttpStatus.NO_CONTENT);

		}
		return ResponseEntity.status(HttpStatus.CREATED).body(mensajeEventoDelete);
	}

}
