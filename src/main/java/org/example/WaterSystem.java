package org.example;

public class WaterSystem {
    private static final int PREWASH_LITERS = 20;
    private static final int RINSE_LITERS = 30;

    private int waterLiters;
    private boolean wet;
    private boolean rinsed;

    public WaterSystem(int waterLiters) {
        if (waterLiters < 0) {
            throw new IllegalArgumentException("Water amount cannot be negative.");
        }
        this.waterLiters = waterLiters;
    }

    public void checkWater() {
        if (waterLiters < PREWASH_LITERS + RINSE_LITERS) {
            throw new IllegalStateException("Not enough water for a full wash.");
        }
    }

    public void sprayWater() {
        if (wet) {
            throw new IllegalStateException("The car is already wet.");
        }
        checkWater();
        waterLiters -= PREWASH_LITERS;
        wet = true;
        rinsed = false;
        System.out.println("Water: spraying the car.");
    }

    public void rinseCar(BrushSystem brushes) {
        if (!wet || rinsed || !brushes.isCleaned()) {
            throw new IllegalStateException("Clean the car with brushes before rinsing.");
        }
        waterLiters -= RINSE_LITERS;
        rinsed = true;
        System.out.println("Water: rinsing the car.");
    }

    public boolean isWet() {
        return wet;
    }

    public boolean isRinsed() {
        return rinsed;
    }

    public int getWaterLiters() {
        return waterLiters;
    }

    void finishDrying() {
        wet = false;
    }

    public void reset() {
        wet = false;
        rinsed = false;
    }
}