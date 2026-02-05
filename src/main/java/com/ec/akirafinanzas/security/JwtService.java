package com.ec.akirafinanzas.security;

import java.util.Date;

import org.springframework.stereotype.Service;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;

@Service
public class JwtService {

        private static final String SECRET_KEY = "akira_finanzas_super_secret_key_256_bits_ok";

        public String generateToken(Long userId) {

                return Jwts.builder()
                                .setSubject(userId.toString())
                                .setIssuedAt(new Date())
                                .setExpiration(
                                                new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 24))
                                .signWith(Keys.hmacShaKeyFor(SECRET_KEY.getBytes()))
                                .compact();
        }

        public Long extractUserId(String token) {
                return Long.valueOf(
                                Jwts.parserBuilder()
                                                .setSigningKey(SECRET_KEY.getBytes())
                                                .build()
                                                .parseClaimsJws(token)
                                                .getBody()
                                                .getSubject());
        }
}
