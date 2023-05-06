package com.example.GGP.domain.stats.entity;

import jakarta.persistence.Embeddable;

import java.io.Serializable;

@Embeddable
public class StatsId implements Serializable {

    private String yearMonth;

    private String deviceId;
}
