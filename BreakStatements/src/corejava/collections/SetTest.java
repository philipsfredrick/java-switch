package corejava.collections;

import java.util.HashSet;
import java.util.Set;

public class SetTest {
    public static void main(String[] args) {
        int[] count = {34,22,10,60,30,22};
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < 5; i++) {
            set.add(count[i]);
        }
        System.out.println(set);
    }
}
