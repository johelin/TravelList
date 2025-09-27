package com.example.demo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CountryConnect{
    Map<String, List<String>> countryCities = new HashMap<>();
       public String countryConnectcities(String country, String cities) {
        countryCities.putIfAbsent(country, new ArrayList<>());
        countryCities.get(country).add(cities);
        return cities;
    }
}
