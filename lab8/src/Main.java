import java.util.Scanner;

public class Main {
    public static String insertAfterK(String text, String substring, int k) {
        if (k < 0 || k > text.length()) {
            return text;
        }
        return text.substring(0, k) + substring + text.substring(k);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите исходный текст: ");
        String text = scanner.nextLine();

        System.out.print("Введите подстроку для вставки: ");
        String substring = scanner.nextLine();

        System.out.print("Введите позицию k: ");
        int k = scanner.nextInt();

        String result = insertAfterK(text, substring, k);
        System.out.println("Результат: " + result);
    }
}