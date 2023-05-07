package com.example.GGP.domain.stats.entity;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Stats {

    @EmbeddedId
    private StatsId id;

    private Long useTime;

    public static Stats of(String yearMonth, String deviceId) {
        return new Stats(StatsId.of(yearMonth, deviceId), 0L);
    }

    public void addUseTime(Long time) {
        this.useTime = this.useTime + time;
    }
}
