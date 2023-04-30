package com.example.GGP.domain.device.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DeviceController {

    @GetMapping("/devices")
    String getDevice() {
        return "success";
    }
}
