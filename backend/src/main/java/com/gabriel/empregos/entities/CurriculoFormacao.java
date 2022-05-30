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
import com.gabriel.empregos.enums.FormacaoNivel;
import com.gabriel.empregos.enums.FormacaoStatus;

@Entity
@Table(name = "tb_formacoes")
public class CurriculoFormacao implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nomeInstituicao;
	private FormacaoNivel nivel;
	private FormacaoStatus status;
	private String curso;
	private Integer mesInicio;
	private Integer anoInicio;
	private Integer mesConclusao;
	private Integer anoConclusao;
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "curriculo_id")
	private Curriculo curriculo;
	
	public CurriculoFormacao() {
		
	}

	public CurriculoFormacao(Long id, String nomeInstituicao, FormacaoNivel nivel, FormacaoStatus status, String curso,
			Integer mesInicio, Integer anoInicio, Integer mesConclusao, Integer anoConclusao, Curriculo curriculo) {
		this.id = id;
		this.nomeInstituicao = nomeInstituicao;
		this.nivel = nivel;
		this.status = status;
		this.curso = curso;
		this.mesInicio = mesInicio;
		this.anoInicio = anoInicio;
		this.mesConclusao = mesConclusao;
		this.anoConclusao = anoConclusao;
		this.curriculo = curriculo;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNomeInstituicao() {
		return nomeInstituicao;
	}

	public void setNomeInstituicao(String nomeInstituicao) {
		this.nomeInstituicao = nomeInstituicao;
	}

	public FormacaoNivel getNivel() {
		return nivel;
	}

	public void setNivel(FormacaoNivel nivel) {
		this.nivel = nivel;
	}

	public FormacaoStatus getStatus() {
		return status;
	}

	public void setStatus(FormacaoStatus status) {
		this.status = status;
	}

	public String getCurso() {
		return curso;
	}

	public void setCurso(String curso) {
		this.curso = curso;
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

	public Curriculo getCurriculo() {
		return curriculo;
	}

	public void setCurriculo(Curriculo curriculo) {
		this.curriculo = curriculo;
	}
	
}
