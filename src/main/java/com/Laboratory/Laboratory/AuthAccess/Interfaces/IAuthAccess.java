package com.Laboratory.Laboratory.AuthAccess.Interfaces;

import java.util.Map;

import com.auth0.jwt.interfaces.Claim;

public interface IAuthAccess {

    String generateToken(Map<String, Object> payload, Long expireTime);

    Map<String, Object> convertClaimsToMap(Map<String, Claim> claims);
    Map<String, Object> verifyToken(String token);
}
