package com.example.demo;

public class City {
    public String cityName;
    private boolean capital;
    private String capitalName;

    public String getCityName(){
        return cityName;
    }

    public void setCityName(String NewcityName){
        cityName = NewcityName;
    }

    public Boolean isCapital(){
        return capital;
    }


    public String getCapitalName(){
        return "CAPITAL";
    }

    public void setCapitalName(String NewcapitalName){
        capitalName =  NewcapitalName;
    }


}
