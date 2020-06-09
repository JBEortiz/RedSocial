package com.meetpix.backend.red.social.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.meetpix.backend.red.social.entity.Evento;

public interface EventoRepository extends CrudRepository<Evento, Long> {
	@Query("SELECT u FROM Evento u WHERE u.identificador = ?1")
	Evento findEventoByIdentificador(String identificador);
}
