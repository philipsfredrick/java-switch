package corejava.collections;

public class TestReturnArray {
    // creating method which returns an array
    static int[] get() {
        return  new int[]{10,30,50,90,60};
    }

    public static void main(String[] args) {
        // calling method which returns an array
        int []arr = get();
        // printing the values of an array
        for (int j : arr) {
            System.out.println(j);
        }
    }
}
