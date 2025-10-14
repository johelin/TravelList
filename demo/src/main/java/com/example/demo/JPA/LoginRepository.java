package com.example.demo.JPA;
import com.example.demo.Login.Login;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface LoginRepository extends JpaRepository<Login, String> {
    Optional<Login> findByUsername(String username);
    boolean existsByUsername(String username);
    boolean existsByPassword(String password);
        @Query("SELECT DISTINCT l.securityQuestion FROM Login l")
    List<String> findAllSecurityQuestions();

}
