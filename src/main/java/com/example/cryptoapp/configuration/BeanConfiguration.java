package com.example.cryptoapp.configuration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.web.client.RestTemplate;

@Configuration
public class BeanConfiguration {

    @Bean
    HttpHeaders getHeaders () {
        HttpHeaders headers = new HttpHeaders();
        headers.set("X-CMC_PRO_API_KEY", System.getenv("API_KEY"));
        return headers;
    }

    @Bean
    String getBaseUrl () {
        return "https://pro-api.coinmarketcap.com/v2/cryptocurrency/quotes/latest?slug=";
    }

    @Bean
    RestTemplate getRestTemplate () {
        return new RestTemplate();
    }
}
