package com.gabriel.empregos.dtos;

import java.io.Serializable;
import java.util.Date;

import com.gabriel.empregos.entities.Empresa;
import com.gabriel.empregos.enums.TipoUsuario;

public class EmpresaDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Long id;
	private String email;
	private Date dataCadastro;
	private TipoUsuario tipoUsuario;
	private String nome;
	private String cnpj;
	private Integer qtdFuncionarios;
	private String cep;
	private String nomeResponsavel;
	private String telefone;
	private String celular;
	
	public EmpresaDTO() {
		
	}
	
	public EmpresaDTO(Empresa obj) {
		this.id = obj.getId();
		this.email = obj.getEmail();
		this.dataCadastro = obj.getDataCadastro();
		this.tipoUsuario = obj.getTipoUsuario();
		this.nome = obj.getNome();
		this.cnpj = obj.getCnpj();
		this.qtdFuncionarios = obj.getQtdFuncionarios();
		this.cep = obj.getCep();
		this.nomeResponsavel = obj.getNomeResponsavel();
		this.telefone = obj.getTelefone();
		this.celular = obj.getCelular();
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

}
