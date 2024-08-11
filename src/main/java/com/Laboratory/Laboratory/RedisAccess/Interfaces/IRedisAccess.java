package com.Laboratory.Laboratory.RedisAccess.Interfaces;

import java.time.Duration;

import reactor.core.publisher.Mono;

public interface IRedisAccess {
    Mono<Boolean> setKeyValue(String key, String value, Duration expireTime);
    Mono<String> getValueByKey(String key);
    Mono<Boolean> deleteValueByKey(String key);
}