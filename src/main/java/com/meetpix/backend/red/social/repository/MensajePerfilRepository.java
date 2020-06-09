package com.meetpix.backend.red.social.repository;

import org.springframework.data.repository.CrudRepository;

import com.meetpix.backend.red.social.entity.MensajePerfil;

public interface MensajePerfilRepository extends CrudRepository<MensajePerfil, Long> {

//	@Query("SELECT u FROM Usuario u WHERE u.nombre=:nombre, u.apellido=:apellido")
//	public Usuario findByNameSurname(@Param("nombre") String nombre, @Param("apellido") String apellido);
}
