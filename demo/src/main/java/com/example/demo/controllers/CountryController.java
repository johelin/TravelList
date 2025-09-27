package com.example.demo.controllers;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.City;
import com.example.demo.Country;
import com.example.demo.CountryLookup;

@RestController          // Combines @Controller + @ResponseBody
@RequestMapping("/")    // Base path for this controller
public class CountryController {

    @GetMapping(value = "/countries")          
    public String getCountries() {
        CountryLookup lookup = new CountryLookup(); // Create instance
        return lookup.DestinationAbreviation();
}
/** 
//Get country based on id which is the name
@GetMapping(value = "/countries/{id}")          
public String getCountry(@RequestBody Country country) {
    //user enters country based on key value
    CountryLookup lookup = new CountryLookup();
    return lookup.specifiedCountry();
     // Create instance
    
}*/
}

//see code how xml and jason responses are handeled.