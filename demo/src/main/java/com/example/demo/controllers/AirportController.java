package com.example.demo.controllers;

import org.springframework.web.bind.annotation.*;
import com.example.demo.Airports.Airport;
import com.example.demo.Countries.Countries;
import com.example.demo.DTO.AirportDTO;
import com.example.demo.JPA.AirportRepository;
import com.example.demo.Service.AirportService;

import java.util.List;
import java.util.stream.Collectors;


@RestController
@RequestMapping("/airport")
public class AirportController {

private final AirportRepository airportRepository;
private final AirportService airportService;

    public AirportController(AirportRepository airportRepository, AirportService airportService) {
        this.airportRepository = airportRepository;
        this.airportService = airportService; 
    }

@GetMapping("") // endpoint URL
public List<AirportDTO> getAllAirports() {
    List<Airport> airports = airportRepository.findAll();

    // map entity -> DTO
    return airports.stream()
            .map(a -> new AirportDTO(a.getAirportCode(), a.getAirportName(), a.getCityName() != null ? a.getCityName().getCityName() : null  // extract city name
            ))
            .collect(Collectors.toList());}

@PostMapping("/city/{city}/airportName/{airportName}/airCode/{airportCode}")
public AirportDTO postNewAirport(@PathVariable String airportName, @PathVariable String airportCode,@PathVariable String city) {

    return airportService.addAirport(airportName, airportCode, city);
}

@GetMapping("/city/{city}")
    public List<AirportDTO> getSpecificAirport(@PathVariable String city) {
    return airportService.getSpecificAirport(city);
}
    }