package com.jwt.jwt.utils;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.cglib.core.internal.Function;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.nio.charset.StandardCharsets;
import java.util.Date;
import java.util.HashMap;

import static javax.crypto.Cipher.SECRET_KEY;


@Component
public class Utils {


    private static long EXPIRATION_TIME = 5 * 60 * 60 ;
    private static String SECRET = "your-very-long-secret-key-with-at-least-32-chars" ;
    SecretKey key = Keys.hmacShaKeyFor(SECRET.getBytes(StandardCharsets.UTF_8));


    public String generateToken(String  subject, HashMap<String,Object> claims){
        return Jwts.builder().setClaims(claims).setSubject(subject).setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis()+ EXPIRATION_TIME * 1000))
                .signWith(SignatureAlgorithm.HS256,key).compact();
    }

    public String createToken(UserDetails userDetails){
        HashMap<String,Object> claims = new HashMap<>() ;
        return generateToken(userDetails.getUsername(),claims);
    }

    // create validate token method
    public boolean validateToken(UserDetails userDetails,String token){
        String username = getUserNameFromToken(token);
        return username.equals(userDetails.getUsername()) && !isTokenExpired(token);
    }
    public boolean isTokenExpired(String token){
        final Date expirationDate = getExpirationDate(token) ;
        return new Date().after(expirationDate);
    }

    public Date getExpirationDate(String token){
        return getClaimsFromToken(token , Claims::getExpiration);
    }

    public String getUserNameFromToken(String token){
        return getClaimsFromToken(token, Claims::getSubject);
    }

    public <T> T getClaimsFromToken(String  token, Function<Claims,T> claimsResolver){
        final Claims claims = getAllClaims(token);
        return claimsResolver.apply(claims);

    }

    public Claims getAllClaims(String token){
        return Jwts.parserBuilder().setSigningKey(key).build().parseClaimsJws(token).getBody();
    }
}
