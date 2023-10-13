package com.interswitch.services;

public class Rectangle extends Shape {

    private int length;

    private int breadth;


    public Rectangle() {
    }

    public Rectangle(int length, int breadth) {
        this.length = length;
        this.breadth = breadth;
    }

    public int calculateArea() {
      return this.breadth * this.length;
    }

    public int getLength() {
        return length;
    }

    public int getBreadth() {
        return breadth;
    }

    @Override
    public double area() {
        return this.length * this.breadth;
    }
}
