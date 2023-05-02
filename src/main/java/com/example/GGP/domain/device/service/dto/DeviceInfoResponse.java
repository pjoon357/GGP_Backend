package com.example.GGP.domain.device.service.dto;

import jakarta.annotation.Nullable;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class DeviceInfoResponse {

    String mode;

    @Nullable
    Double currentTemperature;

    @Nullable
    Integer targetTemperature;

    @Nullable
    String reserveTime;

    @Nullable
    String homecomingTime;

}
