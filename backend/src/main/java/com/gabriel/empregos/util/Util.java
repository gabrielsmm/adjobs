package com.gabriel.empregos.util;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class Util {
	
	public static String criptografar(String campo) {
		return new BCryptPasswordEncoder().encode(reverter(campo, campo.length()-1));
	}
	
	public static Boolean verificar(String campo, String campoCriptografado) {
		return new BCryptPasswordEncoder().matches(reverter(campo, campo.length()-1), campoCriptografado);
	}
	
	private static String reverter(String str, int index){
		if(index == 0){
			return str.charAt(0) + "";
		}
		char letter = str.charAt(index);
		return letter + reverter(str, index-1);
	}
	
}
