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
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.Proxy;

import com.gabriel.empregos.enums.TipoContratacao;
import com.gabriel.empregos.enums.VagaStatus;

@Entity
@Table(name = "tb_vagas")
@Proxy(lazy = false)
public class Vaga {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@NotEmpty(message = "Campo NOME é requerido")
	@Column(name = "nome")
	private String nome;
	@NotNull(message = "Campo QUANTIDADE é requerido")
	private Integer quantidade;
	@NotNull(message = "Campo SALÁRIO é requerido")
	private Double salario;
	@NotEmpty(message = "Campo LOCALIZAÇÃO é requerido")
	private String localizacao;
	private Date dataCadastro;
	private Date dataAlteracao;
	@Column(columnDefinition = "TEXT")
	private String descricao;
	@Column(columnDefinition = "TEXT")
	private String beneficios;
	@Column(columnDefinition = "TEXT")
	private String requisitos;
	
//	@OneToOne
//	@JoinColumn(name = "tipocontratacao_id")
	@Enumerated(value = EnumType.ORDINAL)
	private TipoContratacao tipo;
	
	@Enumerated(value = EnumType.ORDINAL)
	private VagaStatus status;
	
	@ManyToOne
	@JoinColumn(name = "empresa_id")
	private Empresa empresa;
	
	public Vaga() {
		
	}
	
	public Vaga(Long id, String nome, TipoContratacao tipo, Integer quantidade, Double salario, String localizacao,
			Date dataCadastro, Date dataAlteracao, String descricao, String beneficios, String requisitos, VagaStatus status, Empresa empresa) {
		this.id = id;
		this.nome = nome;
		this.tipo = tipo;
		this.quantidade = quantidade;
		this.salario = salario;
		this.localizacao = localizacao;
		this.dataCadastro = dataCadastro;
		this.dataAlteracao = dataAlteracao;
		this.descricao = descricao;
		this.beneficios = beneficios;
		this.requisitos = requisitos;
		this.status = status;
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

	public Date getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(Date dataCadastro) {
		this.dataCadastro = dataCadastro;
	}

	public Date getDataAlteracao() {
		return dataAlteracao;
	}

	public void setDataAlteracao(Date dataAlteracao) {
		this.dataAlteracao = dataAlteracao;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getBeneficios() {
		return beneficios;
	}

	public void setBeneficios(String beneficios) {
		this.beneficios = beneficios;
	}

	public String getRequisitos() {
		return requisitos;
	}

	public void setRequisitos(String requisitos) {
		this.requisitos = requisitos;
	}
	
	public VagaStatus getStatus() {
		return status;
	}

	public void setStatus(VagaStatus status) {
		this.status = status;
	}

	public Empresa getEmpresa() {
		return empresa;
	}

	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}
	
}
