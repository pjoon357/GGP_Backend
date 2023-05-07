package com.example.GGP.domain.device.service;

import com.example.GGP.common.BaseException;
import com.example.GGP.common.ErrorCode;
import com.example.GGP.domain.device.entity.Device;
import com.example.GGP.domain.device.entity.Mode;
import com.example.GGP.domain.device.repository.DeviceRepository;
import com.example.GGP.domain.device.service.dto.*;
import com.example.GGP.domain.stats.entity.Stats;
import com.example.GGP.domain.stats.entity.StatsId;
import com.example.GGP.domain.stats.repository.StatsRepository;
import com.example.GGP.domain.stats.service.StatsService;
import com.example.GGP.domain.stats.service.dto.StatsResponse;
import com.example.GGP.external.nest.NestApiClient;
import com.example.GGP.external.nest.dto.ModeRequest;
import com.example.GGP.external.nest.dto.TargetTemperatureRequest;
import com.example.GGP.external.testnest.TestNestApiClient;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class DeviceServiceImpl implements DeviceService {

    private final DeviceRepository deviceRepository;

    private final StatsService statsService;

    //private final NestApiClient nestApiClient;

    private final TestNestApiClient nestApiClient;

    private static final String TOKEN = "token";

    @Override
    @Transactional
    public void enroll(DeviceEnrollRequest request) {
        if (deviceRepository.existsById(request.getDeviceId())) {
            throw new BaseException(ErrorCode.CONFLICT);
        }

        Device newDevice = Device.instanceOf(request);
        deviceRepository.save(newDevice);
    }

    @Override
    public DeviceInfoResponse getInfo(String deviceId) {
        Device device = deviceRepository.findById(deviceId)
                .orElseThrow(() -> new BaseException(ErrorCode.NOTFOUND_DEVICE));

        Double currentTemperature = nestApiClient.getAmbientTemperature(TOKEN, deviceId);
        Integer targetTemperature = null;

        if (device.getMode() == Mode.MANUAL) {
            targetTemperature = nestApiClient.getTargetTemperature(TOKEN, deviceId).intValue();
        }

        return DeviceInfoResponse.of(device, currentTemperature, targetTemperature);
    }

    @Override
    @Transactional
    public void putOn(String deviceId) {
        Device device = deviceRepository.findById(deviceId)
                .orElseThrow(() -> new BaseException(ErrorCode.NOTFOUND_DEVICE));

        device.changeMode(Mode.MANUAL);
        device.setOnTime(LocalDateTime.now().toString());

        nestApiClient.putMode(TOKEN, deviceId, new ModeRequest("heat"));
    }

    @Override
    @Transactional
    public void putOff(String deviceId) {
        Device device = deviceRepository.findById(deviceId)
                .orElseThrow(() -> new BaseException(ErrorCode.NOTFOUND_DEVICE));

        device.changeMode(Mode.OFF);
        device.setOffTime(LocalDateTime.now().toString());

        //통계 추가 하기
        statsService.addStats(device);

        nestApiClient.putMode(TOKEN, deviceId, new ModeRequest("off"));
    }

    @Override
    @Transactional
    public void putManual(String deviceId) {
        Device device = deviceRepository.findById(deviceId)
                .orElseThrow(() -> new BaseException(ErrorCode.NOTFOUND_DEVICE));

        device.changeMode(Mode.MANUAL);

        if (nestApiClient.getMode(TOKEN, deviceId).equals("off")) {
            device.setOnTime(LocalDateTime.now().toString());
        }

        nestApiClient.putMode(TOKEN, deviceId, new ModeRequest("heat"));
    }

    @Override
    @Transactional
    public void putEco(String deviceId) {
        Device device = deviceRepository.findById(deviceId)
                .orElseThrow(() -> new BaseException(ErrorCode.NOTFOUND_DEVICE));

        device.changeMode(Mode.ECO);

        nestApiClient.putMode(TOKEN, deviceId, new ModeRequest("eco"));
    }

    @Override
    @Transactional
    public void putReserve(String deviceId, DeviceReserveRequest request) {
        Device device = deviceRepository.findById(deviceId)
                .orElseThrow(() -> new BaseException(ErrorCode.NOTFOUND_DEVICE));

        device.changeMode(Mode.RESERVE);

        //예약 시간 만큼 스케쥴링 돌리기
    }

    @Override
    @Transactional
    public void putOptimal(String deviceId, DeviceOptimalRequest request) {
        Device device = deviceRepository.findById(deviceId)
                .orElseThrow(() -> new BaseException(ErrorCode.NOTFOUND_DEVICE));

        device.changeMode(Mode.OPTIMAL);

        //최적의 시간만큼 스케쥴링 돌리기
    }

    @Override
    @Transactional
    public void putTargetTemperature(String deviceId, PutTargetTemperatureRequest request) {
        nestApiClient.putTargetTemperature(TOKEN, deviceId, new TargetTemperatureRequest(request.getTargetTemperature()));
    }
}
