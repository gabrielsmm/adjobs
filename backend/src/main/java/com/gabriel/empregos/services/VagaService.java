package com.gabriel.empregos.services;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gabriel.empregos.entities.Vaga;
import com.gabriel.empregos.enums.VagaStatus;
import com.gabriel.empregos.interfaces.ContadorAuxiliar;
import com.gabriel.empregos.repositories.VagaRepository;
import com.gabriel.empregos.services.exceptions.DataIntegrityViolationException;
import com.gabriel.empregos.services.exceptions.ObjectNotFoundException;

@Service
public class VagaService {
	
	@Autowired
	private VagaRepository repository;
	
	public Vaga findById(Integer id) {
		Optional<Vaga> obj = this.repository.findById(Integer.toUnsignedLong(id));
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado! Id: " + id + ", Tipo: " + Vaga.class.getName())); //caso nao encontre retorna null
	}
	
	@Transactional(readOnly = true)
	public Page<Vaga> findAll(Pageable pageable) {
		Page<Vaga> result = repository.findAll(pageable);
		return result;
	}
	
	@Transactional(readOnly = true)
	public Page<Vaga> findAllByNome(String nome, Pageable pageable) {
		Page<Vaga> result = repository.findAllByNome(nome, pageable);
		return result;
	}
	
	@Transactional(readOnly = true)
	public Page<Vaga> findAllByTipo(Integer tipo, Pageable pageable) {
		Page<Vaga> result = repository.findAllByTipo(tipo, pageable);
		return result;
	}
	
	@Transactional(readOnly = true)
	public Page<Vaga> findAllByPalavraLocalizacao(String palavraChave, String localizacao, Pageable pageable) {
		Page<Vaga> result = repository.findAllByPalavraLocalizacao(palavraChave, localizacao, pageable);
		return result;
	}
	
	@Transactional(readOnly = true)
	public Page<Vaga> findAllByEmpresa(Integer idEmpresa, Pageable pageable) {
		Page<Vaga> result = repository.findAllByEmpresa(idEmpresa, pageable);
		return result;
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
			obj.setDataCadastro(new Date(System.currentTimeMillis()));
			obj.setStatus(VagaStatus.ATIVA);
			return repository.save(obj);
		} catch (org.springframework.dao.DataIntegrityViolationException e) {
			throw new DataIntegrityViolationException("Erro ao inserir vaga");
		}		
	}
	
	public Vaga update(Integer id, Vaga obj) {
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
		newObj.setDataCadastro(obj.getDataCadastro());
		newObj.setDataAlteracao(new Date(System.currentTimeMillis()));
		newObj.setDescricao(obj.getDescricao());
		newObj.setRequisitos(obj.getRequisitos());
		newObj.setBeneficios(obj.getBeneficios());
		newObj.setStatus(obj.getStatus());
		newObj.setEmpresa(obj.getEmpresa());
	}
	
	public void delete(Integer id) {
		Vaga obj = this.findById(id);
		if (!obj.getStatus().equals(VagaStatus.ATIVA)) {
			return;
		}
		obj.setStatus(VagaStatus.CANCELADA);
		repository.save(obj);	
	}
	
	public void reactivate(Integer id) {
		Vaga obj = this.findById(id);
		if (!obj.getStatus().equals(VagaStatus.CANCELADA)) {
			return;
		}
		obj.setStatus(VagaStatus.ATIVA);
		repository.save(obj);	
	}
	
	@Transactional(readOnly = true)
	public ContadorAuxiliar getContador(Integer idCandidato) {
		return repository.getContador(idCandidato);
	}
	
}
