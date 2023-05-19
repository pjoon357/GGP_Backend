package com.example.GGP.domain.device.service;

import com.example.GGP.domain.device.entity.Device;
import com.example.GGP.domain.device.entity.DeviceTask;
import com.example.GGP.domain.stats.service.StatsService;
import com.example.GGP.external.nest.dto.ModeRequest;
import com.example.GGP.external.testnest.TestNestApiClient;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.TaskScheduler;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.time.Instant;
import java.time.LocalDateTime;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ScheduledFuture;

@Component
@RequiredArgsConstructor
public class DeviceScheduler {
    private Map<String, DeviceTask> scheduledTasks = new ConcurrentHashMap<>();

    private final TaskScheduler taskScheduler;

    private final StatsService statsService;

    //private final NestApiClient nestApiClient;

    private final TestNestApiClient nestApiClient;

    private static final String TOKEN = "token";

    public void register(Device device, int offTime, int iter) {
        ScheduledFuture<?> onTask = taskScheduler.scheduleAtFixedRate(() -> onDevice(device), Duration.ofMinutes(offTime));

        ScheduledFuture<?> offTask = taskScheduler.scheduleAtFixedRate(() -> offDevice(device),
                Instant.now().plusSeconds(60L * device.getChargeTime()), Duration.ofMinutes(offTime));

        scheduledTasks.put(device.getId(), new DeviceTask(onTask, offTask, iter));
    }

    public void remove(Device device) {
        scheduledTasks.get(device.getId()).cancel();
        scheduledTasks.remove(device.getId());
    }

    private void onDevice(Device device) {
        device.setOnTime(LocalDateTime.now().toString());
        nestApiClient.putMode(TOKEN, device.getId(), new ModeRequest("heat"));
    }

    private void offDevice(Device device) {
        device.setOffTime(LocalDateTime.now().toString());

        statsService.addStats(device);

        nestApiClient.putMode(TOKEN, device.getId(), new ModeRequest("off"));

        DeviceTask task = scheduledTasks.get(device.getId());
        task.reduceCount();

        if (task.getCount() <= 0) {
            remove(device);
        }
    }
}
