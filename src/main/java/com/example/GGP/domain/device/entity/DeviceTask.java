package com.example.GGP.domain.device.entity;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;

import java.util.concurrent.ScheduledFuture;

@AllArgsConstructor(access = AccessLevel.PUBLIC)
public class DeviceTask {
    private ScheduledFuture<?> onTask;
    private ScheduledFuture<?> offTask;
    private Integer count;

    public Integer getCount() {
        return this.count;
    }

    public void reduceCount() {
        this.count--;
    }

    public void cancel() {
        this.onTask.cancel(true);
        this.offTask.cancel(true);
    }
}
