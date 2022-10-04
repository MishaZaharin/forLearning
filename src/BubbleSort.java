import java.util.Arrays;
import java.util.Scanner;
/*
Sorting by simple exchanges, bubble sort
 */
public class BubbleSort {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String yours = scanner.nextLine();
        int sizeArray = Integer.parseInt(yours);
        double[] arrayYour = new double[sizeArray];
        for (int i = 0; i < arrayYour.length; i++) {
            arrayYour[i] = Math.random();
        }
        System.out.println(Arrays.toString(arrayYour));
        for (int i = 0; i < arrayYour.length; i++) {
            for (int j = 0; j < arrayYour.length - i - 1; j++) {
                if (arrayYour[j] > arrayYour[j + 1]) {
                    double tempArray = arrayYour[j];
                    arrayYour[j] = arrayYour[j + 1];
                    arrayYour[j + 1] = tempArray;
                }
            }
        }
        System.out.println(Arrays.toString(arrayYour));
    }
}