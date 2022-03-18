package com.gabriel.empregos.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import com.gabriel.empregos.enums.TipoUsuario;

//@MappedSuperclass
@Entity
@Inheritance(strategy=InheritanceType.JOINED)
@DiscriminatorColumn(name="TYPE")
@Table(name = "tb_usuarios")
public class Usuario implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotEmpty(message = "Campo EMAIL é requerido")
	@Size(min = 3, max = 100, message = "O campo EMAIL deve ter entre 3 e 100 caracteres")
	private String email;
	private String senha;
	private Date dataCadastro;
	
	@Enumerated(value = EnumType.ORDINAL)
	private TipoUsuario tipoUsuario;
	
	public Usuario() {
		
	}
	
	public Usuario(Long id, String email, String senha, Date dataCadastro, TipoUsuario tipoUsuario) {
		this.id = id;
		this.email = email;
		this.senha = senha;
		this.dataCadastro = dataCadastro;
		this.tipoUsuario = tipoUsuario;
	}

	public Usuario(String email, String senha, Date dataCadastro, TipoUsuario tipoUsuario) {
		this.email = email;
		this.senha = senha;
		this.dataCadastro = dataCadastro;
		this.tipoUsuario = tipoUsuario;
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

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
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
	
}
