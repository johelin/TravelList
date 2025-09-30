package com.example.demo.Cities;

import com.example.demo.Countries.Countries;
import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.*;

@Entity
@Table(name = "cities")
public class Cities {

    @Id
    private String cityName;

    @ManyToOne
    @JsonBackReference
    @JoinColumn(name = "country") // foreign key column
    private Countries country;

    public Cities() {}

    public Cities(Countries countries) {
        this.country = countries;
    }

    public void City(String cityName) {
        this.cityName = cityName;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public Countries getCountry() {
        return country;
    }

    public void setCountry(Countries country) {
        this.country = country;
    }


}
