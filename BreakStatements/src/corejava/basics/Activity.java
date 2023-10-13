package corejava.basics;

public class Activity {

    public int squareNumber(int n) {
        return n * n;
    }

    public void display(int[][] s) {
        for (int[] ints : s) {
            for (int j = 0; j < s.length; j++) {
                System.out.print(ints[j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Activity activity = new Activity();
        System.out.println(activity.squareNumber(9));
        activity.display(new int[][]{{2,3,4},{4,6,8},{9,6,4}});
    }
}
