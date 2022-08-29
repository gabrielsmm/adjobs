package com.gabriel.empregos.dtos;

import java.io.Serializable;
import java.util.Date;

import com.gabriel.empregos.entities.Vaga;
import com.gabriel.empregos.enums.TipoContratacao;
import com.gabriel.empregos.enums.VagaStatus;
import com.gabriel.empregos.services.VagaService;
import com.gabriel.empregos.util.SpringBeanLocator;

public class VagaDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;
	private String nome;
	private Integer quantidade;
	private Double salario;
	private String localizacao;
	private Date dataCadastro;
	private Date dataAlteracao;
	private String descricao;
	private String beneficios;
	private String requisitos;
	private TipoContratacao tipo;
	private VagaStatus status;
	private EmpresaDTO empresa;
	private Integer qtdCandidatos;
	
	public VagaDTO() {
		
	}
	
	public VagaDTO(Vaga obj) {
		this.id = obj.getId();
		this.nome = obj.getNome();
		this.quantidade = obj.getQuantidade();
		this.salario = obj.getSalario();
		this.localizacao = obj.getLocalizacao();
		this.dataCadastro = obj.getDataCadastro();
		this.dataAlteracao = obj.getDataAlteracao();
		this.descricao = obj.getDescricao();
		this.beneficios = obj.getBeneficios();
		this.requisitos = obj.getRequisitos();
		this.tipo = obj.getTipo();
		this.status = obj.getStatus();
		this.empresa = new EmpresaDTO(obj.getEmpresa());
		
		Integer idVaga = obj.getId().intValue();
		this.qtdCandidatos = this.obterCandidatos(idVaga);
	}
	
	private Integer obterCandidatos(Integer idVaga) {
		if (idVaga > 0) {
			return SpringBeanLocator.getBean(VagaService.class).getQtdCandidatos(idVaga);
		}
		return 0;
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

	public TipoContratacao getTipo() {
		return tipo;
	}

	public void setTipo(TipoContratacao tipo) {
		this.tipo = tipo;
	}

	public VagaStatus getStatus() {
		return status;
	}

	public void setStatus(VagaStatus status) {
		this.status = status;
	}

	public EmpresaDTO getEmpresa() {
		return empresa;
	}

	public void setEmpresa(EmpresaDTO empresa) {
		this.empresa = empresa;
	}

	public Integer getQtdCandidatos() {
		return qtdCandidatos;
	}

	public void setQtdCandidatos(Integer qtdCandidatos) {
		this.qtdCandidatos = qtdCandidatos;
	}
	
}
