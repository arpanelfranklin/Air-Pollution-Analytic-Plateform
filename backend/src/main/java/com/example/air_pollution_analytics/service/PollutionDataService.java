package com.example.air_pollution_analytics.service;

import com.example.air_pollution_analytics.dto.Stats;
import com.example.air_pollution_analytics.entity.PollutionData;
import com.example.air_pollution_analytics.repository.PollutionDataRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.*;

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
        List<PollutionData> data = pollutionDataRepository.findAll();
         long totalRecords = data.size();

         double averageAqi = data.stream()
                 .mapToInt(PollutionData::getAqiValue)
                 .average()
                 .orElse(0);

         int minAqi = data.stream().mapToInt(PollutionData::getAqiValue).min().orElse(0);
         int maxAqi = data.stream().mapToInt(PollutionData::getAqiValue).max().orElse(0);
         return new Stats(totalRecords, averageAqi, minAqi, maxAqi);
    }
}
