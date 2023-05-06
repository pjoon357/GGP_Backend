package com.example.GGP.domain.stats.controller;

import com.example.GGP.common.ApiResponse;
import com.example.GGP.domain.stats.service.StatsService;
import com.example.GGP.domain.stats.service.dto.StatsResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class StatsController {

    private final StatsService statsService;

    @GetMapping("/devices/{deviceId}/statistic")
    ApiResponse<StatsResponse> getStats(@PathVariable String deviceId) {
        return ApiResponse.success(statsService.getStats(deviceId));
    }
}
