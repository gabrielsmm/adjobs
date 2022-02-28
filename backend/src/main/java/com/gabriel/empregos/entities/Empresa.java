package com.gabriel.empregos.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "tb_empresas")
public class Empresa {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@NotEmpty(message = "Campo NOME é requerido")
	@Size(min = 3, max = 100, message = "O campo NOME deve ter entre 3 e 100 caracteres")
	private String nome;
//	@NotEmpty(message = "Campo CNPJ é requerido")
//	@Size(min = 14, max = 14, message = "O campo CNPJ deve ter 14 caracteres")
	private String cnpj;
	@NotNull(message = "Campo QUANTIDADE DE FUNCIONÁRIOS é requerido")
	private Integer qtdFuncionarios;
	@NotEmpty(message = "Campo CEP é requerido")
	@Size(min = 8, max = 8, message = "O campo CEP deve ter 8 caracteres")
	private String cep;
	@NotEmpty(message = "Campo NOME DO RESPONSÁVEL é requerido")
	@Size(min = 3, max = 100, message = "O campo NOME DO RESPONSÁVEL deve ter entre 3 e 100 caracteres")
	private String nomeResponsavel;
	@NotEmpty(message = "Campo TELEFONE é requerido")
	@Size(max = 11, message = "O campo TELEFONE deve ter no máximo 11 caracteres")
	private String telefone;
	@NotEmpty(message = "Campo CELULAR é requerido")
	@Size(max = 11, message = "O campo CELULAR deve ter no máximo 11 caracteres")
	private String celular;
	@NotEmpty(message = "Campo EMAIL é requerido")
	@Size(min = 3, max = 100, message = "O campo EMAIL deve ter entre 3 e 100 caracteres")
	private String email;
	@NotEmpty(message = "Campo SENHA é requerido")
	@Size(min = 3, max = 100, message = "O campo SENHA deve ter entre 3 e 100 caracteres")
	private String senha;
	
	@OneToMany(mappedBy = "empresa")
	private List<Concurso> concursos = new ArrayList<>();
	
	@OneToMany(mappedBy = "empresa")
	private List<Vaga> vagas = new ArrayList<>();
	
	public Empresa() {
		
	}

	public Empresa(Long id, String nome, String cnpj, Integer qtdFuncionarios, String cep, String nomeResponsavel,
			String telefone, String celular, String email, String senha) {
		this.id = id;
		this.nome = nome;
		this.cnpj = cnpj;
		this.qtdFuncionarios = qtdFuncionarios;
		this.cep = cep;
		this.nomeResponsavel = nomeResponsavel;
		this.telefone = telefone;
		this.celular = celular;
		this.email = email;
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
	

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

}
