package com.gabriel.empregos.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gabriel.empregos.entities.Candidato;
import com.gabriel.empregos.entities.Empresa;
import com.gabriel.empregos.repositories.CandidatoRepository;
import com.gabriel.empregos.services.exceptions.DataIntegrityViolationException;
import com.gabriel.empregos.util.Util;

@Service
public class CandidatoService {
	
	@Autowired
	private CandidatoRepository repository;
	
	@Transactional(readOnly = true)
	public List<Candidato> findAll() {
		return repository.findAll();
	}
	
	public Candidato create(Candidato obj) {
		obj.setId(null);
		obj.setSenha(Util.criptografar(obj.getSenha()));
		try {
			return repository.save(obj);
		} catch (org.springframework.dao.DataIntegrityViolationException e) {
			throw new DataIntegrityViolationException("Nome de usuário ou e-mail já cadastrados!");
		}
	}
	
}
