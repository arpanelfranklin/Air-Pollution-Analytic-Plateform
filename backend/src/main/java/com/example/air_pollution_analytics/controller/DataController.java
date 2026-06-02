package com.example.air_pollution_analytics.controller;

import com.example.air_pollution_analytics.dto.CountryAQI;
import com.example.air_pollution_analytics.dto.CountrySummary;
import com.example.air_pollution_analytics.dto.Stats;
import com.example.air_pollution_analytics.entity.PollutionData;
import com.example.air_pollution_analytics.service.PollutionDataService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/pollution")
public class DataController {

    @Autowired
    private final PollutionDataService pollutionDataService;

    // ALl data
    @GetMapping
    public List<PollutionData> findAll() {
        return pollutionDataService.dataAll();
    }

    // Data by Country
    @GetMapping("/country/{country}")
    public List<PollutionData> dataOfCountry(@PathVariable String country){
        return pollutionDataService.dataOfCountry(country);
    }

    //Data by City
    @GetMapping("/city/{city}")
    public List<PollutionData> dataOfCity(@PathVariable String city){
        return pollutionDataService.dataOfCity(city);
    }

    //Data by Catagory
    @GetMapping("/category/{category}")
    public List<PollutionData> dataOfCatagory(@PathVariable String category){
        return pollutionDataService.dataByCategory(category);
    }

    // overall stats
    @GetMapping("/stats")
    public Stats stats() {
        return pollutionDataService.getStats();
    }

    //Get Top polluted cities
    @GetMapping("/top-polluted-cities")
    public List<PollutionData> topPollutedCities(){
        return pollutionDataService.getTopPollutedCities();
    }

    //Get Cleanest Cities
    @GetMapping("/cleanest-cities")
    public List<PollutionData> cleanestCities(){
        return pollutionDataService.getCleanestCities();
    }


    //Categor Distribution
    @GetMapping("/category-stats")
    public Map<String,Long> categoryStats() {
        return pollutionDataService.getCategoryStats();
    }

    // top polluted Country
    @GetMapping("top-polluted-country")
    public List<CountryAQI> topPollutedCountry(){
        return pollutionDataService.getTopPollutedCountry();
    }

    // country summary
    @GetMapping("/country-summary/{country}")
    public CountrySummary countrySummary(@PathVariable String country){
        return pollutionDataService.getCountrySummary(country);
    }
}
