package com.gabriel.empregos.services;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gabriel.empregos.entities.Candidato;
import com.gabriel.empregos.enums.TipoUsuario;
import com.gabriel.empregos.repositories.CandidatoRepository;
import com.gabriel.empregos.services.exceptions.DataIntegrityViolationException;
import com.gabriel.empregos.services.exceptions.ObjectNotFoundException;
import com.gabriel.empregos.util.Util;

@Service
public class CandidatoService {
	
	@Autowired
	private CandidatoRepository repository;
	
	public Candidato findById(Long id) {
		Optional<Candidato> obj = this.repository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado! Id: " + id + ", Tipo: " + Candidato.class.getName())); //caso nao encontre retorna null
	}
	
	@Transactional(readOnly = true)
	public List<Candidato> findAll() {
		return repository.findAll();
	}
	
	public Candidato create(Candidato obj) {
		obj.setId(null);
		obj.setSenha(Util.criptografar(obj.getSenha()));
		obj.setDataCadastro(new Date(System.currentTimeMillis()));
		obj.setTipoUsuario(TipoUsuario.CANDIDATO);
		try {
			return repository.save(obj);
		} catch (org.springframework.dao.DataIntegrityViolationException e) {
			throw new DataIntegrityViolationException("E-mail já cadastrado!");
		}
	}
	
}
