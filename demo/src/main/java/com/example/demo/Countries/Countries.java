package com.example.demo.Countries;

import com.example.demo.Cities.Cities;
import com.example.demo.JPA.CitiesRepository;
import com.example.demo.JPA.CountriesRepository;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.*;
import java.util.List;
import java.util.HashMap;

@Entity
@Table(name = "countries")

public class Countries {

    @Id
    private String country; // Country name as primary key

    private String abbreviation;

    @OneToMany(mappedBy = "country", cascade = CascadeType.ALL, fetch = FetchType.LAZY) // this is what we saw in class for data structures
    @JsonManagedReference
    private List<Cities> cities;

        // Getters & setters
        public String getCountry() { return country; }
        public void setCountry(String country) { this.country = country; }
    
        public String getAbbreviation() { return abbreviation; }
        public void setAbbreviation(String abbreviation) { this.abbreviation = abbreviation; }
    
        public List<Cities> getCities() { return cities; }
        public void setCities(List<Cities> cities) { this.cities = cities; }

  
    }

