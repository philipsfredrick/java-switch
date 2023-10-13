package corejava.basics;

public class Example {
    private int x;
    private static int y;

    static {
        y = 10;
    }

    public Example() {
        System.out.println(x);
        System.out.println(y);
        System.out.println("Constructor for corejava.basics.Example class");
    }
}
