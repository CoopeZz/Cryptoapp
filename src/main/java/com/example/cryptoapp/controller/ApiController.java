package com.example.cryptoapp.controller;

import com.example.cryptoapp.model.CurrencyDTO;
import com.example.cryptoapp.service.CryptoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Locale;

@RestController
public class ApiController {
    CryptoService cryptoService;

    public ApiController (CryptoService cryptoService) {
        this.cryptoService = cryptoService;
    }

    @GetMapping("{cryptocurrency}")
    ResponseEntity<CurrencyDTO> getCryptocurrency (@PathVariable ("cryptocurrency") String cryptocurrency) {
        cryptocurrency = cryptocurrency.toLowerCase(Locale.ROOT);
        CurrencyDTO currencyDTO = cryptoService.getCryptocurrency(cryptocurrency);
        return ResponseEntity.status(HttpStatus.OK).body(currencyDTO);
    }
}
