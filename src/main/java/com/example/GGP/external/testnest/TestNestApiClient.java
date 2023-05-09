package com.example.GGP.external.testnest;

import com.example.GGP.external.nest.dto.ModeRequest;
import com.example.GGP.external.nest.dto.TargetTemperatureRequest;

public interface TestNestApiClient {
    Double getAmbientTemperature(String token, String deviceId);

    Double getTargetTemperature(String token, String deviceId);

    void putMode(String token, String deviceId, ModeRequest heat);

    String getMode(String token, String deviceId);

    void putTargetTemperature(String token, String deviceId, TargetTemperatureRequest request);
}
