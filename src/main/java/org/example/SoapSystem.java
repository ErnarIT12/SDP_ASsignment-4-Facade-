package org.example;

public class SoapSystem {
    private static final int SOAP_PER_WASH = 100;

    private int soapMilliliters;
    private boolean applied;

    public SoapSystem(int soapMilliliters) {
        if (soapMilliliters < 0) {
            throw new IllegalArgumentException("Soap amount cannot be negative.");
        }
        this.soapMilliliters = soapMilliliters;
    }

    public void checkSoap() {
        if (soapMilliliters < SOAP_PER_WASH) {
            throw new IllegalStateException("Not enough soap for a full wash.");
        }
    }

    public void applySoap(WaterSystem water) {
        if (!water.isWet() || water.isRinsed() || applied) {
            throw new IllegalStateException("Soap needs a wet car without soap already applied.");
        }
        checkSoap();
        soapMilliliters -= SOAP_PER_WASH;
        applied = true;
        System.out.println("Soap: applying soap.");
    }

    public boolean isApplied() {
        return applied;
    }

    public int getSoapMilliliters() {
        return soapMilliliters;
    }

    public void reset() {
        applied = false;
    }
}