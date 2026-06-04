package com.example.etl_pipeline.service;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class CSVReaderService {

    public List<String[]> readCsv() {

        List<String[]> rows = new ArrayList<>();

        try {

            ClassPathResource resource =
                    new ClassPathResource(
                            "datasets/globalAirPollutionDataset.csv"
                    );

            CSVReader reader =
                    new CSVReader(
                            new InputStreamReader(
                                    resource.getInputStream()
                            )
                    );

            reader.readNext();

            String[] row;

            while ((row = reader.readNext()) != null) {
                rows.add(row);
            }

            reader.close();

        } catch (IOException | CsvValidationException e) {
            throw new RuntimeException(
                    "Error reading CSV file",
                    e
            );
        }

        return rows;
    }
}