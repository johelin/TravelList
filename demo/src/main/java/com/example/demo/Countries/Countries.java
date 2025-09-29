package com.example.demo.Countries;

import java.util.HashMap;

import com.example.demo.Countries.Database.CountriesDatabase;

public class Countries {



    private static HashMap<String, String> countryMap = CountriesDatabase.loadCountries();

    public String addCountries(String Newcountry, String Newabbriviation){
        String country = countryMap.put(Newcountry, Newabbriviation); //sets the values
        CountriesDatabase.saveCountry(Newcountry, Newabbriviation); // Save to D
        System.out.println("Your country has been added: "+getCountries());
        return country;
     
    }


public String getCountries(){
    return countryMap.keySet().toString(); //gets all keys of the map
}

public String getAbbriviation(){
    return countryMap.values().toString(); //gets all values of the map
}

public String changeAbbreviation(String country,String newAbbreviation){
return countryMap.replace(country, newAbbreviation);
}
public static void main(String[] args) {

}
}


