package com.ff.blog.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {

        // cross region visit
        registry.addMapping("/**").allowedOrigins("http://localhost:8081");
//        WebMvcConfigurer.super.addCorsMappings(registry);
    }
}