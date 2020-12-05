package com.yan.shanshan.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfig implements WebMvcConfigurer {
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**").allowedOrigins("http://121.37.255.20:8082").allowedMethods("OPTIONS", "GET", "POST", "DELETE", "PUT").allowCredentials(true);
    }
}
