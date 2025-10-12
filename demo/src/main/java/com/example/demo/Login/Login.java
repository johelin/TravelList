package com.example.demo.Login;

import java.util.HashMap;

import com.example.demo.Countries.Countries;
import com.example.demo.JPA.CitiesRepository;
import com.example.demo.JPA.CountriesRepository;
import com.example.demo.JPA.LoginRepository;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
@Entity
@Table(name = "users")

public class Login {
/* 
    @Id  
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long id;*/
@Id   
@Column(name = "username") 
private String username;
@Column(name = "password")
private String password;

@Enumerated(EnumType.STRING)
@Column(name = "security_question")
private SecurityQuestion securityQuestion;

@Column(name = "security_answer")
private String userResponse;

/* 
    public Login(String user, String username, String password, Enum securityQuestion, LoginRepository loginRepository){
        this.user = user;
        this.username = username;
        this.password = password;
        this.securityQuestion = securityQuestion;
    }*/

    public Login(){}
//getters



public String getUsername(){
    return username;
}

public String getPassword(){
    return password;
}

public SecurityQuestion getSecurityQuestion(){
    return securityQuestion;
}

public String getUserResponse(){
    return userResponse;
}

public void setSecurityQuestion(SecurityQuestion securityQuestion){
    this.securityQuestion = securityQuestion;
}

public void setUserResponse(String userResponse){
    this.userResponse = userResponse;
}

public enum SecurityQuestion {
    HOW_MANY_PETS("How many pets have you had in your life?"),
    MIDDLE_NAME("What's your middle name?"),
    BIRTH_YEAR("What year were you born?");
    
    private final String questionText;

    SecurityQuestion(String questionText) {
        this.questionText = questionText;
    }

    public String getQuestionText() {
        return questionText;
    }

}

public void setUsername(String username){
    this.username = username;
}

public void setPassword(String password){
    this.password =  password;
}
}
