package com.example.GGP.domain.device.entity;

import com.example.GGP.domain.device.service.dto.DeviceEnrollRequest;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
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

    @Builder(access = AccessLevel.PACKAGE)
    private Device (String deviceId, Mode mode, Integer chargeTime, String reserveTime, String homecomingTime, String onTime, String offTime) {
        this.id = deviceId;
        this.mode = mode;
        this.chargeTime = chargeTime;
        this.reserveTime = reserveTime;
        this.homecomingTime = homecomingTime;
        this.onTime = onTime;
        this.offTime = offTime;
    }

    public static Device instanceOf(DeviceEnrollRequest request) {
        return Device.builder()
                .deviceId(request.getDeviceId())
                .chargeTime(request.getChargeTime())
                .mode(Mode.OFF)
                .build();
    }

    public void changeMode(Mode mode) {
        this.mode = mode;
    }

    public void setOnTime(String onTime) {
        this.onTime = onTime;
    }

    public void setOffTime(String offTime) {
        this.offTime = offTime;
    }

    public void setReserveTime(String reserveTime) {
        this.reserveTime = reserveTime;
    }

    public void setHomecomingTime(String homecomingTime) {
        this.homecomingTime = homecomingTime;
    }
}
