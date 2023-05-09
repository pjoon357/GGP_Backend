package com.example.GGP.external.testnest;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;

@Entity
@Getter
public class TestNest {

    @Id
    private String deviceId;

    private Double ambientTemperature;

    private Double targetTemperature;

    private String mode;

    public void setMode(String hvac_mode) {
        this.mode = hvac_mode;
    }

    public void setTargetTemperature(Integer target_temperature_c) {
        this.targetTemperature = target_temperature_c.doubleValue();
    }
}
