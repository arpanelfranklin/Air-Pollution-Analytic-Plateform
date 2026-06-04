package com.example.etl_pipeline.service;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import org.springframework.stereotype.Service;

@Service
public class CSVReaderService {
    public List<String[]> readCsv(String filePath){
        List<String[]> rows = new ArrayList<>();

        try(CSVReader reader = new CSVReader(new FileReader(filePath))){
            reader.readNext();

            String[] row;
            while ((row = reader.readNext()) != null){
                rows.add(row);
            }

        }catch (IOException | CsvValidationException e) {
            throw new RuntimeException("Error reading CSV file", e);
        }

        return rows;
    }
}
