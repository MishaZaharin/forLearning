import java.util.Scanner;

public class Cycles {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        int count = 0;
        for (int i = 0; i < 10; i++) {
            if (console.hasNextInt())
                count++;
            console.nextLine();
        }
        System.out.println(count);
        System.out.println("=================================");
        int f = 1;
        for (int i = 1; i <= 10; i++) {
            f = f * i;
            System.out.println(f);
        }
        System.out.println("=================================");
        for (int i = 0; i < 10; i++)
        {
            int starCount = 10 - i;
            for (int j = 0; j < starCount; j++)
                System.out.print("*");
            System.out.println();
        }
        System.out.println("=================================");
        for (int i = 1; i <= 20; i++)
        {
            if ( (i % 7) == 0) continue;
            System.out.println(i);
        }
    }
}