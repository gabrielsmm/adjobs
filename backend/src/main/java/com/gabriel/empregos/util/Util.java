package com.gabriel.empregos.util;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class Util {
	
	public static String criptografar(String campo) {
		return new BCryptPasswordEncoder().encode(campo);
	}
	
	public static Boolean verificar(String campo, String campoCriptografado) {
		return new BCryptPasswordEncoder().matches(campo, campoCriptografado);
	}
	
}
