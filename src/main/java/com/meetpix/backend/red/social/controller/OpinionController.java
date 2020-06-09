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

import com.meetpix.backend.red.social.entity.Opinion;
import com.meetpix.backend.red.social.service.OpinionService;

@RestController
@RequestMapping("/opinion")
public class OpinionController {
	@Autowired
	private OpinionService opinionService;

	/**
	 * @GetMapping Este método se encarga de motrar todas las opiniones de los
	 *             usuarios
	 * @return
	 */
	@GetMapping
	public ResponseEntity<?> getAllMensajeOpinion() {
		return ResponseEntity.ok().body(opinionService.findAllOpinion());
	}

	/**
	 * @PostMapping crearemos un método de asociar una opinion a un usuario
	 * @param opinion
	 * @return
	 */
	@PostMapping
	public ResponseEntity<?> createMensajeOpinion(@RequestBody Opinion opinion) {
		Opinion opinionCreada = opinionService.saveOpinion(opinion);
		return ResponseEntity.status(HttpStatus.CREATED).body(opinionCreada);
	}

	/**
	 * @DeleteMapping("/{id}") en caso de querer borrar una opinión exacta
	 * borraremos por id
	 * 
	 * @param id
	 * @return
	 */
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteMensajePerfil(@PathVariable Long id) {
		opinionService.deleteByIdOpinion(id);
		return ResponseEntity.noContent().build();
	}

}
