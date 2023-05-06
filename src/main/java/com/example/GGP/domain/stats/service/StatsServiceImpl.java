package com.example.GGP.domain.stats.service;

import com.example.GGP.domain.stats.repository.StatsRepository;
import com.example.GGP.domain.stats.service.dto.StatsResponse;
import com.example.GGP.domain.stats.service.dto.YearMonthUseTimeResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class StatsServiceImpl implements StatsService {

    private final StatsRepository statsRepository;

    private final SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM");


    @Override
    public StatsResponse getStats(String deviceId) {
        String minusYearMonth = simpleDateFormat.format(LocalDate.now().minusMonths(12));

        List<YearMonthUseTimeResponse> avgUseTime = statsRepository.getAvgUseTime(minusYearMonth, deviceId);
        List<YearMonthUseTimeResponse> myUseTime = statsRepository.getMyUseTime(minusYearMonth, deviceId);

        return StatsResponse.of(avgUseTime, myUseTime);
    }
}
