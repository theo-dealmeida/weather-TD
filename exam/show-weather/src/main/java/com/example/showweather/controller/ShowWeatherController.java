package com.example.showweather.controller;

import com.example.showweather.delegate.ShowWeatherDelegate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ShowWeatherController {

    @Autowired
    ShowWeatherDelegate showWeatherDelegate;

    @RequestMapping(value = "/getWeatherByCity/{cityName}", method = RequestMethod.GET)
    public String getWeatherByCity(@PathVariable String cityName) {
        System.out.println("Going to call weather service to get data!");
        return showWeatherDelegate.callWeatherCityServiceAndGetData(cityName);
    }

    @RequestMapping(value = "/getWeatherByZipCode/{zipCode}", method = RequestMethod.GET)
    public String getWeatherByZipCode(@PathVariable String zipCode) {
        System.out.println("Going to call weather service to get data!");
        return showWeatherDelegate.callWeatherZipCodeServiceAndGetData(zipCode);
    }

}
