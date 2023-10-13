package corejava.collections;

import java.util.Arrays;

public class TestArray {

    static void min(int[] arr) {
        int min = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (min > arr[i]) {
                min = arr[i];
                System.out.println(min);
            }
        }
    }
    public static void main(String[] args) {
        int[] arr = {33,3,4,5};
        TestArray.min(arr);
//        int[] a = {10,20,30,40,50}
        int[] a = {33,3,4,5};
        ; // declaration and instantiation
        // normal for loop
        for (int i = 0; i < a.length; i++) {
            System.out.println(a[i]);
        }

        // foreach loop
        for (int j : a) {
            System.out.println((j * 5));
        }

        // comparison/sorting of elements in an array.
        for (int i = 0; i < a.length; i++) {
            for (int j = i+1; j < a.length; j++) {
                if (a[i] > a[j]) {
                    int temp = a[i];
                    a[i] = a[j];
                    a[j] = temp;
                }
            }
//            System.out.println(a[i]);
            System.out.println(Arrays.toString(a));
        }
    }
}
