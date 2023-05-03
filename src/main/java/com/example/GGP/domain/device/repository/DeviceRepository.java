package com.example.GGP.domain.device.repository;

import com.example.GGP.domain.device.entity.Device;
import org.springframework.data.repository.CrudRepository;

public interface DeviceRepository extends CrudRepository<Device, String> {
}
