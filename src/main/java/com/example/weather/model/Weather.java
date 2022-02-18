package com.example.weather.model;

public class Weather {

    private String cityName;
    private String zipCode;
    private String country;
    private String weather;

    public Weather(String cityName, String zipCode, String country, String weather) {
        super();
        this.cityName = cityName;
        this.zipCode = zipCode;
        this.country = country;
        this.weather = weather;
    }

    public String getCityName() {
        return cityName;
    }

    public String getZipCode() {
        return zipCode;
    }

    public String getCountry() {
        return country;
    }

    public String getWeather() { return weather; }

    @Override
    public String toString() {
        return "Weather [cityName=" + cityName + ", zipCode=" + zipCode + ", country=" + country + ", weather=" + weather + "]";
    }

}
