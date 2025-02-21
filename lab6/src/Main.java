import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

public class Main {
    public static void main(String[] args) {
        // Создаем оранжерею
        GreenHouse greenHouse = new GreenHouse();

        // Добавляем растения
        greenHouse.addPlant("Кустовое", "Малина", "Россия", "Съедобный кустарник с ягодами.");
        greenHouse.addPlant("Цветковое", "Роза", "Франция", "Красивое растение с ароматными цветами.");
        greenHouse.addPlant("Комнатное", "Фикус", "Бразилия", "Популярное комнатное растение.");
        greenHouse.addPlant("Кустовое", "Смородина", "Россия", "Кустарник с полезными ягодами.");

        // Выводим информацию о всех растениях
        System.out.println(greenHouse.allPlantsInfo());

        // Проверяем методы для работы с растениями
        System.out.println(greenHouse.plantsSpeciesInfo("Малина"));

        System.out.println(greenHouse.plantsOfOriginCountryInfo("Россия"));

        // Удаляем растения определенного вида
        greenHouse.removePlantSpecies("Малина");
        System.out.println("\nПосле удаления растений вида 'Малина':");
        System.out.println(greenHouse.allPlantsInfo());

        // Проверяем методы управления оранжереей
        System.out.println("\nТекущая температура в оранжерее: " + greenHouse.temperature() + "°C");
        greenHouse.setTemperature(25);
        System.out.println("Новая температура в оранжерее: " + greenHouse.temperature() + "°C");

        System.out.println("\nПоследний полив: " + greenHouse.lastIrrigated().format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.SHORT)));
        greenHouse.Irrigate();
        System.out.println("Последний полив: " + greenHouse.lastIrrigated().format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.SHORT)));

        // Проверяем специфические методы для каждого типа растений
        IPlantable plant = greenHouse.getPlant(2);
        if (plant instanceof BushPlant bush) {
            System.out.println("\n" + bush.species() + ": " + bush.bushSound());
        }

        plant = greenHouse.getPlant(0);
        if (plant instanceof FloweringPlant flower) {
            System.out.println(flower.species() + ": " + flower.bloom());
        }

        plant = greenHouse.getPlant(1);
        if (plant instanceof HousePlant housePlant) {
            System.out.println(housePlant.species + ": " + housePlant.sleep());
        }
    }
}