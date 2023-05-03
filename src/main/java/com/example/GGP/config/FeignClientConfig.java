package com.example.GGP.config;

import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Configuration;


@EnableFeignClients(basePackages = "com.example.GGP")
@Configuration
public class FeignClientConfig {

}
