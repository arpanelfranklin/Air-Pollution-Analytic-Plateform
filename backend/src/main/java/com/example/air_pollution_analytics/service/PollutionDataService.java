package com.example.air_pollution_analytics.service;

import com.example.air_pollution_analytics.dto.CountryAQI;
import com.example.air_pollution_analytics.dto.CountrySummary;
import com.example.air_pollution_analytics.dto.Stats;
import com.example.air_pollution_analytics.entity.PollutionData;
import com.example.air_pollution_analytics.repository.PollutionDataRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.*;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PollutionDataService {
    @Autowired
    private final PollutionDataRepository pollutionDataRepository;

    // All data fetch
    public List<PollutionData> dataAll(){
        return pollutionDataRepository.findAll();
    }

    // Data by Country;
    public List<PollutionData> dataOfCountry(String country){
        return pollutionDataRepository.findByCountry(country);
    }

    //Data by city
    public List<PollutionData> dataOfCity(String city){
        return pollutionDataRepository.findByCity(city);
    }

    // Data by catagory
    public List<PollutionData> dataByCategory(String category){
        return pollutionDataRepository.findByaqiCategory(category);
    }

    // getting stats
    public Stats getStats(){
        List<PollutionData> data = dataAll();
         long totalRecords = data.size();

         double averageAqi = data.stream()
                 .mapToInt(PollutionData::getAqiValue)
                 .average()
                 .orElse(0);

         int minAqi = data.stream().mapToInt(PollutionData::getAqiValue).min().orElse(0);
         int maxAqi = data.stream().mapToInt(PollutionData::getAqiValue).max().orElse(0);
         return new Stats(totalRecords, averageAqi, minAqi, maxAqi);
    }

    // get top 10 polluted cities
    public List<PollutionData> getTopPollutedCities(){

         return dataAll().stream().
                sorted(Comparator.comparingInt(PollutionData::getAqiValue)
                        .reversed()).limit(10)
                .toList();

    }

    // get cleanest cities
    public List<PollutionData> getCleanestCities(){
        return dataAll().stream()
                .sorted(Comparator
                        .comparingInt(PollutionData::getAqiValue)).limit(10)
                .toList();
    }

    // catagory stats
    public Map<String, Long> getCategoryStats(){

        return dataAll().stream()
                .filter(data -> data.getAqiCategory() != null)
                .collect(
                        Collectors.groupingBy(
                                PollutionData::getAqiCategory,
                                Collectors.counting()
                        )
                );
    }

    // top polluted country
    public List<CountryAQI> getTopPollutedCountry(){
        Map<String, Double> countryAverages = dataAll().stream()
                .collect(Collectors.groupingBy(PollutionData::getCountry,
                        Collectors.averagingInt(PollutionData::getAqiValue)));

        return countryAverages.entrySet()
                .stream()
                .sorted(Map.Entry.<String,Double> comparingByValue().reversed())
                .limit(10)
                .map(entry -> new CountryAQI(entry.getKey(), entry.getValue()))
                .toList();

    }

    //country summary
    public CountrySummary getCountrySummary(String country) {
        List<PollutionData> data = dataOfCountry(country);
        long cityCount = data.size();
        Double averageAqi = data.stream()
                .mapToInt(PollutionData::getAqiValue)
                .average()
                .orElse(0);
        int maxAqi = data.stream()
                .mapToInt(PollutionData::getAqiValue)
                .max().orElse(0);
        int minAqi = data.stream()
                .mapToInt(PollutionData::getAqiValue)
                .min().orElse(0);

        return new CountrySummary(country,cityCount, averageAqi, maxAqi, minAqi);

    }
}
