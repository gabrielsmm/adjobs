package com.gabriel.empregos.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gabriel.empregos.entities.Empresa;
import com.gabriel.empregos.repositories.EmpresaRepository;
import com.gabriel.empregos.services.exceptions.DataIntegrityViolationException;
import com.gabriel.empregos.util.Util;

@Service
public class EmpresaService {
	
	@Autowired
	private EmpresaRepository repository;
	
	@Transactional(readOnly = true)
	public List<Empresa> findAll() {
		return repository.findAll();
	}
	
	public Empresa create(Empresa obj) {
		obj.setId(null);
		obj.setSenha(Util.criptografar(obj.getSenha()));
		try {
			return repository.save(obj);
		} catch (org.springframework.dao.DataIntegrityViolationException e) {
			throw new DataIntegrityViolationException("Nome de usuário ou e-mail já cadastrados!");
		}
	}
	
}
