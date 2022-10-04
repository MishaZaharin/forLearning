import java.util.Arrays;
import java.util.Scanner;

public class ArrayStringY {
    public static String[] arrayStrYour;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        arrayStrYour = new String[6];
        String some;
        for (int i = 0; i < arrayStrYour.length; i++) {
            arrayStrYour[i] = scanner.nextLine();
        }
        for (int i = 0; i < arrayStrYour.length; i++) {
            if (arrayStrYour[i] == null)
                continue;
            some = new String(arrayStrYour[i]);
            for (int j = (i + 1); j < arrayStrYour.length; j++) {
                if (some.equals(arrayStrYour[j])) {
                    arrayStrYour[i] = null;
                    arrayStrYour[j] = null;
                }
            }
        }
        System.out.println(Arrays.toString(arrayStrYour));
    }
}