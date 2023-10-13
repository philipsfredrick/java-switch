
public class Calculator {
	public static void main(String []args) {
	Addition addition = new Addition();
	Multiplication multiply = new Multiplication();

	System.out.println(addition.add(4,5));
	System.out.println(multiply.multiply(2,3));
	System.out.println(Multiplication.class.getClassLoader());
}

}