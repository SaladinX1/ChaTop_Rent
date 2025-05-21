package com.chatop_rent.chatop.config;

import io.github.cdimascio.dotenv.Dotenv;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class EnvLoader {

    @PostConstruct
    public void loadEnv() {
        Dotenv dotenv = Dotenv.configure()
            .filename(".env")
            .ignoreIfMissing()
            .load();

        dotenv.entries().forEach(entry -> {
            System.setProperty(entry.getKey(), entry.getValue());
        });
    }
}