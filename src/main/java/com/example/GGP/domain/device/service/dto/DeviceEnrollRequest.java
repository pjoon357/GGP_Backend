package com.example.GGP.domain.device.service.dto;

import com.example.GGP.domain.device.entity.Device;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class DeviceEnrollRequest {
    private String deviceId;
    private Integer chargeTime;
}
