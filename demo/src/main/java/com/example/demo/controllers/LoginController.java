package com.example.demo.controllers;

import javax.management.RuntimeErrorException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Service.LoginService;

import jakarta.persistence.Id;
import jakarta.websocket.server.PathParam;

import com.example.demo.Cities.Cities;
import com.example.demo.Countries.Countries;
import com.example.demo.JPA.LoginRepository;
import com.example.demo.Login.Login; // Ensure this path matches the actual location of the Login class
import com.example.demo.Login.Login.SecurityQuestion;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;



@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/user")
public class LoginController {

    private final LoginRepository loginRepository;

    @Id
    private String username;

   

    private final LoginService loginService;

    @Autowired
    public LoginController(LoginService loginService, LoginRepository loginRepository){
        this.loginService = loginService;
        this.loginRepository = loginRepository;
    }

    
    // get username
@GetMapping("/")
    public List<Login> getAllUsernames(String userName){
        return loginRepository.findAll(); //finding all usernames
    }

@PostMapping("/")
public Login createUsername(@RequestParam String userName) throws Exception {
     return loginService.createUsername(userName);
}


@PutMapping("/username/{username}/")
public Login updateUsername(
        @PathVariable("username") String username,
        @RequestParam String newUsername) throws Exception {
    return loginService.updateUsername(newUsername, username);
}

@PostMapping("/username/{username}/password/")
public Login createPassword(
        @PathVariable("username") String username,
        @RequestParam String newPassword) throws Exception {
    return loginService.createPassword(newPassword,username);
}

@PostMapping("/username/{username}/securityQuestion")
public Login setSecurityResponse(
        @PathVariable("username") String username,
        @RequestParam("securityQuestion") Login.SecurityQuestion securityQuestion,
        @RequestParam("userResponse") String userResponse) {

    return loginService.setSecurityResponse(securityQuestion, userResponse, username);
}

@GetMapping("/username/{username}/securityQuestion")
public Map<String, String> getSecurityQuestion(@PathVariable String username) {
    return loginService.getSecurityQuestion(username);
}

    @GetMapping("/securityQuestion")
    public List<String> getAllSecurityQuestions() {
        // Convert enum values to their readable question text
        return Arrays.stream(SecurityQuestion.values())
                     .map(SecurityQuestion::getQuestionText)
                     .collect(Collectors.toList());
    }



}

