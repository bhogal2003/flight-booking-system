package com.example.bookingservice.config;

import org.springframework.context.annotation.Bean;
import feign.Logger;

public class FeignConfig {
    @Bean
    public Logger.Level feignLoggerLevel() {
        return Logger.Level.FULL;
    }
}
