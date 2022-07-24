package com.gabriel.empregos.services;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gabriel.empregos.entities.Candidato;
import com.gabriel.empregos.entities.Candidatura;
import com.gabriel.empregos.entities.Vaga;
import com.gabriel.empregos.enums.CandidaturaStatus;
import com.gabriel.empregos.interfaces.ContadorAuxiliar;
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
	
	public Candidatura findById(Integer id) {
		Optional<Candidatura> obj = this.repository.findById(Integer.toUnsignedLong(id));
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado! Id: " + id + ", Tipo: " + Candidato.class.getName())); //caso nao encontre retorna null
	}
	
	@Transactional(readOnly = true)
	public List<Candidatura> findAll() {
		return repository.findAll();
	}
	
	public Page<Candidatura> findAllByCandidato(Integer idCandidato, Pageable pageable) {
		Page<Candidatura> result = repository.findAllByCandidato(idCandidato, pageable);
		return result;
	}
	
	public List<Candidatura> findAllByVaga(Integer idVaga) {
		return repository.findAllByVaga(idVaga);
	}
	
	public Candidatura create(Integer idCandidato, Integer idVaga) {
		try {
			if (repository.verificaExistenciaCandidatura(idCandidato, idVaga) != null) {
				throw new DataIntegrityViolationException("Candidato já possui candidatura para a vaga selecionada");
			}
			Candidato candidato = this.candidatoService.findById(Integer.toUnsignedLong(idCandidato));
			Vaga vaga = this.vagaService.findById(idVaga);
			Candidatura obj = new Candidatura(null, candidato, vaga, new Date(), CandidaturaStatus.RECEBIDO);
			return repository.save(obj);
		} catch(org.springframework.dao.DataIntegrityViolationException e) {
			throw new DataIntegrityViolationException("Erro ao inserir a candidatura " + e.getMessage());
		}
	}
	
	public Candidatura update(Integer id, Candidatura obj) {
		Candidatura newObj = this.findById(id);
		this.updateData(newObj, obj);
		return repository.save(newObj);
	}
	
	private void updateData(Candidatura newObj, Candidatura obj) {
		newObj.setCandidato(obj.getCandidato());
		newObj.setVaga(obj.getVaga());
		newObj.setStatus(obj.getStatus());
		newObj.setDataCandidatura(obj.getDataCandidatura());
	}
	
	@Transactional(readOnly = true)
	public Long buscaNumeroCandidaturas(Integer idCandidato) {
		return repository.buscaNumeroCandidaturas(idCandidato);
	}
	
	public void atualizarStatus(Integer id, Integer status) {
		Candidatura obj = this.findById(id);
		obj.setStatus(CandidaturaStatus.getById(status));
		repository.save(obj);	
	}
	
	@Transactional(readOnly = true)
	public ContadorAuxiliar getContador(Integer idCandidato) {
		return repository.getContador(idCandidato);
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
