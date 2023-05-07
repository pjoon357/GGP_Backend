package com.example.GGP.domain.stats.service.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@ToString
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class StatsResponse {

    private List<YearMonthUseTimeResponse> deviceStatistic = new ArrayList<>();

    private List<YearMonthUseTimeResponse> averageStatistic = new ArrayList<>();

    public static StatsResponse of(List<YearMonthUseTimeResponse> deviceStatistic, List<YearMonthUseTimeResponse> averageStatistic) {
        return new StatsResponse(deviceStatistic, averageStatistic);
    }
}
