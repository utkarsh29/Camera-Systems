package com.example.camerasystem.capture;

import java.util.Comparator;

public class CaptureRequestComparator implements Comparator<CaptureRequest> {

    @Override
    public int compare(CaptureRequest r1, CaptureRequest r2) {
        return Integer.compare(r2.getUrgency(), r1.getUrgency());
    }
}
