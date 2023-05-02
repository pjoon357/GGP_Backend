package com.example.GGP.domain.device.entity;

import jakarta.persistence.*;
import lombok.Getter;

@Getter
@Entity
public class Device {

    @Id
    private String id;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Mode mode;

    @Column(nullable = false)
    private Integer chargeTime;

    private String reserveTime;

    private String homecomingTime;

    private String onTime;

    private String offTime;
}
