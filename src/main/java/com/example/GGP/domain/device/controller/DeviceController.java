package com.example.GGP.domain.device.controller;

import com.example.GGP.common.ApiResponse;
import com.example.GGP.domain.device.service.DeviceService;
import com.example.GGP.domain.device.service.dto.DeviceInfoResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class DeviceController {

    DeviceService deviceService;

    @PostMapping("/devices")
    ApiResponse<Object> enrollDevice() {

        return ApiResponse.success(null);
    }

    @GetMapping("/devices/{deviceId}")
    ApiResponse<DeviceInfoResponse> getDeviceInfo(@PathVariable String deviceId) {
        return ApiResponse.success(null);
    }

    @PutMapping("/devices/{deviceId}/on")
    ApiResponse<Object> onDevice(@PathVariable String deviceId) {

        return ApiResponse.success(null);
    }

    @PutMapping("/devices/{deviceId}/off")
    ApiResponse<Object> offDevice(@PathVariable String deviceId) {

        return ApiResponse.success(null);
    }

    @PutMapping("/devices/{deviceId}/manual")
    ApiResponse<Object> manualDevice(@PathVariable String deviceId) {

        return ApiResponse.success(null);
    }

    @PutMapping("/devices/{deviceId}/reserve")
    ApiResponse<Object> reserveDevice(@PathVariable String deviceId) {

        return ApiResponse.success(null);
    }

    @PutMapping("/devices/{deviceId}/optimal")
    ApiResponse<Object> optimalDevice(@PathVariable String deviceId) {

        return ApiResponse.success(null);
    }

    @PutMapping("/devices/{deviceId}/eco")
    ApiResponse<Object> ecoDevice(@PathVariable String deviceId) {

        return ApiResponse.success(null);
    }
}
