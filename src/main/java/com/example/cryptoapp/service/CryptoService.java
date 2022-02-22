package com.example.cryptoapp.service;

import com.example.cryptoapp.model.CurrencyDTO;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class CryptoService {

    String baseURL;
    HttpHeaders headers;
    RestTemplate restTemplate;

    public CryptoService (String baseURL, HttpHeaders headers, RestTemplate restTemplate) {
        this.baseURL = baseURL;
        this.headers = headers;
        this.restTemplate = restTemplate;
    }

    public String getCryptocurrency (String cryptocurrency) {
        HttpEntity<String> entity = new HttpEntity<>(headers);
        ResponseEntity<String> response = restTemplate.exchange(baseURL + cryptocurrency, HttpMethod.GET, entity, String.class);
        return response.getBody();
    }
}
