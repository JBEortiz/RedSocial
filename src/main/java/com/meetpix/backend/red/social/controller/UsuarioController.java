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

import com.meetpix.backend.red.social.dto.UsuarioDto;
import com.meetpix.backend.red.social.entity.Usuario;
import com.meetpix.backend.red.social.service.UsuarioService;

@RestController
@RequestMapping("/miperfil")
public class UsuarioController {
	@Autowired
	private UsuarioService usuarioService;

	@GetMapping
	public ResponseEntity<?> getAllUsuario() {
		return ResponseEntity.ok().body(usuarioService.findAllUsuario());
	}

	@GetMapping("/by/{id}")
	public ResponseEntity<?> getByIdUsuario(@PathVariable Long id) {
		Optional<Usuario> usuarioId = usuarioService.finByIdUsuario(id);
		if (usuarioId == null) {
			return ResponseEntity.notFound().build();
		}

		return ResponseEntity.ok(usuarioId);
	}

	/**
	 * @GetMapping("/{id}") Este método sólo lo utilizaremos para cuando clickemos
	 * el evento no nos salga su id
	 * 
	 * @param idDto
	 * @return
	 */
	@GetMapping("/{idDto}")
	public ResponseEntity<UsuarioDto> findBancos(@PathVariable Long idDto) {
		Optional<Usuario> usuarioId = usuarioService.finByIdUsuario(idDto);
		UsuarioDto usuarioDto = new UsuarioDto(usuarioId.get());
		if (usuarioDto == null || idDto <= 0 || idDto == null) {
			return new ResponseEntity<UsuarioDto>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<UsuarioDto>(usuarioDto, HttpStatus.OK);
	}

	/*
	 * @PostMapping Loging donde nos crearemos un usuario
	 */
	@PostMapping
	public ResponseEntity<Usuario> createUsuario(@RequestBody Usuario usuario) {
		Usuario usuarioCreado = usuarioService.saveUsuario(usuario);
		return ResponseEntity.status(HttpStatus.CREATED).body(usuarioCreado);
	}

	/*
	 * @PutMapping donde podemos cambiar los datos en nuestro perfil
	 */
	@PutMapping("/{id}")
	public ResponseEntity<Usuario> updateUsuario(@RequestBody Usuario usuario, @PathVariable Long id) {
		Optional<Usuario> usuarioId = usuarioService.finByIdUsuario(id);
		if (usuarioId == null) {
			return ResponseEntity.notFound().build();
		}
		Usuario userModificado = usuarioId.get();
		userModificado.setCiudad(usuario.getCiudad());
		userModificado.setDescripcion(usuario.getDescripcion());
		userModificado.setTrabajo(usuario.getTrabajo());
		return ResponseEntity.status(HttpStatus.CREATED).body(usuarioService.saveUsuario(userModificado));
	}

	/*
	 * @DeleteMapping Este método no le daremos mucho uso y no lo dejaremos visible
	 */
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteUsuario(@PathVariable Long id) {
		usuarioService.deleteByIdUsuario(id);
		return ResponseEntity.noContent().build();
	}
}
