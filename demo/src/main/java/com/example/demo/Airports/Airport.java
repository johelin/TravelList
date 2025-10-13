package com.example.demo.Airports;


import com.example.demo.Cities.Cities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "airports")
public class Airport{

    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // auto-generate
    private Long id;

    private String airportCode; // e.g. "ARN"
    private String airportName;


    @ManyToOne
    @JoinColumn(name = "city_name") // foreign key column in airports table
    private Cities city;

    public Airport() {}

    public Airport(String airportCode, String airportName, Cities city) {
        this.airportCode = airportCode;
        this.airportName = airportName;
        this.city = city;
    }

    // Getters and setters
    public String getAirportCode() { 
        return airportCode; 
    }
    public void setAirportCode(String airportCode) { 
        this.airportCode = airportCode; }

    public String getAirportName() { return airportName; }

    public void setAirportName(String airportName) { this.airportName = airportName; }

    public Cities getCityName() { return city; }

    public void setCity(Cities city) {
        this.city = city;
    }

    
}
