package corejava.basics;

public class SimpleCalculator {
    static double squareNumber(double number) {
        return Math.pow(number, 2.0);
    }

    static void displayArray(int[][] values) {
        if (values == null || values.length == 0)
            System.out.println("Array cannot be empty");

        for (int row = 0; row < values.length; row++) {
            for (int col = 0; col < values[row].length; col++) {
                System.out.print(values[row][col] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        System.out.println("Find square of a number.");
        System.out.println(squareNumber(0));
        System.out.println("Display content of 2D array");
        displayArray(new int[][]{{3,6,7},{6,8,9}, {3,6,7}});
    }
}
