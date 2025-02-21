import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Task10 {

    public static void main(String[] args) {
        String inputFilePath;
        String outputFilePath;

        // Проверяем, переданы ли параметры командной строки
        if (args.length >= 2) {
            // Если параметры переданы, используем их
            inputFilePath = args[0];
            outputFilePath = args[1];
        } else {
            // Если параметры не переданы, читаем их из файла config.txt
            try (BufferedReader configReader = new BufferedReader(new FileReader("config.txt"))) {
                inputFilePath = configReader.readLine();
                outputFilePath = configReader.readLine();
            } catch (IOException e) {
                System.out.println("Ошибка при чтении файла конфигурации config.txt");
                e.printStackTrace();
                return;
            }
        }

        // Проверяем, что пути к файлам были успешно получены
        if (inputFilePath == null || outputFilePath == null) {
            System.out.println("Не удалось получить пути к файлам.");
            return;
        }

        // Обработка текста
        try (BufferedReader reader = new BufferedReader(new FileReader(inputFilePath));
             BufferedWriter writer = new BufferedWriter(new FileWriter(outputFilePath))) {

            String line;
            String previousWord = null;

            while ((line = reader.readLine()) != null) {
                String[] words = line.split("\\s+");

                for (String word : words) {
                    if (word.isEmpty()) continue;

                    if (previousWord != null) {
                        if (previousWord.charAt(previousWord.length() - 1) == word.charAt(0)) {
                            writer.write(previousWord + " " + word);
                            writer.newLine();
                        }
                    }

                    previousWord = word;
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}