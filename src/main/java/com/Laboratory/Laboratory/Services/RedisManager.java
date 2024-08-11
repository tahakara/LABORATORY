package com.Laboratory.Laboratory.Services;

import reactor.core.publisher.Mono;

import java.time.Duration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Laboratory.Laboratory.RedisAccess.Interfaces.IRedisAccess;
import com.Laboratory.Laboratory.Services.Interfaces.IRedisService;

@Service
public class RedisManager implements IRedisService {

    private IRedisAccess RedisAccess;

    @Autowired
    public RedisManager(IRedisAccess RedisAccess) {
        this.RedisAccess = RedisAccess;
    }

    @Override
    public Mono<Boolean> setKeyValue(String key, String value, Duration expireTime) {
        return this.RedisAccess.setKeyValue(key, value, expireTime);
    }
    @Override
    public Mono<String> getValueByKey(String key) {
        return this.RedisAccess.getValueByKey(key);
    }
    @Override
    public Mono<Boolean> deleteValueByKey(String key) {
        return this.RedisAccess.deleteValueByKey(key);
    }


    @Override
    public Mono<String> getAdminValueByKey(String key) {
        System.out.println("admin@"+key);
        return this.getValueByKey("admin@"+key);
    }
    @Override
    public Mono<String> getLaborantValueByKey(String key) {
        return this.getValueByKey("laborant@" + key);
    }
    @Override
    public Mono<String> getUserValueByKey(String key) {
        return this.getValueByKey("user@" + key);
    }

    @Override
    public Mono<Boolean> deleteAdminValueByKey(String key) {
        return this.deleteValueByKey("admin@" + key);
    }
    @Override
    public Mono<Boolean> deleteLaborantValueByKey(String key) {
        return this.deleteValueByKey("laborant@" + key);
    }
    @Override
    public Mono<Boolean> deleteUserValueByKey(String key) {
        return this.deleteValueByKey("user@" + key);
    }



    // ----------*********----------
    //          Time Limitation
    // ----------*********----------

    @Override
    public Mono<Boolean> setKeyValueUnlimited(String key, String value) {
        return this.setKeyValue(key, value, Duration.ofSeconds(0));
    }
    @Override
    public Mono<Boolean> setKeyValueYear(String key, String value, Integer year) {
        Duration yearInSeconds = Duration.ofSeconds(year * 365 * 24 * 60 * 60) ;
        return this.setKeyValue(key, value, yearInSeconds);
    }
    @Override
    public Mono<Boolean> setKeyValueMonth(String key, String value, Integer month) {
        Duration monthInSeconds = Duration.ofSeconds(month * 30 * 24 * 60 * 60);
        return this.setKeyValue(key, value, monthInSeconds);
    }
    @Override
    public Mono<Boolean> setKeyValueWeek(String key, String value, Integer week) {
        Duration weekInSeconds = Duration.ofSeconds(week * 7 * 24 * 60 * 60);
        return this.setKeyValue(key, value, weekInSeconds);
    }
    @Override
    public Mono<Boolean> setKeyValueDay(String key, String value, Integer day) {
        Duration dayInSeconds = Duration.ofSeconds(day * 24 * 60 * 60);
        return this.setKeyValue(key, value, dayInSeconds);
    }
    @Override
    public Mono<Boolean> setKeyValueHour(String key, String value, Integer hour) {
        Duration hourInSeconds = Duration.ofSeconds(hour * 60 * 60);
        return this.setKeyValue(key, value, hourInSeconds);
    }
    @Override
    public Mono<Boolean> setKeyValueMinute(String key, String value, Integer minute) {
        Duration minuteInSeconds = Duration.ofSeconds(minute * 60);
        return this.setKeyValue(key, value, minuteInSeconds);
    }


    // ----------*********----------
    //          Admin Key Set
    // ----------*********----------

    @Override
    public Mono<Boolean> setAdminKeyValueUnlimited(String key, String value) {
        String newkey = "admin@" + key;
        return this.setKeyValueUnlimited(newkey, value);
        // return this.RedisAccess.setKeyValueUnlimited(newkey, value);
    }
    @Override
    public Mono<Boolean> setAdminKeyValueYear(String key, String value, Integer year) {
        String newkey = "admin@" + key;
        return this.setKeyValueYear(newkey, value, year);
    }
    @Override
    public Mono<Boolean> setAdminKeyValueMonth(String key, String value, Integer month) {
        String newkey = "admin@" + key;
        return this.setKeyValueMonth(newkey, value, month);
    }
    @Override
    public Mono<Boolean> setAdminKeyValueWeek(String key, String value, Integer week) {
        String newkey = "admin@" + key;
        return this.setKeyValueWeek(newkey, value, week);
    }
    @Override
    public Mono<Boolean> setAdminKeyValueDay(String key, String value, Integer day) {
        String newkey = "admin@" + key;
        return this.setKeyValueDay(newkey, value, day);
    }
    @Override
    public Mono<Boolean> setAdminKeyValueHour(String key, String value, Integer hour) {
        String newkey = "admin@" + key;
        return this.setKeyValueHour(newkey, value, hour);
    }
    @Override
    public Mono<Boolean> setAdminKeyValueMinute(String key, String value, Integer minute) {
        String newkey = "admin@" + key;
        return this.setKeyValueMinute(newkey, value, minute);
    }


    // ----------*********----------
    //          Laborant Key Set
    // ----------*********----------

    @Override
    public Mono<Boolean> setLaborantKeyValueUnlimited(String key, String value) {
        String newkey = "laborant@" + key;
        return this.setKeyValueUnlimited(newkey, value);
        // return this.RedisAccess.setKeyValueUnlimited(newkey, value);
    }
    @Override
    public Mono<Boolean> setLaborantKeyValueYear(String key, String value, Integer year) {
        String newkey = "laborant@" + key;
        return this.setKeyValueYear(newkey, value, year);
    }
    @Override
    public Mono<Boolean> setLaborantKeyValueMonth(String key, String value, Integer month) {
        String newkey = "laborant@" + key;
        return this.setKeyValueMonth(newkey, value, month);
    }
    @Override
    public Mono<Boolean> setLaborantKeyValueWeek(String key, String value, Integer week) {
        String newkey = "laborant@" + key;
        return this.setKeyValueWeek(newkey, value, week);
    }
    @Override
    public Mono<Boolean> setLaborantKeyValueDay(String key, String value, Integer day) {
        String newkey = "laborant@" + key;
        return this.setKeyValueDay(newkey, value, day);
    }
    @Override
    public Mono<Boolean> setLaborantKeyValueHour(String key, String value, Integer hour) {
        String newkey = "laborant@" + key;
        return this.setKeyValueHour(newkey, value, hour);
    }
    @Override
    public Mono<Boolean> setLaborantKeyValueMinute(String key, String value, Integer minute) {
        String newkey = "laborant@" + key;
        return this.setKeyValueMinute(newkey, value, minute);
    }


    // ----------*********----------
    //          User Key Set
    // ----------*********----------

    @Override
    public Mono<Boolean> setUserKeyValueUnlimited(String key, String value) {
        String newkey = "user@" + key;
        return this.setKeyValueUnlimited(newkey, value);
        // return this.RedisAccess.setKeyValueUnlimited(newkey, value);
    }
    @Override
    public Mono<Boolean> setUserKeyValueYear(String key, String value, Integer year) {
        String newkey = "user@" + key;
        return this.setKeyValueYear(newkey, value, year);
    }
    @Override
    public Mono<Boolean> setUserKeyValueMonth(String key, String value, Integer month) {
        String newkey = "user@" + key;
        return this.setKeyValueMonth(newkey, value, month);
    }
    @Override
    public Mono<Boolean> setUserKeyValueWeek(String key, String value, Integer week) {
        String newkey = "user@" + key;
        return this.setKeyValueWeek(newkey, value, week);
    }
    @Override
    public Mono<Boolean> setUserKeyValueDay(String key, String value, Integer day) {
        String newkey = "user@" + key;
        return this.setKeyValueDay(newkey, value, day);
    }
    @Override
    public Mono<Boolean> setUserKeyValueHour(String key, String value, Integer hour) {
        String newkey = "user@" + key;
        return this.setKeyValueHour(newkey, value, hour);
    }
    @Override
    public Mono<Boolean> setUserKeyValueMinute(String key, String value, Integer minute) {
        String newkey = "user@" + key;
        return this.setKeyValueMinute(newkey, value, minute);
    }
    
}