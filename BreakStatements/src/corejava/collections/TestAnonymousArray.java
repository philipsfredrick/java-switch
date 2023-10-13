package corejava.collections;

public class TestAnonymousArray {
    // creating a method which receives an array as a parameter
    static void printArray(int[] arr) {
        for (int j : arr) {
            System.out.println(j);
        }
    }

    public static void main(String[] args) {
        // passing an anonymous array to method.
        printArray(new int[]{10,22,44,66});
    }
}
