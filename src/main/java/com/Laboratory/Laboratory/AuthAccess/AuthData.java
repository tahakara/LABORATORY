package com.Laboratory.Laboratory.AuthAccess;

import com.Laboratory.Laboratory.AuthAccess.Interfaces.IAuthAccess;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;

import org.springframework.stereotype.Component;
// import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Component
public class AuthData implements IAuthAccess {

    @Value("${auth.jwt.secret}")
    private String secret;

    @Value("${auth.jwt.issuer}")
    private String issuer;

    private Algorithm algorithm;

    @Autowired
    public AuthData(@Value("${auth.jwt.secret}") String secret, @Value("${auth.jwt.issuer}") String issuer) {
        this.secret = secret;
        this.issuer = issuer;
        this.algorithm = Algorithm.HMAC256(secret);
    }

    public String generateToken(Map<String, Object> payload, Long expireTime) {
        Long systemTime = System.currentTimeMillis();
        Date issuedAt = new Date(systemTime);
        Date espiersAt = new Date(systemTime + expireTime);

        return JWT.create()
                .withPayload(payload) // JWT payload part
                .withExpiresAt(espiersAt) // JWT expiration time
                .withIssuedAt(issuedAt) 
                .withIssuer(issuer) 
                .sign(algorithm);
    }

    public Map<String, Object> convertClaimsToMap(Map<String, Claim> claims) {
        Map<String, Object> result = new HashMap<>();
        for (Map.Entry<String, Claim> entry : claims.entrySet()) {
            result.put(entry.getKey(), entry.getValue().as(Object.class));
        }
        return result;
    }
    
    public Map<String, Object> verifyToken(String token) {
        try {
            DecodedJWT decodedJWT = JWT.require(algorithm)
                    .withIssuer(issuer)
                    .build()
                    .verify(token);
            
            Map<String, Claim> claims = decodedJWT.getClaims();
            return convertClaimsToMap(claims);
        } catch (JWTVerificationException e) {
            // Token Verification Exception
            //e.printStackTrace(); 
            return Collections.emptyMap();
        }
    }

}
