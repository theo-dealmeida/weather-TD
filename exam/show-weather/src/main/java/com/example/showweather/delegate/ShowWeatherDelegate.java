package com.example.showweather.delegate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Date;

@Service
public class ShowWeatherDelegate {

    @Autowired
    RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "callWeatherServiceAndGetData_Fallback")
    public String callWeatherCityServiceAndGetData(String cityName) {
        System.out.println("Météo pour : " + cityName);
        String response = restTemplate
                .exchange("http://localhost:8080/getWeatherByCity/{cityName}"
                        , HttpMethod.GET
                        , null
                        , new ParameterizedTypeReference<String>() {
                        }, cityName).getBody();

        System.out.println("Response Received as " + response + " -  " + new Date());

        return "NORMAL FLOW !!! - Ville -  " + cityName + " :::  Météo " + response + " -  " + new Date();
    }

    @HystrixCommand(fallbackMethod = "callWeatherServiceAndGetData_Fallback")
    public String callWeatherZipCodeServiceAndGetData(String zipCode) {
        System.out.println("Météo pour : " + zipCode);
        String response = restTemplate
                .exchange("http://localhost:8080/getWeatherByZipCode/{zipCode}"
                        , HttpMethod.GET
                        , null
                        , new ParameterizedTypeReference<String>() {
                        }, zipCode).getBody();

        System.out.println("Response Received as " + response + " -  " + new Date());

        return "NORMAL FLOW !!! - Ville -  " + zipCode + " :::  Météo " + response + " -  " + new Date();
    }

    @SuppressWarnings("unused")
    private String callWeatherServiceAndGetData_Fallback(String cityName) {
        System.out.println("Weather Service is down!!! fallback route enabled...");
        return "CIRCUIT BREAKER ENABLED!!!No Response From Weather Service at this moment. Service will be back shortly - " + new Date();
    }

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

}
