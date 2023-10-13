package com.interswitch.assignment.inheritance;

public class Vehicle {

    private int seatingCapacity;
    private int fare;
    private static int DEFAULT_CHARGE = 100;

    public Vehicle() {
    }

    public Vehicle(int seatingCapacity) {
        this.seatingCapacity = seatingCapacity;
    }


    public int getSeatingCapacity() {
        return seatingCapacity;
    }

    public int fare() {
        return this.fare = this.seatingCapacity * DEFAULT_CHARGE;
    }
}
