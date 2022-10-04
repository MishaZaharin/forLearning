import java.util.Arrays;

public class ArrayMethod {
    public static void fillAllCellsAssignNewValue(int[][] data, int value) { //Метод проходится по всем ячейкам переданного двумерного массива и присваивает им значение value.
        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < data[i].length; j++) {
                data[i][j] = value;
            }
        }
    }

    public static void fillPartOfArray(int[] data, int to, int from, int value) { //Метод fill заполняет часть переданного массива значением value.
        if (from < 0 || to > data.length) // Часть массива определяется индексами from и to.
            return; //Если from меньше 0 или to больше длины массива, метод тут же завершается.
        for (int i = from; i < to; i++) {
            data[i] = value;
        }
    }

    public static int minNumber(int a, int b) { // Метод возвращает минимум из двух чисел.
        if (a < b) // Если a < b вернуть a.
            return a;
        else // Иначе вернуть b.
            return b;
    }

    public static String multiplySomething(String str, int times) { // Метод дублирует переданную в него строку n раз.
        String result = ""; // Создается пустая строка для будущего результата.
        for (int i = 0; i < times; i++) // В цикле times раз
            result = result + " " + str; // к строке result добавляется пробел и строка str.
        return result; // В качестве результата метода возвращается переменная result.
    }

    public static void main(String[] args) { ////Метод fill заполняет массива
        int[][] newMonths = {{31, 28}, {31, 30, 31}, {30, 31, 31}};
        fillAllCellsAssignNewValue(newMonths, 8); // Создаем двумерный массив и заполняем весь массив числом 8.
        int[] monthArray = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12};
        fillPartOfArray(monthArray, 2, 10, 8);
        minNumber(8, 9);
        multiplySomething("-", 10);
        System.out.println(Arrays.toString(monthArray));
    }
}