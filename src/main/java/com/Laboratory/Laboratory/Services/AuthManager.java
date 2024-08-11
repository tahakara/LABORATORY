package com.Laboratory.Laboratory.Services;

import java.util.Map;

import org.springframework.stereotype.Service;

import com.Laboratory.Laboratory.AuthAccess.Interfaces.IAuthAccess;
import com.Laboratory.Laboratory.Services.Interfaces.IAuthService;
import com.auth0.jwt.interfaces.Claim;

@Service
public class AuthManager implements IAuthService {
    
    private IAuthAccess AuthAccess;
    
    public AuthManager(IAuthAccess AuthAccess) {
        this.AuthAccess = AuthAccess;
    }

    @Override
    public String generateToken(Map<String, Object> payload, Long expireTime) {
        return this.AuthAccess.generateToken(payload, expireTime);
    }
    
    @Override
    public Map<String, Object> convertClaimsToMap(Map<String, Claim> claims) {
        return this.AuthAccess.convertClaimsToMap(claims);
    }

    @Override
    public Map<String, Object> verifyToken(String token) {
        return this.AuthAccess.verifyToken(token);
    }

    @Override
    public String generateTokenYear(Map<String, Object> payload, Integer year) {
        long yearInMillis = year * 365L * 24 * 60 * 60 * 1000L; 
        return generateToken(payload, yearInMillis);
    }
    @Override
    public String generateTokenMonth(Map<String, Object> payload, Integer month) {
        long monthInMillis = month * 30L * 24 * 60 * 60 * 1000L;
        return this.generateToken(payload, monthInMillis);
    }
    @Override
    public String generateTokenWeek(Map<String, Object> payload, Integer week) {
        long weekInMillis = week * 7L * 24 * 60 * 60 * 1000L;
        return this.generateToken(payload, weekInMillis);
    }
    @Override
    public String generateTokenDay(Map<String, Object> payload, Integer day) {
        long dayInMillis = day * 24L * 60 * 60 * 1000L;
        return this.generateToken(payload, dayInMillis);
    }
    @Override
    public String generateTokenHour(Map<String, Object> payload, Integer hour) {
        long hourInMillis = hour * 60L * 60 * 1000L;
        return this.generateToken(payload, hourInMillis);
    }
    @Override
    public String generateTokenMinute(Map<String, Object> payload, Integer minute) {
        long minuteInMillis = minute * 60L * 1000L;
        return this.generateToken(payload, minuteInMillis);
    }
}
