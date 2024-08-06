package com.example.camerasystem.camera;

import com.example.camerasystem.capture.CaptureRequest;
import com.example.camerasystem.capture.CaptureRequestComparator;

import java.util.concurrent.PriorityBlockingQueue;

public class CameraSystem {
    private final PriorityBlockingQueue<CaptureRequest> requestQueue;
    private CameraInterface cameraInterface;

    public CameraSystem(CameraInterface cameraInterface) {
        this.cameraInterface = cameraInterface;
        this.requestQueue = new PriorityBlockingQueue<>(100, new CaptureRequestComparator());
    }

    public void submitRequest(CaptureRequest request) {
        requestQueue.add(request);
    }

    public CaptureRequest getNextRequest() {
        return requestQueue.poll();
    }

    public CameraInterface getCameraInterface() {
        return cameraInterface;
    }
}
