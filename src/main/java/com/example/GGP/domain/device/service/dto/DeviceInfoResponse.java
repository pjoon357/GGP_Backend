package com.example.GGP.domain.device.service.dto;

import com.example.GGP.domain.device.entity.Device;
import jakarta.annotation.Nullable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class DeviceInfoResponse {

    private String mode;

    @Nullable
    private Double currentTemperature;

    @Nullable
    private Integer targetTemperature;

    @Nullable
    private String reserveTime;

    @Nullable
    private String homecomingTime;

    public static DeviceInfoResponse of(Device device, Double currentTemperature, Integer targetTemperature) {
        return new DeviceInfoResponse(device.getMode().name(), currentTemperature, targetTemperature,
                device.getReserveTime(), device.getHomecomingTime());
    }
}
