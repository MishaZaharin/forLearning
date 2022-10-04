import java.util.Scanner;

public class SortArrayIntMaxMin {
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        int n = keyboard.nextInt();
        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = keyboard.nextInt();
        }
        if (n % 2 != 0) {
            for (int i = 0; i < n; i++) {
                System.out.println(array[i]);
            }
        } else {
            for (int i = n; i > 0; i--) {
                System.out.println(array[i - 1]);
            }
        }
    }
}