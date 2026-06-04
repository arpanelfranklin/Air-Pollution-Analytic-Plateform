package com.example.etl_pipeline.service;

import com.example.etl_pipeline.entity.PollutionData;
import com.example.etl_pipeline.repository.PollutionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PollutionLoaderService {
    @Autowired
    private final PollutionRepository pollutionRepository;

    public void loadAll(List<PollutionData> pollutionDataList){
        try {
            pollutionRepository.saveAll(pollutionDataList);
        }catch (Exception e){
            System.out.print("Error in saving pollutionDataList, "+ e.getMessage());
        }
    }
}
