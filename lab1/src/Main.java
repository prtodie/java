import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        // строка образец
        final String CORRECT_PASSWORD = "123";


        Scanner scanner = new Scanner(System.in);
        // просим ввести пароль
        System.out.print("Введите пароль: ");
        // считываем строку из консоли
        String inputPassword = scanner.nextLine();
        scanner.close();


        // сравниваем с образцом
        if (CORRECT_PASSWORD.equals(inputPassword)) {
            System.out.println("Доступ разрешен.");
        } else {
            System.out.println("Неверный пароль. Доступ запрещен.");
        }
    }
}
