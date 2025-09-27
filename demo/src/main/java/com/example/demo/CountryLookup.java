package com.example.demo;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.ResponseBody;

import jakarta.xml.bind.annotation.XmlRootElement;
@XmlRootElement
public class CountryLookup {

    private static final String CSV_FILE = "/Users/elinjohansson/Desktop/TravelList/demo/src/main/java/com/example/demo/data.csv";
    private Map<String, String> countryMap = new HashMap<>();

    public CountryLookup() {
        loadCsv();
    }

    private void loadCsv() {
        try (BufferedReader br = new BufferedReader(new FileReader(CSV_FILE))) {
            String line;
            boolean firstLine = true;
            while ((line = br.readLine()) != null) {
                if (firstLine) {
                    firstLine = false;
                    continue;
                }
                String[] values = line.split(",");
                if (values.length >= 2) {
                    countryMap.put(values[0].trim(), values[1].trim());
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
@ResponseBody
    public String DestinationAbreviation() {
        return countryMap.toString();
    }

    @ResponseBody
    public String specifiedCountry() { // return with the specified information of that country
        //get city ingormation of that country
        // get type of city
        //get is capital

        String specifiedCountry = countryMap.toString();
       
        specifiedCountry = countryMap.values(<id>);

        HashMap<String, String> capitals = new HashMap<>();
        City citydata = new City(); 
        if(citydata.isCapital()){

            String CountryCity = citydata.getCityName(); // this is void so let's think about it differently

            Boolean isTheCityTheCapital = citydata.isCapital(); //if the city is a capital city, print it
            if(isTheCityTheCapital){
                return citydata.getCapitalName();
            }

            capitals.put("Country", CountryConnect.countryConnectcities(specifiedCountry, CountryConnect.cities)); // Country coming from the input of this call
        }
        return countryMap.get(citydata.getCityName()); // get city name

    }
    public static void main(String[] args) {
    


    }
}
