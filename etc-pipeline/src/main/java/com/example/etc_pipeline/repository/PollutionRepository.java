package com.example.etc_pipeline.repository;

import com.example.etc_pipeline.entity.PollutionData;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PollutionRepository extends MongoRepository<PollutionData,String> {
}
