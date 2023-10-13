package com.interswitch.services;

public class Circle implements Drawable {

    public static final double PI = 3.14159265358979323846;

    private double radius;

    public Circle() {
    }

    public Circle(double radius) {
        this.radius = radius;
    }

    public double calculateArea() {
        return Math.round(PI * radius * radius);
    }

    public double getRadius() {
        return radius;
    }

    @Override
    public void draw() {
        System.out.println("Drawing a circle");
    }
}
