package com.heptagon.service;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Service
public class JwtService {

	private String secret = "codelikeapro";

	public String generateToken(String username, String role) {

		Map<String, Object> claims = new HashMap<>();
		return createToken(claims, username, role);
	}

	private String createToken(Map<String, Object> claims, String username, String role) {

		return Jwts.builder().setClaims(claims).setSubject(username).setAudience(role)
				.setIssuedAt(new Date(System.currentTimeMillis()))
				.setExpiration(new Date(System.currentTimeMillis() + (1000 * 60 * 60 * 10)))
				.signWith(SignatureAlgorithm.HS256, secret).compact();

	}

	public boolean validateToken(String token, UserDetails userDetails) {
		final String username = extractUsername(token);
		try {
			return (username.equals(userDetails.getUsername()) && !isTokenExpired(token));
		} catch (Exception e) {
			return false;

		}
	}

	public String extractRole(String token) {
		try {

			return extractClaim(token, Claims::getAudience);

		} catch (Exception e) {

			return null;
		}
	}

	public String extractUsername(String token) {
		try {
			String name = extractClaim(token, Claims::getSubject);
			return name;
		} catch (Exception e) {
			System.out.println("error " + e.getMessage());
			return null;
		}
	}

	private Date extractExpiration(String token) {
		return extractClaim(token, Claims::getExpiration);
	}

	private <T> T extractClaim(String token, Function<Claims, T> claimsResolver) {
		try {
			final Claims claims = extractAllClaims(token);
			return claimsResolver.apply(claims);
		} catch (Exception e) {

			return null;
		}
	}

	private boolean isTokenExpired(String token) {

		return extractExpiration(token).before(new Date());
	}

	private Claims extractAllClaims(String token) {
		try {
			return Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody();
		} catch (Exception e) {
			return null;
		}
	}
}
