public class RaiseNumberToPower {

    public static void main(String[] args) {
        // *** while
        int number = 3; // Возводимое в степень число
        int result = 1; // Результат возведения в степень
        int power = 1; // Начальный показатель степени
        while (power <= 10) { // условие входа в цикл
            result = result * number;
            System.out.println(number + " в степени " + power + " = " + result);
            power++;
        }
        // *** do - while
        int number1 = 3;// Возводимое в степень число
        int result1 = number1;// Результат возведения в степень
        int power1 = 1;// Начальный показатель степени
        do {
            System.out.println(number1 + " в степени " + power1 + " = " + result1);
            power1++;
            result1 = result1 * number1;
        } while (result1 < 10000); // условие выхода из цикла
        // *** while - if - continue
        int sum = 0;    // итоговая сумма
        int i = 0;      // стартовое число ряда
        int count = 20; // количество чисел
        while (i <= count) {
            i++;        // берем очередное число, i++ эквивалентно i=i+1
            if (i * i <= count)  // если квадрат числа меньше
                continue;   // количества чисел - сумму не считаем
            // переходим к следующему числу в цикле
            sum += i * i * i; // иначе считаем сумму кубов чисел
        } // sum += i*i*i - форма записи, аналогичная sum = sum + i*i*i
        System.out.println(sum);// печатаем результат
        // *** while - boolean - if - break
        int number3 = 3; // Возводимое в степень число
        int result3 = 1; // Результат возведения в степень
        int power3 = 1; // Начальный показатель степени
        while (true) {
            result3 = result3 * number3;
            System.out.println(number3 + " в степени " + power3 + " = " + result3);
            power3++;
            if (power3 > 10)
                break; // выход из цикла
        }
    }
}
