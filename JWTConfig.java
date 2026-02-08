package com.example.GM.Publication.config;

import org.springframework.context.annotation.Configuration;

@Configuration
public class JWTConfig {

    public static final String SECRET_KEY =
            "mySecretKeymySecretKeymySecretKeymySecretKey";

    public static final long EXPIRATION_TIME = 24 * 60 * 60 * 1000; // 1 day

    public static final String TOKEN_PREFIX = "Bearer ";
    public static final String HEADER_STRING = "Authorization";


}
