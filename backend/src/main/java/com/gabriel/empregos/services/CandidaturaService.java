package com.gabriel.empregos.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gabriel.empregos.entities.Candidato;
import com.gabriel.empregos.entities.Candidatura;
import com.gabriel.empregos.repositories.CandidaturaRepository;
import com.gabriel.empregos.services.exceptions.ObjectNotFoundException;

@Service
public class CandidaturaService {
	
	@Autowired
	private CandidaturaRepository repository;
	
	public Candidatura findById(Long id) {
		Optional<Candidatura> obj = this.repository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado! Id: " + id + ", Tipo: " + Candidato.class.getName())); //caso nao encontre retorna null
	}
	
	@Transactional(readOnly = true)
	public List<Candidatura> findAll() {
		return repository.findAll();
	}
	
	public List<Candidatura> findAllByCandidato(Integer idCandidato) {
		return repository.findAllByCandidato(idCandidato);
	}
	
	@Transactional(readOnly = true)
	public Long buscaNumeroCandidaturas(Integer idCandidato) {
		return repository.buscaNumeroCandidaturas(idCandidato);
	}
	
//	public Candidato create(Candidato obj) {
//		obj.setId(null);
//		obj.setSenha(Util.criptografar(obj.getSenha()));
//		obj.setDataCadastro(new Date(System.currentTimeMillis()));
//		obj.setTipoUsuario(TipoUsuario.CANDIDATO);
//		try {
//			return repository.save(obj);
//		} catch (org.springframework.dao.DataIntegrityViolationException e) {
//			throw new DataIntegrityViolationException("E-mail já cadastrado!");
//		}
//	}
	
}
