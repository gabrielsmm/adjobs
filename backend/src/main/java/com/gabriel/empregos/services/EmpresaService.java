package com.gabriel.empregos.services;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gabriel.empregos.dtos.EmpresaDTO;
import com.gabriel.empregos.entities.Empresa;
import com.gabriel.empregos.enums.TipoUsuario;
import com.gabriel.empregos.repositories.EmpresaRepository;
import com.gabriel.empregos.services.exceptions.DataIntegrityViolationException;
import com.gabriel.empregos.services.exceptions.ObjectNotFoundException;
import com.gabriel.empregos.util.Util;

@Service
public class EmpresaService {
	
	@Autowired
	private EmpresaRepository repository;
	
	public Empresa findById(Integer id) {
		Optional<Empresa> obj = this.repository.findById(Integer.toUnsignedLong(id));
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado! Id: " + id + ", Tipo: " + Empresa.class.getName())); //caso nao encontre retorna null
	}
	
	@Transactional(readOnly = true)
	public List<Empresa> findAll() {
		return repository.findAll();
	}
	
	public Empresa create(Empresa obj) {
		obj.setId(null);
		obj.setSenha(Util.criptografar(obj.getSenha()));
		obj.setDataCadastro(new Date(System.currentTimeMillis()));
		obj.setTipoUsuario(TipoUsuario.EMPRESA);
		try {
			return repository.save(obj);
		} catch (org.springframework.dao.DataIntegrityViolationException e) {
			throw new DataIntegrityViolationException("E-mail já cadastrado!");
		}
	}
	
	public Empresa update(Integer id, EmpresaDTO obj) {
		Empresa newObj = this.findById(id);
		this.updateData(newObj, obj);
		return repository.save(newObj);
	}
	
	private void updateData(Empresa newObj, EmpresaDTO obj) {
		newObj.setNome(obj.getNome());
		newObj.setCnpj(obj.getCnpj());
		newObj.setQtdFuncionarios(obj.getQtdFuncionarios());
		newObj.setCep(obj.getCep());
		newObj.setNomeResponsavel(obj.getNomeResponsavel());
		newObj.setTelefone(obj.getTelefone());
		newObj.setCelular(obj.getCelular());
		newObj.setDescricao(obj.getDescricao());
		newObj.setSeguimento(obj.getSeguimento());
//		newObj.setEmail(obj.getEmail());
//		newObj.setSenha(obj.getSenha());
//		newObj.setDataCadastro(obj.getDataCadastro());
//		newObj.setTipoUsuario(obj.getTipoUsuario());
	}
	
}
