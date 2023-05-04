package com.example.GGP.external.nest;

import com.example.GGP.external.nest.dto.ModeRequest;
import com.example.GGP.external.nest.dto.TargetTemperatureRequest;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

@FeignClient(name = "NestApiClient", url = "https://developer-api.nest.com")
public interface NestApiClient {

    @GetMapping("/devices/thermostats/{device_id}/ambient_temperature_c")
    Double getAmbientTemperature(@RequestHeader("Authorization") String accessToken, @PathVariable String device_id);

    @GetMapping("/devices/thermostats/{device_id}/target_temperature_c")
    Double getTargetTemperature(@RequestHeader("Authorization") String accessToken, @PathVariable String device_id);

    @GetMapping("/devices/thermostats/{device_id}/hvac_mode")
    String getMode(@RequestHeader("Authorization") String accessToken, @PathVariable String device_id);

    @PutMapping("/devices/thermostats/{device_id}/target_temperature_c")
    Double putTargetTemperature(@RequestHeader("Authorization") String accessToken, @PathVariable String device_id,
                                @RequestBody TargetTemperatureRequest request);

    @PutMapping("/devices/thermostats/{device_id}/hvac_mode")
    String putMode(@RequestHeader("Authorization") String accessToken, @PathVariable String device_id,
                   @RequestBody ModeRequest request);
}
