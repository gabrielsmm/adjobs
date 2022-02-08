package com.gabriel.empregos.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gabriel.empregos.entities.Vaga;
import com.gabriel.empregos.repositories.VagaRepository;

@Service
public class VagaService {
	
	@Autowired
	private VagaRepository repository;
	
	@Transactional(readOnly = true)
	public Page<Vaga> findAll(Pageable pageable) {
		repository.findAll();
		Page<Vaga> result = repository.findAll(pageable);
		return result;
	}
	
}