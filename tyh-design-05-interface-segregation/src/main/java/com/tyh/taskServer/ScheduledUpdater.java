package com.tyh.taskServer;

import com.tyh.configuration.interf.Updater;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * @Description: ScheduledUpdater，定时任务服务
 * @Author: 青衣醉
 * @Date: 2023/4/27 2:29 下午
 */
public class ScheduledUpdater {
    private final ScheduledExecutorService executor = Executors.newSingleThreadScheduledExecutor ();
    private long initialDelayInSeconds;
    private long periodInSeconds;
    private Updater updater;
    public ScheduledUpdater(long initialDelayInSeconds, long periodInSeconds, Updater updater) {
        this.initialDelayInSeconds = initialDelayInSeconds;
        this.periodInSeconds = periodInSeconds;
        this.updater = updater;
    }
    public void start() {
        executor.scheduleAtFixedRate (new Runnable () {
            @Override
            public void run() {
                updater.update();
            }
        }, initialDelayInSeconds, periodInSeconds, TimeUnit.MILLISECONDS);
    }

}
