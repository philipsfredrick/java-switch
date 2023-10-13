package com.interswitch.services;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

    Calculator calculator;

    @BeforeEach
    void setUp() {
        calculator = new Calculator();
    }


    @Test
    @DisplayName("Test for the addition in Calculator class")
    void add() {
        assertEquals(5, calculator.add(2,3));
        assertNotEquals(20, calculator.add(4,5));
    }

    @Test
    @DisplayName("Test for subtraction in Calculator")
    void subtract() {
     assertEquals(8, calculator.subtract(10,2));
     assertNotEquals(20, calculator.subtract(100,20));
    }

    @AfterEach
    void tearDown() {
        System.out.println("End of unit testing");
    }
}