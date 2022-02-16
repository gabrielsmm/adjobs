package com.gabriel.empregos.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gabriel.empregos.entities.Concurso;
import com.gabriel.empregos.repositories.ConcursoRepository;

@Service
public class ConcursoService {

	@Autowired
	private ConcursoRepository repository;
	
	@Transactional(readOnly = true)
	public List<Concurso> findAll() {
		return repository.findAll();
	}
	
}
