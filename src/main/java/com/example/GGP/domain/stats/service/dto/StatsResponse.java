package com.example.GGP.domain.stats.service.dto;

import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
public class StatsResponse {

    private List<YearMonthUseTimeResponse> deviceStatistic;

    private List<YearMonthUseTimeResponse> averageStatistic;

    public static StatsResponse of(List<YearMonthUseTimeResponse> deviceStatistic, List<YearMonthUseTimeResponse> averageStatistic) {
        return new StatsResponse(deviceStatistic, averageStatistic);
    }
}
