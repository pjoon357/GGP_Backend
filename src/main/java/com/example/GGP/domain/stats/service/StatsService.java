package com.example.GGP.domain.stats.service;

import com.example.GGP.domain.stats.service.dto.StatsResponse;

public interface StatsService {
    StatsResponse getStats(String deviceId);
}
