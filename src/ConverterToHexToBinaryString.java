import java.util.regex.Pattern;
public class ConverterToHexToBinaryString {

    public static void main(String[] args) {
        String binaryNumber = "100111010000";
        System.out.println("Двоичное число " + binaryNumber + " равно шестнадцатеричному числу " + toHex(binaryNumber));
        String hexNumber = "9d0";
        System.out.println("Шестнадцатеричное число " + hexNumber + " равно двоичному числу " + toBinary(hexNumber));
    }

    public static String toHex(String binaryNumber) {
        //напишите тут ваш код
        String HEX = "0123456789abcdef";
        String toHex = "";
        int toDecimal = 0;

        if (binaryNumber == null || binaryNumber.equals("") || !Pattern.matches("[0-1]+", binaryNumber)) {
            return toHex;
        } else {

            for (int i = 0, j = binaryNumber.length() - 1; i < binaryNumber.length(); i++, j--) {
                toDecimal += Character.getNumericValue(binaryNumber.charAt(j)) * Math.pow(2, i);
            }
            while (toDecimal != 0) {
                toHex = HEX.charAt(toDecimal % 16) + toHex;
                toDecimal /= 16;
            }
            return toHex;
        }
    }

    public static String toBinary(String hexNumber) {
        //напишите тут ваш код
        String HEX = "0123456789abcdef";
        String toBinary = "";
        long toDecimal = 0;

        if (hexNumber == null || hexNumber.equals("") ||  !Pattern.matches("[0-9a-f]+", hexNumber)) {
            return toBinary;
        } else {
            for (int i = 0; i < hexNumber.length(); i++) {
                toDecimal = 16 * toDecimal + HEX.indexOf(hexNumber.charAt(i));
            }
            while (toDecimal != 0) {
                toBinary = (toDecimal % 2) + toBinary;
                toDecimal /= 2;
            }
            return toBinary;
        }
    }
}