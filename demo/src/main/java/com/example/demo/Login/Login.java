package com.example.demo.Login;

import com.example.demo.Countries.Countries;
import com.example.demo.JPA.CitiesRepository;
import com.example.demo.JPA.CountriesRepository;
import com.example.demo.JPA.LoginRepository;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
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

@Column(name = "security_question")
private Enum securityQuestion;

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

public Enum getSecurityQuestion(){
    return securityQuestion;
}

/*public enum securityQuestion{ //look at how filetypw DB is set up
   1 = "How many pets have you had in your life?" ;
   2 = "How many pets have you had in your life?" ;}
*/

//setters


public void setUsername(String username){
    this.username = username;
}

public void setPassword(String password){
    this.password =  password;
}

public void setSecurityQuestion(Enum securityQuestion){
    this.securityQuestion = securityQuestion;
}

//methods


// set create user

//set username

//set password

// set security question


}
