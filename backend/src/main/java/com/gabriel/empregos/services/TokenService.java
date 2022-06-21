package com.gabriel.empregos.services;

//@Service
public class TokenService {
	
//	private static final long expirationTime = 1800000;
//	private String key = "String Aleatoria Secret"; 
//	SecretKey key = Keys.hmacShaKeyFor(Decoders.BASE64.decode("String Aleatoria Secret"));
	
//	public String generateToken(Usuario usuario) {
//		return JWT.create()
//				.withSubject("Teste Jwt API") //ID do usuário
//				.withClaim("idUsuarioLogado", usuario.getId())
//				.withIssuedAt(new Date(System.currentTimeMillis()))
//				.withExpiresAt(new Date(System.currentTimeMillis() + expirationTime))
//				.sign(Algorithm.HMAC256(key));
//	}

//	public boolean validateToken(String token) {
//		try {
//			String tokenTratado = token.replace("Bearer ", "");
//			DecodedJWT decodedJWT = JWT.decode(tokenTratado);
//			//verifica se o token está expirado
//			if (decodedJWT.getExpiresAt().before(new Date(System.currentTimeMillis()))) throw new ExpiredTokenException();
//			return true;
//		} catch(ExpiredTokenException et) {
//			et.printStackTrace();
//			throw et;
//		} catch (Exception e) {
//			e.printStackTrace();
//			throw new InvalidTokenException();
//		}
//	}
	
//	public String generateToken(Usuario usuario) {
//	return Jwts.builder()
//			.setIssuedAt(new Date(System.currentTimeMillis()))
//			.setSubject("Teste Jwt API") //ID do usuário
//			.setExpiration(new Date(System.currentTimeMillis() + expirationTime))
//			.signWith(key, SignatureAlgorithm.HS256)
//			.compact();
//}
	
}
