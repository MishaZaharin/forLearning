import java.util.Arrays;
import java.util.Scanner;
/*
array and one integer.
Remove all occurrences of this number from the array (there should be no gaps).
 */
public class EditArray {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(removeElement(makeArray(), 5)));
    }

    public static int[] removeElement(int[] numbers, int value) {
        int offSet = 0;
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] == value) {
                offSet++;
            } else {
                numbers[i - offSet] = numbers[i];
            }
        }
        return Arrays.copyOf(numbers, numbers.length - offSet);
    }
    public static int[] makeArray(){
        Scanner scanner = new Scanner(System.in);
        String yours = scanner.nextLine();
        int sizeArray = Integer.parseInt(yours);
        int[] arrayYour = new int[sizeArray];
        for (int i = 0; i < arrayYour.length; i++) {
            arrayYour[i] = (int) (Math.random() * 10 + 1);
        }
        System.out.println(Arrays.toString(arrayYour));
        return Arrays.copyOf(arrayYour, sizeArray);
    }
}