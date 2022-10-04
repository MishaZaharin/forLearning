import java.util.Arrays;

public class TurnOverArray {

    public static void main(String[] args) {
        int[] array = {11, 22, 33, 44, 55, 66, 77, 88, 99};
        System.out.println(Arrays.toString(array)); // print array
        int[] reversedArray = reverse(array);
        System.out.println(Arrays.toString(reversedArray)); // print reversed array
    }
    // Method returns a new reversed array, based on the array which was passed to it.
    static int[] reverse(int[] array) {
        int[] newArray = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            newArray[array.length - 1 - i] = array[i];
        }
        return newArray;
    }
}