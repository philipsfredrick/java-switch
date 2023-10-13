package corejava.basics;

public class LabeledBreakExample {
    public static void main(String[] args) {
        int j, k;
        // labelling the outermost loop as outerMost
        outerMost:
        for (j = 1; j < 5; j++) {
            // Labelling the innermost loop as innerMost
            innerMost:
            for (k = 1; k < 3; k++) {
                System.out.println("j = " + j + " and k = " + k);
                // Terminating the outermost loop
                if (j == 3)
                    break outerMost;
            }
        }
    }
}
