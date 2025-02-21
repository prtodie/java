import java.util.Scanner;

public class Main {

    @FunctionalInterface
    public interface IntBoolFunction {
        boolean check(int x);
    }

    public static void main(String[] args) {
        // Реализация функционального интерфейса
        IntBoolFunction isDivisibleBy31 = x -> x % 31 == 0;

        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите число: ");
        int x = scanner.nextInt();

        // Проверка числа и вывод результата
        if (isDivisibleBy31.check(x)) {
            System.out.println(x + " делится на 31 без остатка.");
        } else {
            System.out.println(x + " не делится на 31 без остатка.");
        }

        scanner.close();
    }
}