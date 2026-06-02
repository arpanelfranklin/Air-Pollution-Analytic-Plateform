package com.example.air_pollution_analytics.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "PollutionData")
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
