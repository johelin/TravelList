package com.example.demo.JPA;
import com.example.demo.Airports.Airport;
import com.example.demo.Cities.Cities;
import com.example.demo.DTO.AirportDTO;
import com.example.demo.Login.Login;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AirportRepository extends JpaRepository<Airport, Long> {
       // List<AirportDTO> findbyAiport(Airport airport);
       boolean existsByAirportName(String airportName); // example if you want to check existence
        Optional<Airport> findByAirportName(String airportName);
        List<Airport> findByCity_CityName(String cityName);
  
}
