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

import com.meetpix.backend.red.social.dto.UsuarioDto;
import com.meetpix.backend.red.social.entity.Usuario;
import com.meetpix.backend.red.social.service.UsuarioService;

@CrossOrigin(origins = { "http://localhost:4200" })
@RestController
@RequestMapping("/api/miperfil")
public class UsuarioController {
	@Autowired
	private UsuarioService usuarioService;

	// Método solo para pruebas

	@GetMapping
	public ResponseEntity<?> getAllUsuario() {
		return ResponseEntity.ok().body(usuarioService.findAllUsuario());
	}

	@GetMapping("/miperfil/ordernombre")
	public ResponseEntity<?> getAllUsuarioNombre() {
		ModelMapper modelMapper = new ModelMapper();
		List<Usuario> usuarioNombre = usuarioService.findAllOrderByNombre();
		List<UsuarioDto> usuarioDto = new ArrayList<UsuarioDto>();
		for (Usuario usuario : usuarioNombre) {
			usuarioDto.add(modelMapper.map(usuario, UsuarioDto.class));
		}
		return new ResponseEntity<>(usuarioDto, HttpStatus.OK);
	}

	@GetMapping("/miperfil/orderedad")
	public ResponseEntity<?> getAllUsuarioEdad() {
		return ResponseEntity.ok().body(usuarioService.findAllOrderByEdad());
	}

	@GetMapping("/{id}")
	public ResponseEntity<?> getByIdUsuario(@PathVariable Long id) {
		Optional<Usuario> usuarioId = usuarioService.finByIdUsuario(id);
		if (usuarioId == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(usuarioId);
	}

	@GetMapping("/miperfil/n/{nombre}")
	public ResponseEntity<?> getByNombreUsuario(@PathVariable String nombre) {
		ModelMapper modelMapper = new ModelMapper();
		Usuario usuario = usuarioService.findUserNombre(nombre);
		UsuarioDto usuarioDto = new UsuarioDto();
		usuarioDto = modelMapper.map(usuario, UsuarioDto.class);

		return new ResponseEntity<>(usuarioDto, HttpStatus.OK);
	}

	/**
	 * @GetMapping("/redcontactos") Este método sustituye al getAll convencional que
	 * solo utilizaremos para pruebas
	 * 
	 * @param idDto
	 * @return
	 */
	@GetMapping("/redcontactos")
	public ResponseEntity<?> findAllUsuarios() {
		ModelMapper modelMapper = new ModelMapper();
		List<Usuario> usuarioId = (List<Usuario>) usuarioService.findAllUsuario();
		List<UsuarioDto> usuarioDto = new ArrayList<UsuarioDto>();
		for (Usuario usuario : usuarioId) {
			usuarioDto.add(modelMapper.map(usuario, UsuarioDto.class));
		}
		return new ResponseEntity<>(usuarioDto, HttpStatus.OK);
	}

	/*
	 * @PostMapping Loging donde nos crearemos un usuario
	 */
	@PostMapping("/home")
	public ResponseEntity<Usuario> createUsuario(@RequestBody Usuario usuario) {
		Usuario usuarioCreado = usuarioService.saveUsuario(usuario);
		return ResponseEntity.status(HttpStatus.CREATED).body(usuarioCreado);
	}

	/*
	 * @PutMapping donde podemos cambiar los datos en nuestro perfil
	 */
	@PutMapping("/miperfil/{id}")
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
	@DeleteMapping("/miperfil/{id}")
	public ResponseEntity<?> deleteUsuario(@PathVariable Long id) {
		usuarioService.deleteByIdUsuario(id);
		return ResponseEntity.noContent().build();
	}
}
