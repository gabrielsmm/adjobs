package com.gabriel.empregos.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gabriel.empregos.entities.Vaga;
import com.gabriel.empregos.repositories.VagaRepository;
import com.gabriel.empregos.services.exceptions.DataIntegrityViolationException;
import com.gabriel.empregos.services.exceptions.ObjectNotFoundException;

@Service
public class VagaService {
	
	@Autowired
	private VagaRepository repository;
	
	public Vaga findById(Long id) {
		Optional<Vaga> obj = this.repository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado! Id: " + id + ", Tipo: " + Vaga.class.getName())); //caso nao encontre retorna null
	}
	
	@Transactional(readOnly = true)
	public Page<Vaga> findAll(Pageable pageable) {
		Page<Vaga> result = repository.findAll(pageable);
		return result;
	}
	
	@Transactional(readOnly = true)
	public Page<Vaga> findAllByNome(String nome, Pageable pageable) {
		Page<Vaga> result = repository.findAllByNomeIgnoreCaseContaining(nome, pageable);
		return result;
	}
	
	@Transactional(readOnly = true)
	public List<Vaga> findAllByEmpresa(Integer idEmpresa) {
		return repository.findAllByEmpresa(idEmpresa);
	}
	
	@Transactional(readOnly = true)
	public List<Vaga> getSomenteVagasEstagio() {
		return repository.getSomenteVagasEstagio();
	}
	
	@Transactional(readOnly = true)
	public Vaga getDados(Long id) {
		return repository.getById(id);
	}
	
	@Transactional(readOnly = true)
	public Long buscaNumeroVagas() {
		return repository.buscaNumeroVagas();
	}
	
	@Transactional(readOnly = true)
	public Long buscaNumeroVagasCadastradasPorEmpresa(Integer idEmpresa) {
		return repository.buscaNumeroVagasCadastradasPorEmpresa(idEmpresa);
	}
	
	public Vaga create(Vaga obj) {
		try {
			return repository.save(obj);
		} catch (org.springframework.dao.DataIntegrityViolationException e) {
			throw new DataIntegrityViolationException("Erro ao inserir curriculo " + e.getMessage());
		}		
	}
	
	public Vaga update(Long id, Vaga obj) {
		Vaga newObj = this.findById(id);
		this.updateData(newObj, obj);
		return repository.save(newObj);
	}
	
	private void updateData(Vaga newObj, Vaga obj) {
		newObj.setNome(obj.getNome());
		newObj.setLocalizacao(obj.getLocalizacao());
		newObj.setQuantidade(obj.getQuantidade());
		newObj.setSalario(obj.getSalario());
		newObj.setTipo(obj.getTipo());
		newObj.setExpiracao(obj.getExpiracao());
		newObj.setEmpresa(obj.getEmpresa());
	}
	
}
