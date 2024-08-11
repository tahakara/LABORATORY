package com.Laboratory.Laboratory.RedisAccess;

import java.time.Duration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.ReactiveRedisTemplate;
import org.springframework.stereotype.Component;

import com.Laboratory.Laboratory.RedisAccess.Interfaces.IRedisAccess;

import reactor.core.publisher.Mono;

@Component
public class RedisData implements IRedisAccess {

    private final ReactiveRedisTemplate<String, String> reactiveRedisTemplate;

    @Autowired
    public RedisData(ReactiveRedisTemplate<String, String> reactiveRedisTemplate) {
        this.reactiveRedisTemplate = reactiveRedisTemplate;
    }

    @SuppressWarnings("null")
    @Override
    public Mono<Boolean> setKeyValue(String key, String value, Duration expireTime) {
        return reactiveRedisTemplate.opsForValue().set(key, value, expireTime);
    }

    @SuppressWarnings("null")
    @Override
    public Mono<String> getValueByKey(String key) {
        return reactiveRedisTemplate.opsForValue().get(key);
    }

    @SuppressWarnings("null")
    @Override 
    public Mono<Boolean> deleteValueByKey(String key) {
        return reactiveRedisTemplate.opsForValue().delete(key);
    }
}