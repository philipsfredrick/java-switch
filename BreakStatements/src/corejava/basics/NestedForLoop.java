package corejava.basics;

public class NestedForLoop {
    public static void main(String[] args) {
        // loop of i
        for (int i = 1; i <= 4; i++) {
            // loop of j
            for (int j = 1; j <= i; j++) {
//                System.out.println(i + " " + j);
                System.out.print("* ");
            } // end of j

            System.out.println();
        } // end of i
    }
}
