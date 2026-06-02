package com.example.air_pollution_analytics.dto;


import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CountrySummary {
    private String country;
    private Long cityCount;
    private Double averageAqi;
    private Integer maxAqi;
    private Integer minAqi;

}
