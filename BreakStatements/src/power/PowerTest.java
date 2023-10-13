package power;

import java.util.Scanner;

public class PowerTest {
    public static void main(String[] args) {
        try(Scanner scanner = new Scanner(System.in)) {
            System.out.println("Enter first and second number: ");
            double base = scanner.nextDouble();
            double index = scanner.nextDouble();

            PowerValues powerValues = new PowerValues(base,index);
            System.out.printf("%s ^ %s = %s", base, index, powerValues.powerRaiseMethod(base, index));
            System.out.println();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
