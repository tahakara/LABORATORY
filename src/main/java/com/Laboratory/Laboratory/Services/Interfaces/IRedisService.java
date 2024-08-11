package com.Laboratory.Laboratory.Services.Interfaces;

import java.time.Duration;

import reactor.core.publisher.Mono;

public interface IRedisService {
    Mono<Boolean> setKeyValue(String key, String value, Duration expireTime);
    Mono<String> getValueByKey(String key);
    Mono<Boolean> deleteValueByKey(String key);

    Mono<Boolean> setKeyValueUnlimited(String key, String value);
    Mono<Boolean> setKeyValueYear(String key, String value, Integer year);
    Mono<Boolean> setKeyValueMonth(String key, String value, Integer month);
    Mono<Boolean> setKeyValueWeek(String key, String value, Integer week);
    Mono<Boolean> setKeyValueDay(String key, String value, Integer day);
    Mono<Boolean> setKeyValueHour(String key, String value, Integer hour);
    Mono<Boolean> setKeyValueMinute(String key, String value, Integer minute);


    Mono<String> getAdminValueByKey(String key);
    Mono<String> getLaborantValueByKey(String key);
    Mono<String> getUserValueByKey(String key);

    Mono<Boolean> deleteAdminValueByKey(String key);
    Mono<Boolean> deleteLaborantValueByKey(String key);
    Mono<Boolean> deleteUserValueByKey(String key);

    
    // ----------*********----------
    //          Admin Key Set
    // ----------*********----------

    Mono<Boolean> setAdminKeyValueUnlimited(String key, String value);
    Mono<Boolean> setAdminKeyValueYear(String key, String value, Integer year);
    Mono<Boolean> setAdminKeyValueMonth(String key, String value, Integer month);
    Mono<Boolean> setAdminKeyValueWeek(String key, String value, Integer week);
    Mono<Boolean> setAdminKeyValueDay(String key, String value, Integer day);
    Mono<Boolean> setAdminKeyValueHour(String key, String value, Integer hour);
    Mono<Boolean> setAdminKeyValueMinute(String key, String value, Integer minute);
    
    // ----------*********----------
    //          Laborant Key Set
    // ----------*********----------

    Mono<Boolean> setLaborantKeyValueUnlimited(String key, String value);
    Mono<Boolean> setLaborantKeyValueYear(String key, String value, Integer year);
    Mono<Boolean> setLaborantKeyValueMonth(String key, String value, Integer month);
    Mono<Boolean> setLaborantKeyValueWeek(String key, String value, Integer week);
    Mono<Boolean> setLaborantKeyValueDay(String key, String value, Integer day);
    Mono<Boolean> setLaborantKeyValueHour(String key, String value, Integer hour);
    Mono<Boolean> setLaborantKeyValueMinute(String key, String value, Integer minute);

    // ----------*********----------
    //          User Key Set
    // ----------*********----------

    Mono<Boolean> setUserKeyValueUnlimited(String key, String value);
    Mono<Boolean> setUserKeyValueYear(String key, String value, Integer year);
    Mono<Boolean> setUserKeyValueMonth(String key, String value, Integer month);
    Mono<Boolean> setUserKeyValueWeek(String key, String value, Integer week);
    Mono<Boolean> setUserKeyValueDay(String key, String value, Integer day);
    Mono<Boolean> setUserKeyValueHour(String key, String value, Integer hour);
    Mono<Boolean> setUserKeyValueMinute(String key, String value, Integer minute);
    
}

