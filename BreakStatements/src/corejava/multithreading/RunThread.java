package corejava.multithreading;

public class RunThread implements Runnable{
    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            System.out.println("Thread running "+i);
        }
    }
}
