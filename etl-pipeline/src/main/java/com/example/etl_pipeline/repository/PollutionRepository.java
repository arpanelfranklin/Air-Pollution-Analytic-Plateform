package com.example.etl_pipeline.repository;

import com.example.etl_pipeline.entity.PollutionData;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PollutionRepository extends MongoRepository<PollutionData,String> {
}
