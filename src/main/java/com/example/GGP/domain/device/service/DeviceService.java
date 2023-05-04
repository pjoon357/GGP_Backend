package com.example.GGP.domain.device.service;

import com.example.GGP.domain.device.service.dto.*;

public interface DeviceService {
    void enroll(DeviceEnrollRequest request);

    DeviceInfoResponse getInfo(String deviceId);

    void putOn(String deviceId);

    void putOff(String deviceId);

    void putManual(String deviceId);

    void putEco(String deviceId);

    void putReserve(String deviceId, DeviceReserveRequest request);

    void putOptimal(String deviceId, DeviceOptimalRequest request);

    void putTargetTemperature(String deviceId, PutTargetTemperatureRequest request);
}
