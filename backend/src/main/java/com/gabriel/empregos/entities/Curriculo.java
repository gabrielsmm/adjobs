package com.gabriel.empregos.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import com.gabriel.empregos.enums.EstadoCivil;
import com.gabriel.empregos.enums.Sexo;

@Entity
@Table(name = "tb_curriculos")
public class Curriculo implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@OneToOne
	@JoinColumn(name = "candidato_id", unique=true)
	private Candidato candidato;
	private String nome;
	private String resumo;
	private String telefone;
	private String telefoneCelular;
	private Date dataNascimento;
	private EstadoCivil estadoCivil;
	private Sexo sexo;
	private String cep;
	private String estado;
	private String cidade;
	private String bairro;
	private String rua;
	private String numero;
	private String complemento;
	private Boolean pessoaComDeficiencia;
	
	@LazyCollection(LazyCollectionOption.FALSE)
	@OneToMany(mappedBy = "curriculo")
	private List<CurriculoFormacao> formacoes = new ArrayList<>();
	
	@LazyCollection(LazyCollectionOption.FALSE)
	@OneToMany(mappedBy = "curriculo")
	private List<CurriculoExperiencia> experiencias = new ArrayList<>();
	
	private String linkedIn;
	private String facebook;
	private String instagram;
	private String site;
	
	public Curriculo() {
		
	}

	

	public Curriculo(Long id, Candidato candidato, String nome, String resumo, String telefone, String telefoneCelular,
			Date dataNascimento, EstadoCivil estadoCivil, Sexo sexo, String cep, String estado, String cidade,
			String bairro, String rua, String numero, String complemento, Boolean pessoaComDeficiencia, String linkedIn,
			String facebook, String instagram, String site) {
		super();
		this.id = id;
		this.candidato = candidato;
		this.nome = nome;
		this.resumo = resumo;
		this.telefone = telefone;
		this.telefoneCelular = telefoneCelular;
		this.dataNascimento = dataNascimento;
		this.estadoCivil = estadoCivil;
		this.sexo = sexo;
		this.cep = cep;
		this.estado = estado;
		this.cidade = cidade;
		this.bairro = bairro;
		this.rua = rua;
		this.numero = numero;
		this.complemento = complemento;
		this.pessoaComDeficiencia = pessoaComDeficiencia;
		this.linkedIn = linkedIn;
		this.facebook = facebook;
		this.instagram = instagram;
		this.site = site;
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

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getResumo() {
		return resumo;
	}

	public void setResumo(String resumo) {
		this.resumo = resumo;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getTelefoneCelular() {
		return telefoneCelular;
	}

	public void setTelefoneCelular(String telefoneCelular) {
		this.telefoneCelular = telefoneCelular;
	}

	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public EstadoCivil getEstadoCivil() {
		return estadoCivil;
	}

	public void setEstadoCivil(EstadoCivil estadoCivil) {
		this.estadoCivil = estadoCivil;
	}

	public Sexo getSexo() {
		return sexo;
	}

	public void setSexo(Sexo sexo) {
		this.sexo = sexo;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getRua() {
		return rua;
	}

	public void setRua(String rua) {
		this.rua = rua;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public Boolean getPessoaComDeficiencia() {
		return pessoaComDeficiencia;
	}

	public void setPessoaComDeficiencia(Boolean pessoaComDeficiencia) {
		this.pessoaComDeficiencia = pessoaComDeficiencia;
	}

	public List<CurriculoFormacao> getFormacoes() {
		return formacoes;
	}

	public List<CurriculoExperiencia> getExperiencias() {
		return experiencias;
	}

	public String getLinkedIn() {
		return linkedIn;
	}

	public void setLinkedIn(String linkedIn) {
		this.linkedIn = linkedIn;
	}

	public String getFacebook() {
		return facebook;
	}

	public void setFacebook(String facebook) {
		this.facebook = facebook;
	}

	public String getInstagram() {
		return instagram;
	}

	public void setInstagram(String instagram) {
		this.instagram = instagram;
	}

	public String getSite() {
		return site;
	}

	public void setSite(String site) {
		this.site = site;
	}

}
