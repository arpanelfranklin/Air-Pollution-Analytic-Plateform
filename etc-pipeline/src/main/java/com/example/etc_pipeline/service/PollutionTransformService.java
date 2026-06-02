package com.example.etc_pipeline.service;

import com.example.etc_pipeline.entity.PollutionData;
import org.springframework.stereotype.Service;

@Service

public class PollutionTransformService {
    public PollutionData transform(String[] row){
        PollutionData pollutionData = new PollutionData();

        //hashKey
        String hash = row[0].trim() + "#" + row[1].trim() + "@" + row[2].trim();
        pollutionData.setHash(hash);

        pollutionData.setCountry(row[0].trim());
        pollutionData.setCity(row[1].trim());

        //AQI value and catagory
        pollutionData.setAqiValue(Integer.parseInt(row[2].trim()));
        pollutionData.setAqiCategory(row[3].trim());

        // Co AQI Value
        pollutionData.setCoAqiValue(Integer.parseInt(row[4].trim()));
        pollutionData.setCoAqiCategory(row[5].trim());

        //Ozone AQI Value
        pollutionData.setOzoneAqiValue(Integer.parseInt(row[6].trim()));
        pollutionData.setOzoneAqiCategory(row[7].trim());

        //No2AQIValue
        pollutionData.setNo2AqiValue(Integer.parseInt(row[8].trim()));
        pollutionData.setNo2AqiCategory(row[9].trim());

        //pm2.5 value
        pollutionData.setPm25Value(Integer.parseInt(row[10].trim()));
        pollutionData.setPm25Category(row[11].trim());

        return pollutionData;

    }

}
