package corejava.multithreading;

public class Thread2 extends Thread{
    TestSynchronization t;

    public Thread2(TestSynchronization t) {
        this.t = t;
    }

    @Override
    public void run() {
//        super.run();
        t.printTable(100);
    }
}
