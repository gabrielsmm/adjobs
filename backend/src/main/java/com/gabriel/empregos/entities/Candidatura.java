package com.gabriel.empregos.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.gabriel.empregos.enums.CandidaturaStatus;

@Entity
@Table(name = "tb_candidaturas")
public class Candidatura implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@ManyToOne
	@JoinColumn(name = "candidato_id")
	private Candidato candidato;
	@ManyToOne
	@JoinColumn(name = "vaga_id")
	private Vaga vaga;
	private Date dataCandidatura;
	@Enumerated(value = EnumType.ORDINAL)
	private CandidaturaStatus status;
	
	public Candidatura() {
		
	}

	public Candidatura(Long id, Candidato candidato, Vaga vaga, Date dataCandidatura, CandidaturaStatus status) {
		this.id = id;
		this.candidato = candidato;
		this.vaga = vaga;
		this.dataCandidatura = dataCandidatura;
		this.status = status;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Candidato getCandidato() {
		return candidato;
	}

	public void setCandidato(Candidato candidato) {
		this.candidato = candidato;
	}

	public Vaga getVaga() {
		return vaga;
	}

	public void setVaga(Vaga vaga) {
		this.vaga = vaga;
	}

	public Date getDataCandidatura() {
		return dataCandidatura;
	}

	public void setDataCandidatura(Date dataCandidatura) {
		this.dataCandidatura = dataCandidatura;
	}

	public CandidaturaStatus getStatus() {
		return status;
	}

	public void setStatus(CandidaturaStatus status) {
		this.status = status;
	}
	
}
