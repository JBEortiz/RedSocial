package com.meetpix.backend.red.social.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.meetpix.backend.red.social.entity.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

	@Query("SELECT u FROM Usuario u WHERE u.nombre = ?1 and u.apellido = ?2 and u.ciudad = ?3")
	Usuario findUser(String nombre, String apellido, String ciudad);

	@Query("SELECT u FROM Usuario u ORDER BY u.nombre")
	List<Usuario> findAllOrderByNombre();

	@Query("SELECT u FROM Usuario u ORDER BY u.edad")
	List<Usuario> findAllOrderByEdad();

	@Query("SELECT u FROM Usuario u WHERE u.nombre = ?1")
	Usuario findUserNombre(String nombre);
}
