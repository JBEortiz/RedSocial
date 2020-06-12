package com.meetpix.backend.red.social.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.meetpix.backend.red.social.entity.Usuario;
import com.meetpix.backend.red.social.repository.UsuarioRepository;
import com.meetpix.backend.red.social.service.UsuarioService;

@Service
public class UsuarioServiceImpl implements UsuarioService {

	@Autowired
	private UsuarioRepository usuarioRepository;

	@Override
	@Transactional(readOnly = true)
	public Iterable<Usuario> findAllUsuario() {
		return usuarioRepository.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<Usuario> finByIdUsuario(Long id) {
		return usuarioRepository.findById(id);
	}

	@Override
	@Transactional
	public Usuario saveUsuario(Usuario usuario) {
		return usuarioRepository.save(usuario);
	}

	@Override
	@Transactional
	public void deleteByIdUsuario(Long id) {
		usuarioRepository.deleteById(id);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Usuario> findAllOrderByNombre() {
		return usuarioRepository.findAllOrderByNombre();
	}

	@Override
	@Transactional(readOnly = true)
	public List<Usuario> findAllOrderByEdad() {
		return usuarioRepository.findAllOrderByEdad();
	}

	@Override
	@Transactional(readOnly = true)
	public Usuario findUserNombre(String nombre) {
		return usuarioRepository.findUserNombre(nombre);
	}

}
