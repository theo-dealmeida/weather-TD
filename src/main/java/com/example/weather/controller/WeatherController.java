package com.example.weather.controller;

import com.example.weather.model.Weather;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class WeatherController {

    List<Weather> weathersList = new ArrayList<>();
    {
        weathersList.add(new Weather("Frejus", "83600", "France", "Il fait beau. grand soleil"));
        weathersList.add(new Weather("Mougins", "06250", "France", "Il fait beau. grand soleil"));
        weathersList.add(new Weather("Clermont-Ferrand", "63000", "France", "Il pleut"));
        weathersList.add(new Weather("Rome", "04320", "Italie", "Il pleut"));
        weathersList.add(new Weather("Tokyo", "019432", "Japon", "Un peu de nuage"));
    }

    @RequestMapping("/")
    public List<Weather> getWeathers() {
        return weathersList;
    }

    @RequestMapping("/getWeatherByCity/{cityName}")
    public Weather getWeatherByCity(@PathVariable(value = "cityName") String cityName) {
        return weathersList.stream().filter(x -> x.getCityName().equalsIgnoreCase(cityName)).collect(Collectors.toList()).get(0);
    }

    @RequestMapping("/getWeatherByZipCode/{zipCode}")
    public Weather getWeatherByZipCode(@PathVariable(value = "zipCode") String zipCode) {
        return weathersList.stream().filter(x -> x.getZipCode().equalsIgnoreCase(zipCode)).collect(Collectors.toList()).get(0);
    }

    @RequestMapping("/getWeatherByCountry/{countryName}")
    public  List<Weather> getWeathersByCountry(@PathVariable(value = "countryName") String countryName) {
        return weathersList.stream().filter(x -> x.getCountry().equalsIgnoreCase(countryName)).collect(Collectors.toList());
    }
}
