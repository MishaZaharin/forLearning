/*
finds natural numbers from 0 to 100
 */
public class SearchForNaturalNumbers {
    public static void main(String[] args) {
        for (int a = 2; a < 100; a++) {
            boolean isNatural = true;
            for (int b = 2; b < a; b++) {
                if (a % b == 0) {
                    isNatural = false;
                    break;
                }
            }
            if (isNatural) {
                System.out.print(" | " + a);
            }
        }
    }
}