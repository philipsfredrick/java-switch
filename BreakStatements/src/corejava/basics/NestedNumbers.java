package corejava.basics;

public class NestedNumbers {
    public static void main(String[] args) {
        // loop of i
        int num = 1;

        for (int i = 1; i <= 4; i++) {
            // loop of j
            for (int j = 1; j <= 10; j++) {
//                System.out.println(i + " " + j);
                System.out.print(num + " ");
                num++;
            } // end of j
            System.out.println();
        } // end of i
    }
}
