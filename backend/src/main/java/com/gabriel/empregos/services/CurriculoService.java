package com.gabriel.empregos.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gabriel.empregos.entities.Candidato;
import com.gabriel.empregos.entities.Curriculo;
import com.gabriel.empregos.entities.CurriculoExperiencia;
import com.gabriel.empregos.entities.CurriculoFormacao;
import com.gabriel.empregos.repositories.CurriculoExperienciaRepository;
import com.gabriel.empregos.repositories.CurriculoFormacaoRepository;
import com.gabriel.empregos.repositories.CurriculoRepository;
import com.gabriel.empregos.services.exceptions.DataIntegrityViolationException;
import com.gabriel.empregos.services.exceptions.ObjectNotFoundException;

@Service
public class CurriculoService {
	
	@Autowired
	private CurriculoRepository repository;
	
	@Autowired
	private CurriculoFormacaoRepository formacoesRepository;
	
	@Autowired 
	private CurriculoExperienciaRepository experienciasRepository;
	
	public Curriculo findById(Long id) {
		Optional<Curriculo> obj = this.repository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado! Id: " + id + ", Tipo: " + Candidato.class.getName())); //caso nao encontre retorna null
	}
	
	@Transactional(readOnly = true)
	public List<Curriculo> findAll() {
		return repository.findAll();
	}
	
	public Curriculo findByCandidato(Integer idCandidato) {
		return repository.findByCandidato(idCandidato);
	}
	
	public Curriculo create(Curriculo obj) {
		obj.setId(repository.getMaxId() + 1);
		try {
			Curriculo objSaved = repository.save(obj);
			this.salvarFormacoes(objSaved, obj.getFormacoes());
			this.salvarExperiencias(objSaved, obj.getExperiencias());
			return objSaved;
		} catch (org.springframework.dao.DataIntegrityViolationException e) {
			throw new DataIntegrityViolationException("Erro ao inserir curriculo " + e.getMessage());
		}		
	}
	
	public Curriculo update(Long id, Curriculo obj) {
		Curriculo newObj = this.findById(id);
		this.updateData(newObj, obj);
		return repository.save(newObj);
	}
	
	private void updateData(Curriculo newObj, Curriculo obj) {
		newObj.setNome(obj.getNome());
		newObj.setResumo(obj.getResumo());
		newObj.setTelefone(obj.getTelefone());
		newObj.setTelefoneCelular(obj.getTelefoneCelular());
		newObj.setDataNascimento(obj.getDataNascimento());
		newObj.setEstadoCivil(obj.getEstadoCivil());
		newObj.setSexo(obj.getSexo());
		newObj.setCep(obj.getCep());
		newObj.setEstado(obj.getEstado());
		newObj.setCidade(obj.getCidade());
		newObj.setBairro(obj.getBairro());
		newObj.setRua(obj.getRua());
		newObj.setNumero(obj.getNumero());
		newObj.setComplemento(obj.getComplemento());
		newObj.setPessoaComDeficiencia(obj.getPessoaComDeficiencia());
		newObj.setLinkedin(obj.getLinkedin());
		newObj.setFacebook(obj.getFacebook());
		newObj.setInstagram(obj.getInstagram());
		newObj.setSite(obj.getSite());
		
		newObj.setFormacoes(obj.getFormacoes());
		newObj.setExperiencias(obj.getExperiencias());

		this.salvarFormacoes(newObj, newObj.getFormacoes());
		this.salvarExperiencias(newObj, newObj.getExperiencias());
	}
	
	private void salvarFormacoes(Curriculo obj, List<CurriculoFormacao> formacoes) {
		for (CurriculoFormacao formacao : formacoes) {
			formacao.setId(null);
			formacao.setCurriculo(obj);
		}
		try {
			this.formacoesRepository.deleteAllByCurriculo(obj.getId());
			this.formacoesRepository.saveAll(formacoes);
		} catch (org.springframework.dao.DataIntegrityViolationException e) {
			throw new DataIntegrityViolationException(e.getMessage());
		}
	}
	
	private void salvarExperiencias(Curriculo obj, List<CurriculoExperiencia> experiencias) {
		for (CurriculoExperiencia experiencia : experiencias) {
			experiencia.setId(null);
			experiencia.setCurriculo(obj);
		}
		try {
			this.experienciasRepository.deleteAllByCurriculo(obj.getId());
			this.experienciasRepository.saveAll(experiencias);
		} catch (org.springframework.dao.DataIntegrityViolationException e) {
			throw new DataIntegrityViolationException(e.getMessage());
		}
	}
	
}
