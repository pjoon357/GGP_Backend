package com.example.GGP.domain.stats.service.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class YearMonthUseTimeResponse {

    private String yearMonth;

    private Long useTime;
}
