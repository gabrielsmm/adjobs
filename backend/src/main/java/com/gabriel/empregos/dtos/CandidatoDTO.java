package com.gabriel.empregos.dtos;

import java.io.Serializable;

import com.gabriel.empregos.entities.Candidato;

public class CandidatoDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Long id;
	
	private String nome;
	private String cep;
	
	public CandidatoDTO() {
		
	}
	
	public CandidatoDTO(Candidato obj) {
		this.id = obj.getId();
		this.nome = obj.getNome();
		this.cep = obj.getCep();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

}
