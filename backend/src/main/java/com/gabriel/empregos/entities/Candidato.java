package com.gabriel.empregos.entities;

import java.util.Date;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.gabriel.empregos.enums.TipoUsuario;

@Entity
@PrimaryKeyJoinColumn(name="idUsuario")
@DiscriminatorValue("Candidato")
@Table(name = "tb_candidatos")
public class Candidato extends Usuario {
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String nome;
	private String cep;
	
	@OneToOne
	@JoinColumn(name = "cargo_id")
	private Cargo cargo;
	
	@JsonIgnore
	@OneToOne(mappedBy="candidato")
	@JoinColumn(name = "curriculo_id", unique=true)
	private Curriculo curriculo;
	
	
	public Candidato() {
		
	}
	
	public Candidato(Long id, String nome, String cep, Cargo cargo, String email, String senha, Date dataCadastro, TipoUsuario tipoUsuario) {
		super(email, senha, dataCadastro, tipoUsuario);
		this.id = id;
		this.nome = nome;
		this.cep = cep;
		this.cargo = cargo;
	}
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getCep() {
		return cep;
	}
	
	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Cargo getCargo() {
		return cargo;
	}

	public void setCargo(Cargo cargo) {
		this.cargo = cargo;
	}

	public Curriculo getCurriculo() {
		return curriculo;
	}

	public void setCurriculo(Curriculo curriculo) {
		this.curriculo = curriculo;
	}
	
}
