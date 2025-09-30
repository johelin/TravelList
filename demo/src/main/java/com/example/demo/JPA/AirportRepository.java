package com.example.demo.JPA;
import com.example.demo.Airports.Airport; 
import org.springframework.data.jpa.repository.JpaRepository;

public interface AirportRepository extends JpaRepository<Airport, String> {
    
}
