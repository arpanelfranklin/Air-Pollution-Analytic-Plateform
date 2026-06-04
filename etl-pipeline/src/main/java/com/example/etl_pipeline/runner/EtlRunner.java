package com.example.etl_pipeline.runner;

import com.example.etl_pipeline.entity.PollutionData;
import com.example.etl_pipeline.service.CSVReaderService;
import com.example.etl_pipeline.service.PollutionLoaderService;
import com.example.etl_pipeline.service.PollutionTransformService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
@RequiredArgsConstructor
@Component
public class EtlRunner implements CommandLineRunner {
    private final CSVReaderService csvReaderService;
    private final PollutionLoaderService pollutionLoaderService;
    private final PollutionTransformService pollutionTransformService;

    @Override
    public void run(String... args){
        System.out.println("ETL Pipeline is running...");

       List<String[]> rows =
        csvReaderService.readCsv();
        List<PollutionData> pollutionDataList = new ArrayList<>();
        for(String[] row: rows){
            PollutionData pollutionData = pollutionTransformService.transform(row);
            pollutionDataList.add(pollutionData);
        }
        pollutionLoaderService.loadAll(pollutionDataList);

        System.out.println("ETL Pipeline is complete.");
        System.out.println("Added" +pollutionDataList.size() + " Records to MongoDB");

    }
}
