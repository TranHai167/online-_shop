package com.example.productmanagmentmodule.utility;

import com.example.productmanagmentmodule.entity.UserEntity;
import com.example.productmanagmentmodule.enums.Roles;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

@Component
public class JwtUtil {

    @Value("${spring-security.jwt.secret-key}")
    private String secretKey;

    @Value("${spring-security.jwt.expiration}")
    private Integer expiration;

    public String generateToken(UserEntity userEntity) {
        Map<String, Object> claims = new HashMap<>();
        return doGenerateToken(claims, userEntity.getFirstName(), userEntity.getUsername(), userEntity.getRole());
    }

    private String doGenerateToken(Map<String, Object> claims, String firstName, String email, Roles role) {
        Map<String, Object> map = new HashMap<>();
        map.put("role", role);
        return Jwts.builder().setClaims(claims).setIssuer(firstName).addClaims(map)
                .setSubject(email).setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + expiration))
                .signWith(getSignInKey(), SignatureAlgorithm.HS256).compact();
    }

    private Key getSignInKey() {
        byte[] keyBytes = Decoders.BASE64.decode(secretKey);
        return Keys.hmacShaKeyFor(keyBytes);
    }

    public boolean validateToken(String jwtToken, UserDetails userDetails) {
        return userDetails.getUsername().equals(getUsernameFromToken(jwtToken))
                && !isExpirationToken(jwtToken);
    }

    public <T> T extractClaimFromToken(String token, Function<Claims, T> claimsResolver) {
        final Claims claims = extractAllClaims(token);
        return claimsResolver.apply(claims);
    }

    public String getUsernameFromToken(String token) {
        return extractClaimFromToken(token, Claims::getSubject);
    }

    public String getUserIdFromToken(String token) {
        return extractClaimFromToken(token, Claims::getId);
    }

    public Claims extractAllClaims(String token) {
        return Jwts
                .parserBuilder()
                .setSigningKey(getSignInKey())
                .build()
                .parseClaimsJws(token)
                .getBody();
    }

    private boolean isExpirationToken(String token) {
        Date expirationDate = extractClaimFromToken(token, Claims::getExpiration);
        return expirationDate.before(new Date(System.currentTimeMillis()));
    }
}

