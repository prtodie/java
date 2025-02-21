import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;

// Собственный класс исключения
class InvalidNumberFormatException extends Exception {
    public InvalidNumberFormatException(String message) {
        super(message);
    }
}

public class Main {
    public static void main(String[] args) {
        String filePath = "numbers.txt"; // Путь к файлу
        double sum = 0.0; // Сумма
        int count = 0; // Количество
        DecimalFormat df = new DecimalFormat("#0.00"); // Формат чисел с двумя знаками после запятой

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                try {
                    // Разделение строки на число и локаль
                    String[] parts = line.split(" ");
                    if (parts.length != 2) {
                        throw new InvalidNumberFormatException("Некорректный формат строки: " + line);
                    }

                    String numberStr = parts[0];
                    String localeStr = parts[1];

                    // Получение локали из строки
                    Locale locale = Locale.forLanguageTag(localeStr.replace("_", "-"));
                    NumberFormat format = NumberFormat.getInstance(locale);

                    // Преобразование строки в число
                    Number number = format.parse(numberStr);
                    double value = number.doubleValue();

                    // Проверка на допустимость значения числа
                    if (Double.isInfinite(value) || Double.isNaN(value)) {
                        throw new InvalidNumberFormatException("Недопустимое значение числа: " + line);
                    }
                    System.out.print(df.format(value) + "\t");
                    sum += value;
                    count++;
                } catch (ParseException e) {
                    System.err.println("Ошибка формата числа: " + line);
                } catch (InvalidNumberFormatException e) {
                    System.err.println(e.getMessage());
                }
            }
            System.out.println();

            if (count > 0) {
                // Если получилось преобразовать хотя бы одно число, выводим сумму и среднее
                double average = sum / count;
                System.out.println("Сумма: " + df.format(sum));
                System.out.println("Среднее: " + df.format(average));
            } else {
                System.out.println("В файле нет корректных чисел.");
            }
        } catch (IOException e) {
            System.err.println("Ошибка чтения файла: " + e.getMessage());
        } catch (OutOfMemoryError e) {
            System.err.println("Нехватка памяти: " + e.getMessage());
        }
    }
}