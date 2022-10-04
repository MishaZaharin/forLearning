import java.util.Arrays;
import java.util.Scanner;

/*
Shuffle sort or Shaker sort or bidirectional sort
 */
public class CocktailSort {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String yours = scanner.nextLine();
        int sizeArray = Integer.parseInt(yours);
        //ideal - make it a separate method, for fill your array
        double[] arrayYour = new double[sizeArray];
        for (int i = 0; i < arrayYour.length; i++) {
            arrayYour[i] = Math.random();
        }
        System.out.println(Arrays.toString(arrayYour));
        //ideal - make it a separate method too, for sort your array
        double center;
        int left = 0;
        int right = arrayYour.length - 1;
        do {
            for (int i = left; i < right; i++) {
                if (arrayYour[i] > arrayYour[i + 1]) {
                    center = arrayYour[i];
                    arrayYour[i] = arrayYour[i + 1];
                    arrayYour[i + 1] = center;
                }
            }
            right--;
            for (int i = right; i > left; i--) {
                if (arrayYour[i] < arrayYour[i - 1]) {
                    center = arrayYour[i];
                    arrayYour[i] = arrayYour[i - 1];
                    arrayYour[i - 1] = center;
                }
            }
            left++;
        } while (left < right);
        System.out.println(Arrays.toString(arrayYour));
    }
}