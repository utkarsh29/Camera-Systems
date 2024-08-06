package com.example.camerasystem.scheduler;

import com.example.camerasystem.capture.CaptureRequest;
import com.example.camerasystem.camera.CameraSystem;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Scheduler {
    private final ScheduledExecutorService executorService;
    private final CameraSystem cameraSystem;

    public Scheduler(int numberOfThreads, CameraSystem cameraSystem) {
        this.executorService = Executors.newScheduledThreadPool(numberOfThreads);
        this.cameraSystem = cameraSystem;
    }

    public void startProcessing() {
        executorService.scheduleAtFixedRate(() -> {
            CaptureRequest request = cameraSystem.getNextRequest();
            if (request != null) {
                executorService.submit(() -> cameraSystem.getCameraInterface().captureImage(request));
            }
        }, 0, 100, TimeUnit.MILLISECONDS);
    }

    public void shutdown() {
        executorService.shutdown();
        try {
            if (!executorService.awaitTermination(60, TimeUnit.SECONDS)) {
                executorService.shutdownNow();
            }
        } catch (InterruptedException e) {
            executorService.shutdownNow();
            Thread.currentThread().interrupt();
        }
    }
}
