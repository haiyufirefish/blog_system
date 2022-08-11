package com.ff.blog.utils;

import io.jsonwebtoken.Jwt;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class JWTUtils {
    private static final String jwtToken = "123456ff!@#$$";

    public static String createToken(Long userId){
        Map<String,Object> claims = new HashMap<>();
        claims.put("userId",userId);
        JwtBuilder jwtBuilder = Jwts.builder()
                .signWith(SignatureAlgorithm.HS256, jwtToken) // issue algorithm, jwtToken
                .setClaims(claims) // body data, unique
                .setIssuedAt(new Date()) // set the issue time
                .setExpiration(new Date(System.currentTimeMillis() + 24 * 60 * 60 * 1000));// one day valid
        String token = jwtBuilder.compact();
        return token;
    }

    public static Map<String, Object> checkToken(String token){
        try {
            Jwt parse = Jwts.parser().setSigningKey(jwtToken).parse(token);
            return (Map<String, Object>) parse.getBody();
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;

    }

    /**
     *  test JWT
     * @param args
     */
    public static void main(String[] args) {
        String token =  JWTUtils.createToken(100L);
        System.out.println(token);
        Map<String,Object> mp = JWTUtils.checkToken(token);

        System.out.println(mp.get("userId"));
    }
}