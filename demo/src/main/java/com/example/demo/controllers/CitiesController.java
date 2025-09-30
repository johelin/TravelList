package com.example.demo.controllers;

import org.springframework.web.bind.annotation.*;
import com.example.demo.Cities.Cities;
import com.example.demo.Countries.Countries;
import com.example.demo.JPA.CitiesRepository;
import com.example.demo.JPA.CountriesRepository;

import jakarta.persistence.Id;

import java.util.List;


@RestController
@RequestMapping("/cities")
public class CitiesController {
    @Id
    private long Id;

    private final CitiesRepository citiesRepository;
    private final CountriesRepository countriesRepository;

    // Single constructor that injects both repositories
    public CitiesController(CitiesRepository citiesRepository, CountriesRepository countriesRepository) {
        this.citiesRepository = citiesRepository;
        this.countriesRepository = countriesRepository;
    }

    @GetMapping
    public List<Cities> getAllCities() {
        return citiesRepository.findAll();
    }
/** 
    @GetMapping("")
    public List<Cities> getCity(String countryName) {
        Countries country = countriesRepository.findById(countryName).orElseThrow(() -> new RuntimeException("Country not found"));
       

        return country.getCities();
    }*/
    
    @GetMapping("/city")
    public List<Cities> getSpecifiedCity(@RequestParam String countryName) {
        Countries country = countriesRepository.findById(countryName).orElseThrow(() -> new RuntimeException("Country not found"));
       

        return country.getCities();
    }

    @PostMapping("/city")
    public Cities addCity(@RequestParam String countryName, @RequestParam String cityName) {
        // Lookup country by ID
        Countries country = countriesRepository.findById(countryName)
                .orElseThrow(() -> new RuntimeException("Country not found"));
    
        // Create and set the city
        Cities city = new Cities();
        city.setCityName(cityName);
        city.setCountry(country);
    
        System.out.println(cityName + " was added to " + countryName + " as a city.");
    
        // Save the city and return
        return citiesRepository.save(city);
    }

    @PutMapping("/city")
    public Cities updateCity(@RequestParam String countryName, @RequestParam String cityName) {
        // Lookup country by ID
        Countries country = countriesRepository.findById(countryName)
                .orElseThrow(() -> new RuntimeException("Country not found"));

                if(citiesRepository.existsById(cityName)){
                    throw new RuntimeException("City '" + cityName + "' already exists");
                }
                Cities newCity = new Cities();
                String CurrentCity = newCity.getCityName();
                newCity.setCityName(cityName);


        System.out.println("The current City is " + CurrentCity);
        newCity.setCityName(cityName);
        country.setCountry(countryName);
        citiesRepository.save(newCity);
        countriesRepository.save(country);
    
    
        System.out.println(newCity + " was added to " + country + " as a city.");
        // Save the city and return
        return newCity;
    }
}
