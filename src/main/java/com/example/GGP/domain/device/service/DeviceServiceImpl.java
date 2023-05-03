package com.example.GGP.domain.device.service;

import com.example.GGP.domain.device.repository.DeviceRepository;
import com.example.GGP.domain.device.service.dto.DeviceEnrollRequest;
import com.example.GGP.domain.device.service.dto.DeviceInfoResponse;
import com.example.GGP.domain.device.service.dto.DeviceOptimalRequest;
import com.example.GGP.domain.device.service.dto.DeviceReserveRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DeviceServiceImpl implements DeviceService {

    private final DeviceRepository deviceRepository;

    @Override
    public void enroll(DeviceEnrollRequest request) {

    }

    @Override
    public DeviceInfoResponse getInfo(String deviceId) {
        return null;
    }

    @Override
    public void putOn(String deviceId) {

    }

    @Override
    public void putOff(String deviceId) {

    }

    @Override
    public void putManual(String deviceId) {

    }

    @Override
    public void putEco(String deviceId) {

    }

    @Override
    public void putReserve(String deviceId, DeviceReserveRequest request) {

    }

    @Override
    public void putOptimal(String deviceId, DeviceOptimalRequest request) {

    }
}
