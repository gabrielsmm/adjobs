package com.gabriel.empregos.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "tb_experiencias")
public class CurriculoExperiencia implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nomeEmpresa;
	private String cargo;
	private Double salario;
	private Integer mesInicio;
	private Integer anoInicio;
	private Integer mesConclusao;
	private Integer anoConclusao;
	private Boolean atual;
	private String descricao;
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "curriculo_id")
	private Curriculo curriculo;
	
	public CurriculoExperiencia() {
		
	}

	public CurriculoExperiencia(Long id, String nomeEmpresa, String cargo, Double salario, Integer mesInicio,
			Integer anoInicio, Integer mesConclusao, Integer anoConclusao, Boolean atual, String descricao,
			Curriculo curriculo) {
		this.id = id;
		this.nomeEmpresa = nomeEmpresa;
		this.cargo = cargo;
		this.salario = salario;
		this.mesInicio = mesInicio;
		this.anoInicio = anoInicio;
		this.mesConclusao = mesConclusao;
		this.anoConclusao = anoConclusao;
		this.atual = atual;
		this.descricao = descricao;
		this.curriculo = curriculo;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNomeEmpresa() {
		return nomeEmpresa;
	}

	public void setNomeEmpresa(String nomeEmpresa) {
		this.nomeEmpresa = nomeEmpresa;
	}

	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

	public Double getSalario() {
		return salario;
	}

	public void setSalario(Double salario) {
		this.salario = salario;
	}

	public Integer getMesInicio() {
		return mesInicio;
	}

	public void setMesInicio(Integer mesInicio) {
		this.mesInicio = mesInicio;
	}

	public Integer getAnoInicio() {
		return anoInicio;
	}

	public void setAnoInicio(Integer anoInicio) {
		this.anoInicio = anoInicio;
	}

	public Integer getMesConclusao() {
		return mesConclusao;
	}

	public void setMesConclusao(Integer mesConclusao) {
		this.mesConclusao = mesConclusao;
	}

	public Integer getAnoConclusao() {
		return anoConclusao;
	}

	public void setAnoConclusao(Integer anoConclusao) {
		this.anoConclusao = anoConclusao;
	}

	public Boolean getAtual() {
		return atual;
	}

	public void setAtual(Boolean atual) {
		this.atual = atual;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Curriculo getCurriculo() {
		return curriculo;
	}

	public void setCurriculo(Curriculo curriculo) {
		this.curriculo = curriculo;
	}

}
