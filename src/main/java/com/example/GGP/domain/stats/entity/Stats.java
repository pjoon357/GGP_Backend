package com.example.GGP.domain.stats.entity;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;

@Entity
public class Stats {

    @EmbeddedId
    private StatsId id;

    private Integer useTime;

}
