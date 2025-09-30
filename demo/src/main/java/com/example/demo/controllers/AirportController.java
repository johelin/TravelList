package com.example.demo.controllers;

import org.springframework.web.bind.annotation.*;
import com.example.demo.Airports.Airport;
import com.example.demo.JPA.AirportRepository;

import java.util.List;

@RestController
@RequestMapping("/airports")
public class AirportController {

    private final AirportRepository airportRepository;

    public AirportController(AirportRepository airportRepository) {
        this.airportRepository = airportRepository;
    }

    @GetMapping
    public List<Airport> getAllAirports() {
        return airportRepository.findAll();
    }



}
