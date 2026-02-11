package com.ec.akirafinanzas.security;

import java.util.Date;

import org.springframework.stereotype.Service;

import com.ec.akirafinanzas.model.entity.User;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;

@Service
public class JwtService {

        private static final String SECRET_KEY = "akira_finanzas_super_secret_key_256_bits_ok";

        public String generateToken(User user) {

                return Jwts.builder()
                                .setSubject(user.getUsername())
                                .claim("personId", user.getPerson().getPersonId())
                                .claim("Name", user.getPerson().getFirstName())
                                .setIssuedAt(new Date())
                                .setExpiration(
                                                new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 24)) // Expira en
                                                                                                            // 24 horas
                                .signWith(Keys.hmacShaKeyFor(SECRET_KEY.getBytes()))
                                .compact();
        }

        private Claims extractAllClaims(String token) {
                return Jwts.parserBuilder()
                                .setSigningKey(SECRET_KEY.getBytes())
                                .build()
                                .parseClaimsJws(token)
                                .getBody();
        }

        public String extractUsername(String token) {
                return Jwts.parserBuilder()
                                .setSigningKey(SECRET_KEY.getBytes())
                                .build()
                                .parseClaimsJws(token)
                                .getBody()
                                .getSubject();
        }

        public Long extractPersonId(String token) {
                return extractAllClaims(token).get("personId", Long.class);
        }

}
