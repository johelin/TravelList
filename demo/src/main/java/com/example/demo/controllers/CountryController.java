package com.example.demo.controllers;

import org.springframework.web.bind.annotation.*;

import com.example.demo.Cities.Cities;
import com.example.demo.Countries.Countries;
import com.example.demo.JPA.CitiesRepository;
import com.example.demo.JPA.CountriesRepository;

import java.util.List;

@RestController
@RequestMapping("/countries")
public class CountryController {

    private final CountriesRepository countriesRepository;
    private final CitiesRepository citiesRepository;
    
    public CountryController(CitiesRepository citiesRepository, CountriesRepository countriesRepository) {
        this.citiesRepository = citiesRepository;
        this.countriesRepository = countriesRepository;
    }

    // GET all countries
    @GetMapping
    public List<Countries> getCountries() {
        List<Countries> countries = countriesRepository.findAll();
        countries.forEach(country -> country.getCities()
            .forEach(city -> System.out.println(city.getCityName())));
        return countries;
    }

    // POST a new country
    @PostMapping("/country")
    public Countries addCountry(@RequestParam String country, @RequestParam String abbreviation) {

        if(countriesRepository.existsById(country)){
            throw new RuntimeException("Country '" + country + "' already exists");
        }
            Countries newCountry = new Countries();
            newCountry.setCountry(country);
            newCountry.setAbbreviation(abbreviation);
            


        return countriesRepository.save(newCountry);
        
    }

    // PUT: change abbreviation
    @PutMapping("/abbreviation")
    public Countries changeAbbreviation(@RequestParam String country, @RequestParam String abbreviation) {

            Countries countryName = countriesRepository.findById(country)
                    .orElseThrow(() -> new RuntimeException("Country not found"));

                   String abbreviationCurrent = countryName.getAbbreviation();

                    if(abbreviationCurrent != null && !abbreviationCurrent.isEmpty()){
                        System.out.println("The current Abbreviation is " + abbreviationCurrent);
                        countryName.setAbbreviation(abbreviation);
                        countriesRepository.save(countryName);
                    }
                    countryName.setAbbreviation(abbreviation);
                    System.out.println("There is no previous Abbreviation set " + abbreviationCurrent + "The Abbreveation has now been set.");
                    countriesRepository.save(countryName);
    
            return countryName;
    
    }

    // GET abbreviation for a country
    @GetMapping("/abbreviation")
    public String getAbbreviation(@RequestParam String country) {
        Countries existingCountry = countriesRepository.findById(country)
                .orElseThrow(() -> new RuntimeException("Country not found"));

        return existingCountry.getAbbreviation();
    }
}
