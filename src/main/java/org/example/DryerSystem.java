package org.example;

public class DryerSystem {
    public void dryCar(WaterSystem water) {
        if (!water.isWet() || !water.isRinsed()) {
            throw new IllegalStateException("Rinse the car before drying.");
        }
        water.finishDrying();
        System.out.println("Dryer: drying the car.");
    }
}