package com.Laboratory.Laboratory.RedisAccess;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.redis.connection.ReactiveRedisConnectionFactory;
import org.springframework.data.redis.connection.RedisPassword;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.core.ReactiveRedisTemplate;
import org.springframework.data.redis.serializer.RedisSerializationContext;


@Configuration
public class RedisConfig {

    @Value("${spring.redis.reactive.host}")
    private String host;

    @Value("${spring.redis.reactive.port}")
    private int port;

    @Value("${spring.redis.reactive.password}")
    private String password;

    @SuppressWarnings("null")
    @Bean
    public LettuceConnectionFactory lettuceConnectionFactory() {
        RedisStandaloneConfiguration redisConfig = new RedisStandaloneConfiguration(host, port);
        redisConfig.setPassword(RedisPassword.of(password));
        
        return new LettuceConnectionFactory(redisConfig);
    }

    @SuppressWarnings("null")
    @Bean
    @Primary
    public ReactiveRedisTemplate<String, String> reactiveRedisTemplate(ReactiveRedisConnectionFactory connectionFactory) {
        return new ReactiveRedisTemplate<>(connectionFactory, RedisSerializationContext.string());
    }
}