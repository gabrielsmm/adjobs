package com.gabriel.empregos.services;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.auth0.jwt.interfaces.DecodedJWT;
import com.gabriel.empregos.entities.Usuario;
import com.gabriel.empregos.repositories.UsuarioRepository;
import com.gabriel.empregos.services.exceptions.ExpiredTokenException;
import com.gabriel.empregos.services.exceptions.InvalidTokenException;
import com.gabriel.empregos.services.exceptions.ObjectNotFoundException;
import com.gabriel.empregos.util.Util;

@Service
public class UsuarioService {
	
	@Autowired
	private UsuarioRepository repository;
	
	@Autowired
	private TokenService tokenService;
	
	public Usuario login(Usuario obj, String token) {
		Usuario usuario = this.repository.findByEmail(obj.getEmail());
		if((usuario != null && Util.verificar(obj.getSenha(), usuario.getSenha())) && !token.isEmpty() && validate(token)) {
//			String tokenGerado = tokenService.generateToken(usuario);
			usuario.setToken(token);
			return usuario;
		} else {
			//InvalidLoginException
			throw new ObjectNotFoundException("Usuário ou senha incorretos!");
		}
	}
	
	private boolean validate(String token) {
		try {
			String tokenTratado = token.replace("Bearer ", "");
			DecodedJWT decodedJWT = tokenService.decodeToken(tokenTratado);
			//verifica se o token está expirado
			if (decodedJWT.getExpiresAt().before(new Date(System.currentTimeMillis()))) throw new ExpiredTokenException();
			return true;
		} catch(ExpiredTokenException et) {
			et.printStackTrace();
			throw et;
		} catch (Exception e) {
			e.printStackTrace();
			throw new InvalidTokenException();
		}
		
	}
	
}
