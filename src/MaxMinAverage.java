import java.util.Arrays;
import java.util.Scanner;

public class MaxMinAverage {
    /*
    Fill the array with random numbers.
    Print the maximum, minimum and average value.

    To generate a random number, use the Math.random() method, which returns a value in the range [0, 1].
    */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String yours = scanner.nextLine();
        int sizeArray = Integer.parseInt(yours);
        double[] arrayYour = new double[sizeArray];
        for (int i = 0; i < arrayYour.length; i++) {
            arrayYour[i] = Math.random();
        }
        System.out.println(Arrays.toString(arrayYour));
        double max = arrayYour[0];
        double min = arrayYour[0];
        double average = 0;
        for (int i = 0; i < arrayYour.length; i++) {
            if (max < arrayYour[i]) {
                max = arrayYour[i];
            }
            if (min > arrayYour[i]) {
                min = arrayYour[i];
            }
            average = average + arrayYour[i] / arrayYour.length;
        }
        System.out.println("max = " + max);
        System.out.println("min = " + min);
        System.out.println("average = " + average);
    }
}