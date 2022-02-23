package com.example.cryptoapp.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CryptoDTO {
    private String name;
    private String tag;
    private Double usdPrice;
    private Double hourPercentChange;
}
