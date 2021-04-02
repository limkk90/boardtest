package com.myapp;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;

@Configuration
public class WebConfig {

    public void addCorsMappings(CorsRegistry registry){
        registry.addMapping("/api/**").allowCredentials(true).allowedOrigins("http://localhost:3000");

    }
}
