package com.example.demo.controllers;

import org.springframework.web.bind.annotation.*;
import com.example.demo.Cities.Cities;
import com.example.demo.Countries.Countries;
import com.example.demo.JPA.CitiesRepository;
import com.example.demo.JPA.CountriesRepository;

import jakarta.persistence.Id;

import java.util.HashMap;
import java.util.List;
import java.util.Map;



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

    @PostMapping(value = "/city", produces="application/xml")
    public Cities addCity(@RequestParam String countryName, @RequestParam String cityName, boolean isCapital) {

        Countries country = countriesRepository.findById(countryName)
                .orElseThrow(() -> new RuntimeException("Country not found"));
    
        // Create and set the city
        Cities city = new Cities();
        city.setCityName(cityName);
        city.setCountry(country);

        city.setCapital(isCapital);

        // Set capital name if this city is now the capital
        if (isCapital) {
            city.setCapitalName(cityName);
        } else {
            city.setCapitalName(null);
        }
    
        System.out.println(cityName + " was added to " + countryName + " as a city.");
    
        // Save the city and return
        return citiesRepository.save(city);
    }

    @PutMapping("/city")
    public Cities updateCity(@RequestParam String countryName, @RequestParam String cityName) {
        Countries country = countriesRepository.findById(countryName)
                .orElseThrow(() -> new RuntimeException("Country not found"));
    
        Cities city = citiesRepository.findById(cityName)
                .orElseThrow(() -> new RuntimeException("City not found"));
    
        // Set the new country reference
        city.setCountry(country);
    
        citiesRepository.save(city);
    
        System.out.println(city + " now belongs to " + country);
    
        return city;
    }

    @PostMapping("/city/capital")
    public String setCapitalOfCity(@RequestParam String countryName, @RequestParam String cityName, boolean isCapital) {

        Countries country = countriesRepository.findById(countryName)
        .orElseThrow(() -> new RuntimeException("Country not found"));

        Cities city = citiesRepository.findById(cityName)
        .orElseThrow(() -> new RuntimeException("City not found"));
        
        //Cities newCity = new Cities();

        



    city.setCapital(isCapital);

    // Set capital name if this city is now the capital
    if (isCapital)  {
        city.setCapitalName(cityName);
    } else {
        city.setCapitalName(null);
    }


        citiesRepository.save(city);
        countriesRepository.save(country);

        return "The capital inforamtion has been set!";
    }
    



    @PutMapping("/city/capital")
    public Cities updateCapital(@RequestParam String countryName, @RequestParam String cityName, @RequestParam boolean isCapital) {
        // Lookup country by ID
        Countries country = countriesRepository.findById(countryName)
                .orElseThrow(() -> new RuntimeException("Country not found"));

                Cities city = citiesRepository.findById(cityName)
                .orElseThrow(() -> new RuntimeException("City not found"));


        if(city.getCapital() != null&& city.getCapital()==false ){
             city.setCapital(isCapital);
             citiesRepository.save(city);
             System.out.println(city + " was removed as the capital in " + country);
        }

        city.setCapital(isCapital);


        citiesRepository.save(city);
        countriesRepository.save(country);
        System.out.println(city + " is the capital of " + country);
    
        
        // Save the city and return
        return city;
    }


@GetMapping({"/city/capital/", "/city/capital/"})
    public Map<String, Boolean> getCapitalofCountry(@RequestParam String countryName) { ///countries/city/capital?countryName=Canada&&isCapital=true
    Countries country = countriesRepository.findById(countryName)
    .orElseThrow(() -> new RuntimeException("Country not found"));
    List<Cities> cities = citiesRepository.findByCountry(country);
    
        Map<String, Boolean> response = new HashMap<>();
        for (Cities city : cities) {
            if (city.getCapital() != null && city.getCapital()) {
                response.put(city.getCityName(), true);
            } else {
                response.put(city.getCityName(), false);
            }
        }

return response;
}

@DeleteMapping({"/city","/city"})
public String deleteCity(@RequestParam String countryName, @RequestParam String cityName) {
    Countries country = countriesRepository.findById(countryName).orElseThrow(() -> new RuntimeException("Country not found"));
    Cities city = citiesRepository.findById(cityName)
    .orElseThrow(() -> new RuntimeException("City not found"));

    citiesRepository.deleteById(cityName);

    return "City " + cityName+ " has been deleted";
}}

//get all cities of a country with the respective output of if capital or not