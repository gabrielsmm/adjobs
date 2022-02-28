package com.gabriel.empregos.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "tb_empresas")
public class Empresa {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nome;
	private String cnpj;
	private Integer qtdFuncionarios;
	private String cep;
	private String nomeResponsavel;
	private String telefone;
	private String celular;
	private String senha;
	
	@OneToMany(mappedBy = "empresa")
	private List<Concurso> concursos = new ArrayList<>();
	
	@OneToMany(mappedBy = "empresa")
	private List<Vaga> vagas = new ArrayList<>();
	
	public Empresa() {
		
	}

	public Empresa(Long id, String nome, String cnpj, Integer qtdFuncionarios, String cep, String nomeResponsavel,
			String telefone, String celular, String senha) {
		this.id = id;
		this.nome = nome;
		this.cnpj = cnpj;
		this.qtdFuncionarios = qtdFuncionarios;
		this.cep = cep;
		this.nomeResponsavel = nomeResponsavel;
		this.telefone = telefone;
		this.celular = celular;
		this.senha = senha;
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

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public Integer getQtdFuncionarios() {
		return qtdFuncionarios;
	}

	public void setQtdFuncionarios(Integer qtdFuncionarios) {
		this.qtdFuncionarios = qtdFuncionarios;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getNomeResponsavel() {
		return nomeResponsavel;
	}

	public void setNomeResponsavel(String nomeResponsavel) {
		this.nomeResponsavel = nomeResponsavel;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getCelular() {
		return celular;
	}

	public void setCelular(String celular) {
		this.celular = celular;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

}
