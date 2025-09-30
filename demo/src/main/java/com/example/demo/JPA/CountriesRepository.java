package com.example.demo.JPA;
import com.example.demo.Countries.Countries; 
import org.springframework.data.jpa.repository.JpaRepository;

public interface CountriesRepository extends JpaRepository<Countries, String> {
    
}
