package com.example.camerasystem.capture;

import com.example.camerasystem.callbacks.SuccessCallback;
import com.example.camerasystem.callbacks.FailureCallback;

public class CaptureRequest {
    private int urgency;
    private SuccessCallback successCallback;
    private FailureCallback failureCallback;

    public CaptureRequest(int urgency, SuccessCallback successCallback, FailureCallback failureCallback) {
        this.urgency = urgency;
        this.successCallback = successCallback;
        this.failureCallback = failureCallback;
    }

    public int getUrgency() {
        return urgency;
    }

    public SuccessCallback getSuccessCallback() {
        return successCallback;
    }

    public FailureCallback getFailureCallback() {
        return failureCallback;
    }
}
