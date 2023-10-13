package corejava.collections;

public class GetArrayName {
    public static void main(String[] args) {
        int[] arr = {4,4,5};
        Class<? extends int[]> c = arr.getClass();
        String name = c.getName();
        System.out.println(name);
    }
}
