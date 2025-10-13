package com.example.demo.DTO;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "Airport")
@XmlAccessorType(XmlAccessType.FIELD)
public class AirportDTO {

    @XmlElement
    private String airportCode; // e.g. "ARN"

    @XmlElement
    private String airportName;

    @XmlElement
    private String cityName;


    public AirportDTO() {} //defualt constructor

    public AirportDTO(String airportCode, String airportName, String cityName) {
        this.airportCode = airportCode;
        this.airportName = airportName;
        this.cityName = cityName;
    }

    // Getters and setters
    public String getAirportCode() {return airportCode; 
    }
    public void setAirportCode(String airportCode) { this.airportCode = airportCode; }

    public String getAirportName() { return airportName; }

    public void setAirportName(String airportName) { this.airportName = airportName; }

    public String getCityName() { return cityName; }
    public void setCityName(String cityName) { this.cityName = cityName; }

    
}


