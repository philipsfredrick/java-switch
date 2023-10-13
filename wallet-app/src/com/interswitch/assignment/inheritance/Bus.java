package com.interswitch.assignment.inheritance;

public class Bus extends Vehicle {

    private static final double MAINTENANCE_CHARGE = 0.1f;

    public Bus() {
    }

    public Bus(int seatingCapacity) {
        super(seatingCapacity);
    }

    @Override
    public int fare() {
        return (int) (super.fare() + (super.fare() * MAINTENANCE_CHARGE));
    }
}
