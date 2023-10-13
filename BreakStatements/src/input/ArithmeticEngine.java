package input;

public class ArithmeticEngine {

    private double firstNumber;

    private double secondNumber;

    public ArithmeticEngine(double firstNumber, double secondNumber) {
        this.firstNumber = firstNumber;
        this.secondNumber = secondNumber;
    }

    public double addTwoNumbers() {
        return this.firstNumber + this.secondNumber;
    }

    public double subTwoNumbers() {
        return this.firstNumber - this.secondNumber;
    }

    public double getFirstNumber() {
        return firstNumber;
    }

    public void setFirstNumber(double firstNumber) {
        this.firstNumber = firstNumber;
    }

    public double getSecondNumber() {
        return secondNumber;
    }

    public void setSecondNumber(double secondNumber) {
        this.secondNumber = secondNumber;
    }
}
