package com.example.demo.JPA;
import com.example.demo.Cities.Cities; 
import org.springframework.data.jpa.repository.JpaRepository;

public interface CitiesRepository extends JpaRepository<Cities, String> {
    
}
