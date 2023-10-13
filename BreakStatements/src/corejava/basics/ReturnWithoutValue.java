package corejava.basics;

public class ReturnWithoutValue {

    public void increment(int number) {
        if (number < 10) {
            return;
        }
        number++;
        System.out.println(number);
    }

    public static void main(String[] args) {
        ReturnWithoutValue obj = new ReturnWithoutValue();
        obj.increment(1);
    }
}
