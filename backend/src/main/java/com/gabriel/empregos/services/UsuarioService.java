package com.gabriel.empregos.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gabriel.empregos.entities.Usuario;
import com.gabriel.empregos.repositories.UsuarioRepository;
import com.gabriel.empregos.security.JwtTokenProvider;
import com.gabriel.empregos.services.exceptions.ObjectNotFoundException;
import com.gabriel.empregos.util.Util;

@Service
public class UsuarioService {
	
	@Autowired
	private UsuarioRepository repository;
	
	@Autowired
	private JwtTokenProvider jwtTokenProvider;
	
	public Usuario findById(Integer id) {
		Optional<Usuario> obj = this.repository.findById(Integer.toUnsignedLong(id));
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado! Id: " + id + ", Tipo: " + Usuario.class.getName())); //caso nao encontre retorna null
	}
	
	public Usuario login(Usuario obj) {
		Usuario usuario = this.repository.findByEmail(obj.getEmail());
		if(usuario != null && Util.verificar(obj.getSenha(), usuario.getSenha())) {
			String tokenGerado = jwtTokenProvider.createToken(usuario);
			usuario.setToken(tokenGerado);
			return usuario;
		} else {
			//InvalidLoginException
			throw new ObjectNotFoundException("Usuário ou senha incorretos!");
		}
	}
	
	public void alterarSenha(Integer id, String senha) {
		Usuario obj = this.findById(id);
		obj.setSenha(Util.criptografar(senha));
		this.repository.save(obj);
	}
	
}
