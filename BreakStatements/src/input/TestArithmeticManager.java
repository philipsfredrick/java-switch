package input;

import input.ArithmeticEngine;

import java.util.Scanner;

public class TestArithmeticManager {
    public static void main(String[] args) {
        try(Scanner scanner = new Scanner(System.in)) {
            System.out.println("Enter first and second number: ");
            double firstNumber = scanner.nextDouble();
            double secondNumber = scanner.nextDouble();

            ArithmeticEngine engine = new ArithmeticEngine(firstNumber, secondNumber);

            System.out.printf("%s + %s = %s", firstNumber, secondNumber,engine.addTwoNumbers());
            System.out.println();
            System.out.printf("%s - %s = %s", firstNumber, secondNumber, engine.subTwoNumbers());
            System.out.println();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
