package com.gabriel.empregos.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Proxy;

import com.gabriel.empregos.enums.TipoContratacao;

@Entity
@Table(name = "tb_vagas")
@Proxy(lazy = false)
public class Vaga {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name = "nome")
	private String nome;
	private Integer quantidade;
	private Double salario;
	private String localizacao;
	private Date expiracao;
	
//	@OneToOne
//	@JoinColumn(name = "tipocontratacao_id")
	@Enumerated(value = EnumType.STRING)
	private TipoContratacao tipo;
	
	@ManyToOne
	@JoinColumn(name = "empresa_id")
	private Empresa empresa;
	
	public Vaga() {
		
	}
	
	public Vaga(Long id, String nome, TipoContratacao tipo, Integer quantidade, Double salario, String localizacao,
			Date expiracao, Empresa empresa) {
		this.id = id;
		this.nome = nome;
		this.tipo = tipo;
		this.quantidade = quantidade;
		this.salario = salario;
		this.localizacao = localizacao;
		this.expiracao = expiracao;
		this.empresa = empresa;
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
	
	public TipoContratacao getTipo() {
		return tipo;
	}
	
	public void setTipo(TipoContratacao tipo) {
		this.tipo = tipo;
	}
	
	public Integer getQuantidade() {
		return quantidade;
	}
	
	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}
	
	public Double getSalario() {
		return salario;
	}
	
	public void setSalario(Double salario) {
		this.salario = salario;
	}
	
	public String getLocalizacao() {
		return localizacao;
	}
	
	public void setLocalizacao(String localizacao) {
		this.localizacao = localizacao;
	}
	
	public Date getExpiracao() {
		return expiracao;
	}
	
	public void setExpiracao(Date expiracao) {
		this.expiracao = expiracao;
	}

	public Empresa getEmpresa() {
		return empresa;
	}

	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}
	
}
