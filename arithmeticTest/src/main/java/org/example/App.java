package org.example;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        Operations operations = new Operations();

        System.out.println(operations.add(1,2));
        System.out.println(operations.multiply(2, 3));
        System.out.println(operations.division(10,2));
        System.out.println(operations.subtract(17, 6));
//        System.out.println( "Hello World!" );
    }
}
