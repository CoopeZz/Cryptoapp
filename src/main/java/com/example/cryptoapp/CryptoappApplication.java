package com.example.cryptoapp;
import com.example.cryptoapp.service.CryptoService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;

import java.util.Timer;

@SpringBootApplication(scanBasePackages = "com.example")
@Component
public class CryptoappApplication implements CommandLineRunner {

    CryptoService cryptoService;

    public CryptoappApplication (CryptoService cryptoService){
        this.cryptoService = cryptoService;
    }

    public static void main(String[] args) {
        SpringApplication.run(CryptoappApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
    new Timer().schedule(cryptoService, 0, 60000);
    }
}
