package org.example;

public class Main {
    public static void main(String[] args) {
        CarWashFacade carWash = new CarWashFacade();
        try {
            carWash.washCar();
        } catch (IllegalStateException e) {
            System.err.println("Car wash failed: " + e.getMessage());
            System.exit(1);
        }
    }
}