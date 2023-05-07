package com.example.GGP.domain.stats.entity;

import jakarta.persistence.Embeddable;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Embeddable
@EqualsAndHashCode
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class StatsId implements Serializable {

    private String yearAndMonth;

    private String deviceId;

    public static StatsId of(String yearMonth, String deviceId) {
        return new StatsId(yearMonth, deviceId);
    }
}
