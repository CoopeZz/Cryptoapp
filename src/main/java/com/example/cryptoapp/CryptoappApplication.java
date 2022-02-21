package com.example.cryptoapp;

import com.example.cryptoapp.model.CurrencyDTO;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class CryptoappApplication implements Runnable {

    @Value("${API_KEY}")
    private static String apiKey;
    private static final RestTemplate restTemplate = new RestTemplate();

    public static void main(String[] args) {
        SpringApplication.run(CryptoappApplication.class, args);
    }

    @Override
    public void run() {

    }
}
