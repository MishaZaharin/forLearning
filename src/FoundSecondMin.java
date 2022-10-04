import java.util.Scanner;

public class FoundSecondMin {
/*
Второе минимальное число из введенных
*/
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int number1;
        int number2;
        int minNumber1;
        int minNumber2;
        number1 = scan.nextInt();
        number2 = scan.nextInt();
        if (number1 == number2) {
            minNumber1 = number1;
            minNumber2 = Integer.MAX_VALUE;
        } else {
            minNumber1 = number1 < number2 ? number1 : number2;
            minNumber2 = number1 > number2 ? number1 : number2;
        }
        while (scan.hasNextInt()) {
            number1 = scan.nextInt();
            if (number1 == minNumber1 || number1 == minNumber2) {
                continue;
            } else if (number1 < minNumber1) {
                minNumber2 = minNumber1;
                minNumber1 = number1;
            } else {
                if (number1 < minNumber2) {
                    minNumber2 = number1;
                }
            }
        }
        System.out.println(minNumber2);
        scan.close();
    }
}