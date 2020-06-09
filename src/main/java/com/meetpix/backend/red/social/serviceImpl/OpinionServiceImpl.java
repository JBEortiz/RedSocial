package com.meetpix.backend.red.social.serviceImpl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.meetpix.backend.red.social.entity.Opinion;
import com.meetpix.backend.red.social.entity.Usuario;
import com.meetpix.backend.red.social.repository.OpinionRespository;
import com.meetpix.backend.red.social.repository.UsuarioRepository;
import com.meetpix.backend.red.social.service.OpinionService;

@Service
public class OpinionServiceImpl implements OpinionService {

	@Autowired
	private OpinionRespository opinionRepository;

	@Autowired
	private UsuarioRepository usuarioRepository;

	@Override
	@Transactional(readOnly = true)
	public Iterable<Opinion> findAllOpinion() {

		return opinionRepository.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<Opinion> finByIdOpinion(Long id) {
		return opinionRepository.findById(id);
	}

	@Override
	@Transactional
	public void deleteByIdOpinion(Long id) {
		opinionRepository.deleteById(id);
	}

	@Override
	@Transactional
	public Opinion saveOpinion(Opinion opinion) {
		return opinionRepository.save(opinion);
	}

	@Override
	public Opinion asociarOpinionPerfil(Long idUsuario, Long idOpinion) {
		Usuario usuario = usuarioRepository.findById(idUsuario).get();
		Opinion opinion = opinionRepository.findById(idOpinion).get();

		opinion.setUsuario(usuario);
		opinionRepository.save(opinion);
		return opinion;
	}

	@Override
	public Opinion deleteOpinionPerfil(Long idUsuario, Long idOpinion) {
		Usuario usuario = usuarioRepository.findById(idUsuario).get();
		Opinion opinion = opinionRepository.findById(idOpinion).get();

		opinion.setUsuario(usuario);
		opinionRepository.delete(opinion);
		return opinion;
	}

}
