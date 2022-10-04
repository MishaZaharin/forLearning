import java.util.Scanner;

public class CharLikePartOfArray {
    public static void changeStr() {
        Scanner console = new Scanner(System.in);
        String path = console.nextLine();
        char[] chars = path.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == '/') {
                chars[i] = '\\';
            }
            String result = new String(chars);
            System.out.println(result);
        }
    }

    public static void changeStrAuto() {
        Scanner console = new Scanner(System.in);
        String path = console.nextLine();
        String[] array = path.split("/");
        String result = String.join("\\", array);
        System.out.println(result);
    }

    public static void main(String[] args) {
        changeStr();
        changeStrAuto();
    }
}