package com.gabriel.empregos.services;

import java.util.Date;

import org.springframework.stereotype.Service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.gabriel.empregos.entities.Usuario;

@Service
public class TokenService {
	
	private static final long expirationTime = 1800000;
	private String key = "String Aleatoria Secret"; 
//	SecretKey key = Keys.hmacShaKeyFor(Decoders.BASE64.decode("String Aleatoria Secret"));
	
	public String generateToken(Usuario usuario) {
		return JWT.create()
				.withSubject("Teste Jwt API") //ID do usuário
				.withClaim("idUsuarioLogado", usuario.getId())
				.withIssuedAt(new Date(System.currentTimeMillis()))
				.withExpiresAt(new Date(System.currentTimeMillis() + expirationTime))
				.sign(Algorithm.HMAC256(key));
	}

	public DecodedJWT decodeToken(String token) {
		//Verificar assinatura antes
		return JWT.decode(token);
	}
	
//	public String generateToken(Usuario usuario) {
//	return Jwts.builder()
//			.setIssuedAt(new Date(System.currentTimeMillis()))
//			.setSubject("Teste Jwt API") //ID do usuário
//			.setExpiration(new Date(System.currentTimeMillis() + expirationTime))
//			.signWith(key, SignatureAlgorithm.HS256)
//			.compact();
//}
	
}
