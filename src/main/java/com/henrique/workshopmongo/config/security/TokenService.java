package com.henrique.workshopmongo.config.security;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.henrique.workshopmongo.domain.User;

@Service
public class TokenService {

	@Value("${security.jwt.token-secret:default}")
	private String secret = "";
	
	@Value("${security.jwt.token-expire:2L}")
	private Long expire = 0L;
	
	public String jwtTokenProvider(User user) {
		Algorithm algorithm = Algorithm.HMAC256(secret.getBytes());
		
		return JWT.create()
				.withIssuer("Foodsoft")
				.withSubject(user.getUsername())
				.withExpiresAt(getExpiration())
				.sign(algorithm);
	}
	
	public Instant getExpiration() {
		return LocalDateTime.now().plusHours(expire).toInstant(ZoneOffset.of("-03:00"));
	}
}
