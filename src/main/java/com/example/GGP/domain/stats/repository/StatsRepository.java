package com.example.GGP.domain.stats.repository;

import com.example.GGP.domain.stats.entity.Stats;
import com.example.GGP.domain.stats.entity.StatsId;
import com.example.GGP.domain.stats.service.dto.YearMonthUseTimeResponse;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface StatsRepository extends CrudRepository<Stats, StatsId> {

    @Query("select s.id.yearMonth, avg(s.useTime) from Stats s where s.id.yearMonth >= :minusYearMonth group by s.id.yearMonth order by s.id.yearMonth")
    List<YearMonthUseTimeResponse> getAvgUseTime(String minusYearMonth, String deviceId);


    @Query("select s.id.yearMonth, s.useTime from Stats s where s.id.deviceId = :deviceId and s.id.yearMonth >= :minusYearMonth order by s.id.yearMonth")
    List<YearMonthUseTimeResponse> getMyUseTime(String minusYearMonth, String deviceId);
}
