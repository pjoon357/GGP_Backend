package com.example.GGP.external.GGAI;

import com.example.GGP.external.GGAI.dto.OptimalResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

@FeignClient(name = "GGAIApiClient", url = "http://localhost")
public interface GGAIApiClient {

    @GetMapping("/optimal")
    OptimalResponse getOptimalTime(@RequestParam Double currentTemperature, @RequestParam String homecomingTime);
}
