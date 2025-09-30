package com.example.demo.Airports;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "airports")
public class Airport{

    @Id
    private String AirportCode; // e.g. "ARN"
    private String AirportName;


    public Airport() {}

    public Airport(String AirportCode, String AirportName) {
        this.AirportCode = AirportCode;
        this.AirportName = AirportName;
    }

    // Getters and setters
    public String getAirportCode() { 
        return AirportCode; 
    }
    public void setAirportCode(String AirportCode) { 
        this.AirportCode = AirportCode; }

    public String getAirportName() { return AirportName; }

    public void setAirportName(String AirportName) { this.AirportName = AirportName; }

    
}
