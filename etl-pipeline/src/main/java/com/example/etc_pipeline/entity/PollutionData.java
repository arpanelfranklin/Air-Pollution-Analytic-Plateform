package com.example.etc_pipeline.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "PollutionData")
@NoArgsConstructor
@AllArgsConstructor


public class PollutionData {

    @Id
    private String id;

    @Indexed(unique = true)
    private String hash;

    private String country;
    private String city;

    private Integer aqiValue;
    private String aqiCategory;

    private Integer coAqiValue;
    private String coAqiCategory;

    private Integer ozoneAqiValue;
    private String ozoneAqiCategory;

    private Integer no2AqiValue;
    private String no2AqiCategory;

    private Integer pm25Value;
    private String pm25Category;
}
