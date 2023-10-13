package corejava.multithreading;

public class TestSynchronization {
    synchronized void printTable(int n) {
        // method not synchronized
        for (int i = 0; i < 5; i++) {
            System.out.println(n * i);
            try {
                Thread.sleep(400);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
