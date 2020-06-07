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

import com.meetpix.backend.red.social.entity.MensajePerfil;
import com.meetpix.backend.red.social.service.MensajePerfilService;

@RestController
@RequestMapping("/mensajeperfil")
public class MensajePerfilController {
	@Autowired
	private MensajePerfilService mensajePerfilService;

	/**
	 * @GetMapping Este metodo se encarga de motrar todas las mensajes del perfil de
	 *             los usuarios
	 * @return
	 */
	@GetMapping
	public ResponseEntity<?> getAllMensajePerfil() {
		return ResponseEntity.ok().body(mensajePerfilService.findAllMensajePerfil());
	}

	/**
	 * @PostMapping Creamos el post de mensajes del perfil que luego asociaremos a
	 *              un usuario
	 * 
	 * @param MensajePerfil
	 * @return
	 */
	@PostMapping
	public ResponseEntity<MensajePerfil> createMensajePerfil(@RequestBody MensajePerfil mensajePerfil) {
		MensajePerfil mensajePerfilCreado = mensajePerfilService.saveMensajePerfil(mensajePerfil);
		return ResponseEntity.status(HttpStatus.CREATED).body(mensajePerfilCreado);
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

}
