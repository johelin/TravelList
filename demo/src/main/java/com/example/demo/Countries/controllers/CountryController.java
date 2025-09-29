package com.example.demo.Countries.controllers;
import org.springframework.web.bind.annotation.*;
import com.example.demo.Countries.Countries;

import jakarta.websocket.server.PathParam;


@RestController
@RequestMapping("/countries")  // Base path for all endpoints
public class CountryController {
   private Countries newCountry = new Countries();
    // GET all countries (maybe a string, or a list)
    @GetMapping
    public String getCountries() {
    Countries newCountry = new Countries();
    return newCountry.getCountries();

    }

    @PostMapping("/country")
    public String addCountries(@RequestParam String country, @RequestParam String abbreviation) {
        return newCountry.addCountries(country, abbreviation);
    }

    @PutMapping("/abbreviation")
    public String changeAbbreviation(@RequestParam String country, @RequestParam String abbreviation) {
        return newCountry.changeAbbreviation(country, abbreviation);
    }

    @GetMapping("/abbreviation")
    public String getAbbriviation(@RequestParam String country) {
    Countries newAbbriviation = new Countries();
    return newAbbriviation.getAbbriviation();

    }


}
