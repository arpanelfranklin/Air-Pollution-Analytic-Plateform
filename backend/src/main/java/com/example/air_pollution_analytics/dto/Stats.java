package com.example.air_pollution_analytics.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Stats {
    private long totalRecords;
    private double averageAqi;
    private int maxAqi;
    private int minAqi;
}
