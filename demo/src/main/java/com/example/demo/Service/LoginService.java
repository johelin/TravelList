package com.example.demo.Service;

import javax.management.RuntimeErrorException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Cities.Cities;
import com.example.demo.JPA.LoginRepository;
import com.example.demo.Login.Login;

@Service
public class LoginService{
private final LoginRepository loginRepository;


@Autowired //creates dependency

public LoginService(LoginRepository loginRepository){
    this.loginRepository = loginRepository;
}




//methods
public Login updateUsername(String newUsername, String username) throws Exception{
    // 1. Get existing user
    Login oldUser = loginRepository.findById(username)
            .orElseThrow(() -> new RuntimeException("User not found"));

    // 2. Check if new username already exists
    if (loginRepository.existsById(newUsername)) {
        throw new RuntimeException("Username already exists");
    }

    // 3. Create new user with copied fields
    Login newUser = new Login();
    newUser.setUsername(newUsername);
    
    loginRepository.save(newUser);

    // 4. Delete old user
    loginRepository.delete(oldUser);

    return newUser;


  /* add if more than one user is in DB with the name name, return error and ask to add param to choose which one to remain*/
}


public Login createUsername(String newUsername) throws Exception{
    
    if(loginRepository.existsByUsername(newUsername)){
        throw new RuntimeException("User " + newUsername + " already exists");
    }

String regex = "^((?=[A-Za-z0-9@])(?![_\\\\-]).)*$"; //regex

if(newUsername == null && newUsername.isEmpty()){
throw new IllegalArgumentException("Invalid Username");
 
}

if(newUsername.length() <= 12 && !newUsername.matches(regex)) {//make sure the username is 12 char and no special charaters

throw new RuntimeErrorException(null, "Password is either too long or not using valid characters");
}
     
Login login = new Login();
login.setUsername(newUsername);
loginRepository.save(login);  

return login;
}


public Login createPassword(String newPassword, String username) throws Exception{
    Login User = loginRepository.findById(username)
    .orElseThrow(() -> new RuntimeException("User not found"));



if(newPassword == null || newPassword.isEmpty()){
    throw new IllegalArgumentException("Password is not valid");
}else if(newPassword.length() < 12 ){
    throw new IllegalArgumentException("Password is not long enough");
}else if(loginRepository.existsByPassword(newPassword)){
    throw new RuntimeException("password " + newPassword + " cannot be the one that's saved");
}


User.setPassword(newPassword); // only need to save the password as the user will be identified by the user repo

 

return loginRepository.save(User);
}




}