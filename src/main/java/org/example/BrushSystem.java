package org.example;

public class BrushSystem {
    private boolean cleaned;

    public void scrubCar(WaterSystem water, SoapSystem soap) {
        if (!water.isWet() || water.isRinsed() || !soap.isApplied() || cleaned) {
            throw new IllegalStateException("Brushes need a wet, soaped car that has not been scrubbed.");
        }
        cleaned = true;
        System.out.println("Brushes: cleaning the car.");
    }

    public boolean isCleaned() {
        return cleaned;
    }

    public void reset() {
        cleaned = false;
    }
}