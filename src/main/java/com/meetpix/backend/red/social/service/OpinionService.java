package com.meetpix.backend.red.social.service;

import java.util.Optional;

import com.meetpix.backend.red.social.entity.Opinion;

public interface OpinionService {

	Iterable<Opinion> findAllOpinion();

	Optional<Opinion> finByIdOpinion(Long id);

	Opinion saveOpinion(Opinion opinion);

	void deleteByIdOpinion(Long id);
}
