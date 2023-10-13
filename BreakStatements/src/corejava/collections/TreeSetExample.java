package corejava.collections;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class TreeSetExample extends Thread{
    public static void main(String[] args) {
        int[] count = {34,22,10,60,30,22};
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < 5; i++) {
            set.add(count[i]);
        }
        TreeSet<Integer> sortedSet = new TreeSet<>(set);
        System.out.println("The sorted list is ");
        System.out.println(sortedSet);
        System.out.println("The first element of the set is: " + sortedSet.first());
        System.out.println("The first element of the set is: " + sortedSet.last());

    }
}
