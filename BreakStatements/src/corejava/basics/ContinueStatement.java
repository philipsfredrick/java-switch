package corejava.basics;

public class ContinueStatement {
    public static void main(String[] args) {
        // Declare variables
        int x = 1;
        int y = 10;
        // Using do while loop for using continue statement
        do {
            if (x == y/2) {
                x++;
                continue; // The continue statement skips that iteration and continues remaining statement
            }
            System.out.println(x);
            x++;
        } while (x <= y);
    }
}
