
package com.example.cryptoapp.model.response;

import com.fasterxml.jackson.annotation.*;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Data {

    @JsonAlias({"1", "1027", "825", "1839", "3408", "52", "2010", "5426", "4172", "5805", "4687", "74", "6636", "5994", "3794", "1975", "1958", "4030", "1966", "512", "328", "3945", "5647", "131"})
    public Id id;
}

