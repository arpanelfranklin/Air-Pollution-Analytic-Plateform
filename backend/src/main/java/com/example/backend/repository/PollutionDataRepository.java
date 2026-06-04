package com.example.backend.repository;

import com.example.backend.entity.PollutionData;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface PollutionDataRepository extends MongoRepository<PollutionData, String> {
    List<PollutionData> findByCountry(String country);
    List<PollutionData> findByCity(String city);
    List<PollutionData> findByaqiCategory(String category);
}

