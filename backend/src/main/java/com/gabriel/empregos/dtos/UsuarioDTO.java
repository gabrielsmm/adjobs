package com.gabriel.empregos.dtos;

import java.io.Serializable;
import java.util.Date;

import com.gabriel.empregos.entities.Usuario;
import com.gabriel.empregos.enums.TipoUsuario;

public class UsuarioDTO implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private Long id;
	private String email;
	private String token;
	private String tipo;
	private Date dataCadastro;
	private TipoUsuario tipoUsuario;
	
	public UsuarioDTO() {
		
	}
	
	public UsuarioDTO(Usuario obj) {
		this.id = obj.getId();
		this.email = obj.getEmail();
		this.token = obj.getToken();
		this.dataCadastro = obj.getDataCadastro();
		this.tipoUsuario = obj.getTipoUsuario();
	}
	
	//Usado quando se trabalha com JWT
	public UsuarioDTO(Usuario obj, String tipo) {
		this.id = obj.getId();
		this.email = obj.getEmail();
		this.token = obj.getToken();
		this.tipo = tipo;
		this.dataCadastro = obj.getDataCadastro();
		this.tipoUsuario = obj.getTipoUsuario();
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

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
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
