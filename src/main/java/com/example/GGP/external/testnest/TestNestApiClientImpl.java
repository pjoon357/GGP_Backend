package com.example.GGP.external.testnest;

import com.example.GGP.common.BaseException;
import com.example.GGP.common.ErrorCode;
import com.example.GGP.external.nest.dto.ModeRequest;
import com.example.GGP.external.nest.dto.TargetTemperatureRequest;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class TestNestApiClientImpl implements TestNestApiClient {

    private final TestNestRepository testNestRepository;

    @Override
    public Double getAmbientTemperature(String token, String deviceId) {

        TestNest nest = testNestRepository.findById(deviceId).orElseThrow(
                () -> new BaseException(ErrorCode.NOTFOUND_DEVICE)
        );

        return nest.getAmbientTemperature();
    }

    @Override
    public Double getTargetTemperature(String token, String deviceId) {
        TestNest nest = testNestRepository.findById(deviceId).orElseThrow(
                () -> new BaseException(ErrorCode.NOTFOUND_DEVICE)
        );

        return nest.getTargetTemperature();
    }

    @Override
    @Transactional
    public void putMode(String token, String deviceId, ModeRequest request) {
        TestNest nest = testNestRepository.findById(deviceId).orElseThrow(
                () -> new BaseException(ErrorCode.NOTFOUND_DEVICE)
        );

        nest.setMode(request.getHvac_mode());
    }

    @Override
    public String getMode(String token, String deviceId) {
        TestNest nest = testNestRepository.findById(deviceId).orElseThrow(
                () -> new BaseException(ErrorCode.NOTFOUND_DEVICE)
        );

        return nest.getMode();
    }

    @Override
    public void putTargetTemperature(String token, String deviceId, TargetTemperatureRequest request) {
        TestNest nest = testNestRepository.findById(deviceId).orElseThrow(
                () -> new BaseException(ErrorCode.NOTFOUND_DEVICE)
        );

        nest.setTargetTemperature(request.getTarget_temperature_c());
    }
}
