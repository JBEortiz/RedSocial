package com.meetpix.backend.red.social.controller;

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

import com.meetpix.backend.red.social.entity.MensajePerfil;
import com.meetpix.backend.red.social.service.MensajePerfilService;

@CrossOrigin(origins = { "http://localhost:4200" })
@RestController
@RequestMapping("/api/miperfil")
public class MensajePerfilController {
	@Autowired
	private MensajePerfilService mensajePerfilService;

	@GetMapping("/mensajes")
	public ResponseEntity<?> getAllMensajeOpinion() {
		return ResponseEntity.ok().body(mensajePerfilService.findAllMensajePerfil());
	}

	/**
	 * @PostMapping Creamos el post del mensaje del perfil que luego asociaremos a
	 *              un usuario
	 * 
	 * @param MensajePerfil
	 * @return
	 */
	@PostMapping("/mensaje")
	public ResponseEntity<?> createMensajeOpinion(@RequestBody MensajePerfil mensajePerfil) {
		MensajePerfil mensajeCreado = mensajePerfilService.saveMensajePerfil(mensajePerfil);
		return ResponseEntity.status(HttpStatus.CREATED).body(mensajeCreado);
	}

	/**
	 * @DeleteMapping("/{id}") en caso de querer borrar una mensajes del perfil
	 * exacto, borraremos por id
	 * 
	 * @param id
	 * @return
	 */
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteMensajePerfil(@PathVariable Long id) {
		mensajePerfilService.deleteByIdMensajePerfil(id);
		return ResponseEntity.noContent().build();
	}

	@PutMapping("/mensajeCreate/{idUsuario}/{idMensaje}")
	public ResponseEntity<MensajePerfil> addMensaje(@PathVariable Long idUsuario, @PathVariable Long idMensaje) {
		MensajePerfil mensajePerfil = mensajePerfilService.asociarMensajePerfil(idUsuario, idMensaje);
		if (idUsuario <= 0 || idUsuario == null || idMensaje <= 0 || idMensaje == null) {
			return new ResponseEntity<MensajePerfil>(HttpStatus.NO_CONTENT);
		}
		return ResponseEntity.status(HttpStatus.CREATED).body(mensajePerfil);

	}

	@PutMapping("/mensajeDelete/{idUsuario}/{idMensaje}")
	public ResponseEntity<MensajePerfil> deleteMensaje(@PathVariable Long idUsuario, @PathVariable Long idMensaje) {
		MensajePerfil mensajePerfilDelete = mensajePerfilService.deleteMensajePerfil(idUsuario, idMensaje);
		mensajePerfilService.deleteByIdMensajePerfil(idMensaje);
		if (idUsuario <= 0 || idUsuario == null || idMensaje <= 0 || idMensaje == null) {
			return new ResponseEntity<MensajePerfil>(HttpStatus.NO_CONTENT);
		}
		return ResponseEntity.status(HttpStatus.CREATED).body(mensajePerfilDelete);

	}

}
