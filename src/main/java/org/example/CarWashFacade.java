package org.example;

public class CarWashFacade {
    private final WaterSystem water;
    private final SoapSystem soap;
    private final BrushSystem brushes;
    private final DryerSystem dryer;

    public CarWashFacade() {
        this(120, 500);
    }

    public CarWashFacade(int waterLiters, int soapMilliliters) {
        water = new WaterSystem(waterLiters);
        soap = new SoapSystem(soapMilliliters);
        brushes = new BrushSystem();
        dryer = new DryerSystem();
    }

    public void washCar() {
        water.checkWater();
        soap.checkSoap();

        System.out.println("Starting car wash...");
        try {
            water.sprayWater();
            soap.applySoap(water);
            brushes.scrubCar(water, soap);
            water.rinseCar(brushes);
            dryer.dryCar(water);
            System.out.println("Car wash completed!");
        } finally {
            water.reset();
            soap.reset();
            brushes.reset();
        }
    }
}