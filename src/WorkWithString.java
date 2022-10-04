import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class WorkWithString {
    void buildDictionaryWithMap(String text) {
        /*
         * Будем перебирать все символы в строке, и
         * если это символ алфавита русского языка,
         * обновляем значение в Map.
         *
         * Потом возьмём все Map.Entry<Character, Integer>,
         * и отсортируем по ключу (Character)
         *
         * @param text - текст
         */
        text = text.toLowerCase();
        Map<Character, Integer> characterIntegerMap = new HashMap<>();
        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            if ((ch >= 'а' && ch <= 'я') || ch == 'ё') {
                characterIntegerMap.compute(ch, (character, integer) -> {
                    if (integer == null) return 1;
                    return integer + 1;
                });
            }

        }
        ArrayList<Map.Entry<Character, Integer>> entries = new ArrayList<>(characterIntegerMap.entrySet());
        entries.sort((o1, o2) -> Character.compare(o1.getKey(), o2.getKey()));
        for (Map.Entry<Character, Integer> entry : entries) {
            System.out.println(entry.getKey() + "" + entry.getValue());
        }
    }

    void buildDictionary(String text) {
        /*
         * Вариант без Map.
         * Создадим массив нужной длины, и будем хранить
         * в соответствующих позициях количество вхождений
         * символов
         */
        text = text.toLowerCase();
        int[] result = new int['я' - 'а' + 1];
        for (int i = 0; i < result.length; i++) {
            char ch = text.charAt(i);
            if (ch >= 'а' && ch <= 'я') {
                result[ch - 'а']++;
            }
        }
        for (int i = 0; i < result.length; i++) {
            System.out.println((char) (i + 'а') + " = " + result[i]);
        }
    }

    void workAtStringMethods() {
        String str0 = ".1111.0000.1111.1100.0011";
        String str2 = ".9999";
        StringBuilder stringBuilder = new StringBuilder(str0);
        stringBuilder.append(str2);
        System.out.println(stringBuilder);
        StringBuilder stringBuilder2 = new StringBuilder(stringBuilder);
        stringBuilder2.append(str2);
        System.out.println(stringBuilder2);
        StringBuilder stringBuilder3 = new StringBuilder();
        stringBuilder3.append(stringBuilder2);
        stringBuilder3.replace(0, 5, str2);
        System.out.println(stringBuilder3);
        String str = "11110000111111000011";
        String[] fromStr = str.split("");
        System.out.println(Arrays.toString(fromStr));
        String[][] strFrom = new String[fromStr.length / 4][4];
        int counter = 0;
        for (int i = 0; i < fromStr.length / 4; i++) {
            for (int j = 0; j < 4; j++) {
                strFrom[i][j] = fromStr[counter];
                counter++;
            }
        }
        System.out.println(Arrays.deepToString(strFrom));
    }
}