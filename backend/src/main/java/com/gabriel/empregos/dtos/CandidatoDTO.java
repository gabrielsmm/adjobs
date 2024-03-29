package com.gabriel.empregos.dtos;

import java.io.Serializable;
import java.util.Date;

import com.gabriel.empregos.entities.Candidato;
import com.gabriel.empregos.enums.TipoUsuario;

public class CandidatoDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Long id;
	private String email;
	private Date dataCadastro;
	private TipoUsuario tipoUsuario;
	private String nome;
	private String cep;
	
	public CandidatoDTO() {
		
	}
	
	public CandidatoDTO(Candidato obj) {
		this.id = obj.getId();
		this.email = obj.getEmail();
		this.dataCadastro = obj.getDataCadastro();
		this.tipoUsuario = obj.getTipoUsuario();
		this.nome = obj.getNome();
		this.cep = obj.getCep();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(Date dataCadastro) {
		this.dataCadastro = dataCadastro;
	}

	public TipoUsuario getTipoUsuario() {
		return tipoUsuario;
	}

	public void setTipoUsuario(TipoUsuario tipoUsuario) {
		this.tipoUsuario = tipoUsuario;
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
