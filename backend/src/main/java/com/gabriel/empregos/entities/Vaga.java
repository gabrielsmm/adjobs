package com.gabriel.empregos.entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tb_vagas")
public class Vaga {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nome;
	private Integer quantidade;
	private Double salario;
	private String localizacao;
	private Date expiracao;
	
	@OneToOne
	@JoinColumn(name = "tipocontratacao_id")
	private TipoContratacao tipo;
	
	public Vaga() {
		
	}
	
	public Vaga(Long id, String nome, TipoContratacao tipo, Integer quantidade, Double salario, String localizacao,
			Date expiracao) {
		this.id = id;
		this.nome = nome;
		this.tipo = tipo;
		this.quantidade = quantidade;
		this.salario = salario;
		this.localizacao = localizacao;
		this.expiracao = expiracao;
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
	
}
