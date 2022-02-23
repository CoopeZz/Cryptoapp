package com.example.cryptoapp.service;

import com.example.cryptoapp.model.CryptoDTO;
import com.example.cryptoapp.model.response.Base;
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

    public CryptoDTO createCryptoDTO (Base base) {
        CryptoDTO cryptoDTO = new CryptoDTO();
        cryptoDTO.setName(base.data.id.name);
        cryptoDTO.setTag(base.data.id.symbol);
        cryptoDTO.setUsdPrice(base.data.id.quote.usd.price);
        cryptoDTO.setHourPercentChange(base.data.id.quote.usd.percentChange1h);
        return cryptoDTO;
    }

    public CryptoDTO getCryptocurrency (String cryptocurrency) {
        HttpEntity<String> entity = new HttpEntity<>(headers);
        ResponseEntity<Base> response = restTemplate.exchange(baseURL + cryptocurrency, HttpMethod.GET, entity, Base.class);
        return createCryptoDTO(response.getBody());
    }
}
