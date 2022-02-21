package com.example.cryptoapp.service;

import com.example.cryptoapp.model.CurrencyDTO;
import org.springframework.stereotype.Service;

@Service
public class CryptoService {

    String baseURL;

    public CryptoService (String baseURL) {
        this.baseURL = baseURL;
    }

    public CurrencyDTO getCryptocurrency (String cryptocurrency) {
        return new CurrencyDTO();
    }
}
