package com.gabriel.empregos.util;

import java.security.SecureRandom;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class Util {
	
	//Utilizando a BCrypt
	public static String BCryptCriptografar(String senha) {
		return new BCryptPasswordEncoder().encode(senha);
	}
	
	public static Boolean BCryptVerificar(String senha, String senhaCriptografada) {
		return new BCryptPasswordEncoder().matches(senha, senhaCriptografada);
	}
	
	//Utilizando a BCrypt com criptografia personalizada
	public static String criptografar(String senha) {
		return new CustomPasswordEncoder().encode(senha);
	}
	
	public static Boolean verificar(String senha, String senhaCriptografada) {
		return new CustomPasswordEncoder().matches(senha, senhaCriptografada);
	}
	
	// Método para gerar uma senha alfanumérica aleatória de um comprimento específico
    public static String gerarSenhaAleatoria(int len) {
        final String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
 
        SecureRandom random = new SecureRandom();
        StringBuilder sb = new StringBuilder();
 
        for (int i = 0; i < len; i++)
        {
            int randomIndex = random.nextInt(chars.length());
            sb.append(chars.charAt(randomIndex));
        }
 
        return sb.toString();
    }
	
}
