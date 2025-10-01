package com.example.demo.JPA;
import com.example.demo.Cities.Cities;
import com.example.demo.Countries.Countries;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CitiesRepository extends JpaRepository<Cities, String> {
    List<Cities> findByCountry(Countries country);
}
