package corejava.exceptionhandling;

import java.io.FileReader;
import java.io.IOException;

public class TryWithResources {
    public static void main(String[] args) {
        try(FileReader fr = new FileReader("file.txt")) {
            char[] a = new char[50];
            fr.read(a);
            for (char arr: a) {
                System.out.println(arr);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
