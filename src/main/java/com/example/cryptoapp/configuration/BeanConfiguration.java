package com.example.cryptoapp.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpHeaders;

public class BeanConfiguration {
    @Value("${API_KEY}")
    String apikey;

    @Bean
    HttpHeaders getHeaders () {
        HttpHeaders headers = new HttpHeaders();
        headers.set("X-CMC_PRO_API_KEY", apikey);
        return headers;
    }
}
