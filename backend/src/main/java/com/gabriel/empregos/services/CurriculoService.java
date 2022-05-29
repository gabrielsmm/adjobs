package com.gabriel.empregos.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gabriel.empregos.entities.Candidato;
import com.gabriel.empregos.entities.Curriculo;
import com.gabriel.empregos.repositories.CurriculoRepository;
import com.gabriel.empregos.services.exceptions.ObjectNotFoundException;

@Service
public class CurriculoService {
	
	@Autowired
	private CurriculoRepository repository;
	
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
	
}
