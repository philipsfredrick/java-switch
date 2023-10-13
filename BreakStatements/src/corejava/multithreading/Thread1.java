package corejava.multithreading;

public class Thread1 extends Thread{
    TestSynchronization t;

    public Thread1(TestSynchronization t) {
        this.t = t;
    }

    @Override
    public void run() {
//        super.run();
        t.printTable(5);
    }
}
