package com.example.demo.Service;

import java.util.List;

import javax.management.RuntimeErrorException;
import com.example.demo.JPA.CitiesRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Airports.Airport;
import com.example.demo.Cities.Cities;
import com.example.demo.Countries.Countries;
import com.example.demo.DTO.AirportDTO;
import com.example.demo.JPA.AirportRepository;
import com.example.demo.JPA.CitiesRepository;

import java.util.stream.Collectors;
import java.lang.Character;
@Service
public class AirportService {

private final AirportRepository airportRepository;
private final CitiesRepository cityRepository; 

public AirportService(AirportRepository airportRepository, CitiesRepository cityRepository){
    this.airportRepository = airportRepository;
    this.cityRepository = cityRepository;
    
}

public List<AirportDTO> getAllAirports() {
    List<Airport> airports = airportRepository.findAll();

    // map entity -> DTO
    return airports.stream()
            .map(a -> new AirportDTO(a.getAirportCode(), a.getAirportName(), a.getCityName() != null ? a.getCityName().getCityName() : null  // extract city name
            ))
            .collect(Collectors.toList());
}

public AirportDTO addAirport(String airportName, String airportCode, String city){

    Cities cities = cityRepository.findById(city)
    .orElseThrow(() -> new RuntimeException("City not found: " + city));

    if(airportRepository.existsByAirportName(airportName)){
        throw new RuntimeException("Airport " + airportName + " already exists");
    }

    if(airportName == null && airportName.isEmpty() || airportCode == null && airportCode.isEmpty()){
        throw new IllegalArgumentException("Invalid airportName or Invalid airportCode");
         
        }

        char firstLetter = airportName.charAt(0);
        
        if(Character.isLowerCase(firstLetter)){
            firstLetter = Character.toUpperCase(firstLetter);

        }
            String restofAirportName = airportName.substring(1);
            String finalizedAirportName = firstLetter + restofAirportName;

            airportCode= airportCode.toUpperCase();

            Airport airport = new Airport();
            airport.setAirportName(finalizedAirportName);
            airport.setCity(cities);
            airport.setAirportCode(airportCode);
            airportRepository.save(airport);
            
            // Return DTO directly
            return new AirportDTO(
                airport.getAirportCode(),
                airport.getAirportName(),
                cities.getCityName()
                          // String, not the full Cities entity
);


        }


public List<AirportDTO>  getSpecificAirport(String cityName){
    List<Airport> airports = airportRepository.findByCity_CityName(cityName);

        return airports.stream()
        .map(a -> new AirportDTO(a.getAirportCode(), a.getAirportName(), a.getCityName() != null ? a.getCityName().getCityName() : null  // extract city name
        ))
        .collect(Collectors.toList());

}

}
   




