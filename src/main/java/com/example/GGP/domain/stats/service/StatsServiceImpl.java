package com.example.GGP.domain.stats.service;

import com.example.GGP.domain.device.entity.Device;
import com.example.GGP.domain.stats.entity.Stats;
import com.example.GGP.domain.stats.entity.StatsId;
import com.example.GGP.domain.stats.repository.StatsRepository;
import com.example.GGP.domain.stats.service.dto.StatsResponse;
import com.example.GGP.domain.stats.service.dto.YearMonthUseTimeResponse;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
@RequiredArgsConstructor
public class StatsServiceImpl implements StatsService {

    private final StatsRepository statsRepository;


    private final DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM");

    @Override
    public StatsResponse getStats(String deviceId) {
        String minusYearMonth = LocalDate.now().minusMonths(12).format(dateTimeFormatter);

        List<YearMonthUseTimeResponse> avgUseTime = statsRepository.getAvgUseTime(minusYearMonth);
        List<YearMonthUseTimeResponse> myUseTime = statsRepository.getMyUseTime(minusYearMonth, deviceId);

        System.out.println("myUseTime.size() = " + myUseTime.size());
        System.out.println("avgUseTime = " + avgUseTime.size());

        return StatsResponse.of(avgUseTime, myUseTime);
    }

    @Override
    @Transactional
    public void addStats(Device device) {
        String curYearMonth = LocalDate.now().format(dateTimeFormatter);
        Stats stats = statsRepository.findById(StatsId.of(curYearMonth, device.getId())).orElseGet(() -> {
            Stats newStats = Stats.of(curYearMonth, device.getId());
            statsRepository.save(newStats);
            return newStats;
        });

        LocalDateTime onTime = LocalDateTime.parse(device.getOnTime());
        LocalDateTime offTime = LocalDateTime.parse(device.getOffTime());

        stats.addUseTime(Duration.between(onTime, offTime).toMinutes());
    }
}
