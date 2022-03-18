package com.gabriel.empregos.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gabriel.empregos.entities.Cargo;
import com.gabriel.empregos.repositories.CargoRepository;

@Service
public class CargoService {
	
	@Autowired
	private CargoRepository repository;
	
	@Transactional(readOnly = true)
	public List<Cargo> findAll() {
		return repository.findAll();
	}
	
}
