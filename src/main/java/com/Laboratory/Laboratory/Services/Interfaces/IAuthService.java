package com.Laboratory.Laboratory.Services.Interfaces;

import java.util.Map;

import com.auth0.jwt.interfaces.Claim;

public interface IAuthService {
    
    String generateToken(Map<String, Object> payload, Long expireTime);

    Map<String, Object> convertClaimsToMap(Map<String, Claim> claims);
    Map<String, Object> verifyToken(String token);

    String generateTokenYear(Map<String, Object> payload, Integer expireTime);    
    String generateTokenMonth(Map<String, Object> payload, Integer expireTime);    
    String generateTokenWeek(Map<String, Object> payload, Integer expireTime);    
    String generateTokenDay(Map<String, Object> payload, Integer expireTime);    
    String generateTokenHour(Map<String, Object> payload, Integer expireTime);    
    String generateTokenMinute(Map<String, Object> payload, Integer expireTime);    
}
