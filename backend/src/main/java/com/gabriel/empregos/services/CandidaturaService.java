package com.gabriel.empregos.services;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gabriel.empregos.entities.Candidato;
import com.gabriel.empregos.entities.Candidatura;
import com.gabriel.empregos.entities.Vaga;
import com.gabriel.empregos.enums.CandidaturaStatus;
import com.gabriel.empregos.repositories.CandidaturaRepository;
import com.gabriel.empregos.services.exceptions.DataIntegrityViolationException;
import com.gabriel.empregos.services.exceptions.ObjectNotFoundException;

@Service
public class CandidaturaService {
	
	@Autowired
	private CandidaturaRepository repository;

	@Autowired
	private CandidatoService candidatoService;
	
	@Autowired
	private VagaService vagaService;
	
	public Candidatura salvarCandidatura(Integer idCandidato, Integer idVaga) {
		try {
			Candidato candidato = this.candidatoService.findById(Integer.toUnsignedLong(idCandidato));
			Vaga vaga = this.vagaService.findById(Integer.toUnsignedLong(idVaga));
			Candidatura obj = new Candidatura(null, candidato, vaga, new Date(), CandidaturaStatus.RECEBIDO);
			return repository.save(obj);
		} catch(org.springframework.dao.DataIntegrityViolationException e) {
			throw new DataIntegrityViolationException("Erro ao inserir a candidatura " + e.getMessage());
		}
	}
	
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
	
	public List<Candidatura> findAllByVaga(Integer idVaga) {
		return repository.findAllByCandidato(idVaga);
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
