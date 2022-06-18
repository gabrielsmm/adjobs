package com.gabriel.empregos.util;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class Util {
	
	//Utilizando a BCrypt
	public static String BCryptCriptografar(String senha) {
		return new BCryptPasswordEncoder().encode(senha);
	}
	
	public static Boolean BCryptVerificar(String senha, String senhaCriptografada) {
		return new BCryptPasswordEncoder().matches(senha, senhaCriptografada);
	}
	
	//Utilizando a BCryp com criptografia personalizada
	public static String criptografar(String senha) {
		return new CustomPasswordEncoder().encode(senha);
	}
	
	public static Boolean verificar(String senha, String senhaCriptografada) {
		return new CustomPasswordEncoder().matches(senha, senhaCriptografada);
	}
	
}
