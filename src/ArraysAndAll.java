import java.util.Arrays;
import java.util.Scanner;

public class ArraysAndAll {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("enter any number ");
        String yours = scanner.nextLine();
        int sizeArray = Integer.parseInt(yours);
        System.out.println(Arrays.toString(doubleArrayYour(sizeArray)));
        System.out.println("* * *");
        System.out.println(Arrays.toString(intArrayYour(sizeArray)));
        System.out.println("* * *");
        System.out.println(Arrays.toString(removedElement(intArrayYour(sizeArray), 21)));
    }

    public static double[] doubleArrayYour(int a) {
        double[] doubleArrayYour = new double[a];
        for (int i = 0; i < doubleArrayYour.length; i++) {
            doubleArrayYour[i] = Math.random();
        }
        return doubleArrayYour;
    }

    public static int[] intArrayYour(int b) {
        int[] intArrayYour = new int[b];
        for (int i = 0; i < intArrayYour.length; i++) {
            intArrayYour[i] = randomInRange(99, 1);

        }
        return intArrayYour;
    }

    public static int randomInRange(int max, int min) {
        return (int) (Math.random() * ((max - min) + 1) + min);
    }

    /*
    Searches an array of integers for a given integer.
    Removes all occurrences of the given arrayYour from the array, reduces the size of the array.
    0 1 2 3 4 5
    3
    0 1 2 4 5
    */
    public static int[] removedElement(int[] arrayYour, int value) {
        System.out.println(Arrays.toString(arrayYour));
        int offset = 0;
        for (int i = 0; i < arrayYour.length; i++) {
            if (arrayYour[i] == value) {
                offset++;
            } else {
                arrayYour[i - offset] = arrayYour[i];
            }
        }
        return Arrays.copyOf(arrayYour, arrayYour.length - offset);
    }


    public static int[][] result(int[][] result) {
        result = new int[10][];
        for (int i = 0; i < result.length; i++) {
            result[i] = new int[i + 1];
            for (int j = 0; j < result[i].length; j++) {
                result[i][j] = (i) + (j);
            }
        }
        return result;
    }

    public static int[][][] threeMultiArray(int[][][] multiArray) {
        multiArray = new int[][][]{{{4, 8, 15}, {16}}, {{23, 42}, {}}, {{1}, {2}, {3}, {4, 5}}};
        for (int i = 0; i < multiArray.length; i++) {
            for (int j = 0; j < multiArray[i].length; j++) {
                for (int k = 0; k < multiArray[j].length; k++) {

                }
            }
        }
        return multiArray;
    }
    void workWithArrayInt(int[] array) {
        array = new int[]{1, 5, 4, 3, 7}; //объявляем и инициализируем массив
        System.out.println(array);//пытаемся вывести наш массив на экран без метода toString - получаем 16-ричное число
        System.out.println(Arrays.toString(array));//печатаем массив "правильно"
        Arrays.sort(array, 0, 4); //сортируем весь массив от нулевого до четвёртого члена
        System.out.println(Arrays.toString(array));//выводим отсортированный массив на экран
        int key = Arrays.binarySearch(array, 5); // ищем key - число 5 в отсортированном массиве.
        //метод binarySearch выдаст индекс элемента остортированного массива, в котором "спрятано" искомое число
        System.out.println(key);//распечатываем индекс искомого числа
        System.out.println(Arrays.binarySearch(array, 0));//а теперь попробуем найти число, которого в массиве нет,
        // и сразу же выведем результат на экран
    }
}