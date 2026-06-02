package com.example.air_pollution_analytics.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CountryAQI {
    private String Country;
    private Double averageAqi;
}
