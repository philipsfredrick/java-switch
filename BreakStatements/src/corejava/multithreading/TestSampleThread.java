package corejava.multithreading;

public class TestSampleThread {
    public static void main(String[] args) {

        Thread t;
        Thread t1;
        while (true) {
            t = new Thread(new SampleThread(), "first");
            t1 = new Thread(new SampleThread(), "second");
            t.start();
            t1.start();
        }
    }
}
