import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        // Запрашиваем количество чисел у пользователя
        System.out.print("Введите количество чисел: ");
        int n = scanner.nextInt();
        int[] numbers = new int[n];


        // Ввод чисел
        System.out.println("Введите числа:");
        for (int i = 0; i < n; i++) {
            numbers[i] = scanner.nextInt();
        }


        scanner.close();


        int minUniqueDigits = Integer.MAX_VALUE; // Минимальное количество уникальных цифр
        int resultNumber = numbers[0]; // Число с минимальным количеством различных цифр


        // Проходим по всем введенным числам
        for (int number : numbers) {
            int uniqueDigits = countUniqueDigits(number);
            if (uniqueDigits < minUniqueDigits) {
                minUniqueDigits = uniqueDigits;
                resultNumber = number;
            }
        }


        // Выводим результат
        System.out.println("Число с минимальным количеством различных цифр: " + resultNumber);
    }


    // Метод для подсчета количества уникальных цифр в числе
    private static int countUniqueDigits(int number) {
        boolean[] digits = new boolean[10]; // Массив для отслеживания цифр
        int count = 0;


        // Разбираем число по цифрам
        while (number > 0) {
            int digit = number % 10;
            if (!digits[digit]) { // Если цифра ещё не встречалась, увеличиваем счетчик
                digits[digit] = true;
                count++;
            }
            number /= 10;
        }


        return count; // Возвращаем количество уникальных цифр
    }
}
