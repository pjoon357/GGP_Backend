package com.example.GGP.domain.device.controller;

import com.example.GGP.common.ApiResponse;
import com.example.GGP.domain.device.service.DeviceService;
import com.example.GGP.domain.device.service.dto.*;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class DeviceController {

    private final DeviceService deviceService;

    @PostMapping("/devices")
    ApiResponse<Object> enrollDevice(@RequestBody DeviceEnrollRequest request) {
        deviceService.enroll(request);

        return ApiResponse.success(null);
    }

    @GetMapping("/devices/{deviceId}")
    ApiResponse<DeviceInfoResponse> getDeviceInfo(@PathVariable String deviceId) {
        return ApiResponse.success(deviceService.getInfo(deviceId));
    }

    @PutMapping("/devices/{deviceId}/on")
    ApiResponse<DeviceInfoResponse> onDevice(@PathVariable String deviceId) {
        deviceService.putOn(deviceId);

        return ApiResponse.success(deviceService.getInfo(deviceId));
    }

    @PutMapping("/devices/{deviceId}/off")
    ApiResponse<Object> offDevice(@PathVariable String deviceId) {
        deviceService.putOff(deviceId);

        return ApiResponse.success(null);
    }

    @PutMapping("/devices/{deviceId}/target")
    ApiResponse<Object> changeTargetTemperature(@PathVariable String deviceId,
                                                @RequestBody PutTargetTemperatureRequest request) {
        deviceService.putTargetTemperature(deviceId, request);

        return ApiResponse.success(null);
    }

    @PutMapping("/devices/{deviceId}/manual")
    ApiResponse<Object> manualDevice(@PathVariable String deviceId) {
        deviceService.putManual(deviceId);

        return ApiResponse.success(null);
    }

    @PutMapping("/devices/{deviceId}/reserve")
    ApiResponse<Object> reserveDevice(@PathVariable String deviceId, @RequestBody DeviceReserveRequest request) {
        deviceService.putReserve(deviceId, request);

        return ApiResponse.success(null);
    }

    @PutMapping("/devices/{deviceId}/optimal")
    ApiResponse<Object> optimalDevice(@PathVariable String deviceId, @RequestBody DeviceOptimalRequest request) {
        deviceService.putOptimal(deviceId, request);

        return ApiResponse.success(null);
    }

    @PutMapping("/devices/{deviceId}/eco")
    ApiResponse<Object> ecoDevice(@PathVariable String deviceId) {
        deviceService.putEco(deviceId);

        return ApiResponse.success(null);
    }
}
