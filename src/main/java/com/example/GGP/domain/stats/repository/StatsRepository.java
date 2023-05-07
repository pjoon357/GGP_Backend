package com.example.GGP.domain.stats.repository;

import com.example.GGP.domain.stats.entity.Stats;
import com.example.GGP.domain.stats.entity.StatsId;
import com.example.GGP.domain.stats.service.dto.YearMonthUseTimeResponse;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface StatsRepository extends CrudRepository<Stats, StatsId> {

    @Query("select new com.example.GGP.domain.stats.service.dto.YearMonthUseTimeResponse(s.id.yearAndMonth, cast(avg(s.useTime) as Long)) from Stats s group by s.id.yearAndMonth having s.id.yearAndMonth >= :minusYearMonth order by s.id.yearAndMonth")
    List<YearMonthUseTimeResponse> getAvgUseTime(String minusYearMonth);


    @Query("select new com.example.GGP.domain.stats.service.dto.YearMonthUseTimeResponse(s.id.yearAndMonth, s.useTime) from Stats s where s.id.deviceId = :deviceId and s.id.yearAndMonth >= :minusYearMonth order by s.id.yearAndMonth")
    List<YearMonthUseTimeResponse> getMyUseTime(String minusYearMonth, String deviceId);
}
