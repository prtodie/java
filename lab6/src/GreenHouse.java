import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

interface IPlantable {
    String species();

    void setSpecies(String species);

    String originCountry();

    void setOriginCountry(String originCountry);

    String description();

    void setDescription(String description);

    default String info() {
        return "\tВид: " + species() +
                "\n\tСтрана происхождения: " + originCountry() +
                "\n\tОписание: " + description();
    }
}

abstract class Plant implements IPlantable {
    String species;
    String originCountry;
    String description;

    public Plant(String species, String originCountry, String description) {
        this.species = species;
        this.originCountry = originCountry;
        this.description = description;
    }

    @Override
    public String species() {
        return species;
    }

    @Override
    public void setSpecies(String species) {
        this.species = species;
    }

    @Override
    public String originCountry() {
        return originCountry;
    }

    @Override
    public void setOriginCountry(String originCountry) {
        this.originCountry = originCountry;
    }

    @Override
    public String description() {
        return description;
    }

    @Override
    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String info() {
        return "\tРастение\n" + IPlantable.super.info();
    }
}

class BushPlant extends Plant {
    public BushPlant(String species, String originCountry, String description) {
        super(species, originCountry, description);
    }

    @Override
    public String description() {
        return "Кустовое растение. " + super.description();
    }

    public String bushSound() {
        return "шур-шур-шур";
    }
}

class FloweringPlant extends Plant {
    public FloweringPlant(String species, String originCountry, String description) {
        super(species, originCountry, description);
    }

    @Override
    public String description() {
        return "Цветковое растение. " + super.description();
    }

    public String bloom() {
        return "\uD83C\uDF39";
    }
}

class HousePlant extends Plant {
    public HousePlant(String species, String originCountry, String description) {
        super(species, originCountry, description);
    }

    @Override
    public String description() {
        return "Комнатное растение. " + super.description();
    }

    public String sleep() {
        return "ZZZ";
    }
}

class GreenHouse {
    List<IPlantable> plants; // Растения оранжереи
    LocalDateTime lastIrrigationDateTime; // Время последнего полива
    int temperature; // температура оранжереи в градусах Цельсия
    int luminescence; // освещение оранжереи в люксах

    public GreenHouse() {
        plants = new ArrayList<>();
        lastIrrigationDateTime = LocalDateTime.now();
        temperature = 20;
        luminescence = 20000;
    }

    // Полить растения в оранжерее
    public void Irrigate() {
        lastIrrigationDateTime = LocalDateTime.now();
        System.out.println("Система орошения успешно отработала");
    }

    // Когда последний раз поливали
    public LocalDateTime lastIrrigated() {
        return lastIrrigationDateTime;
    }

    // Установить температуру в оранжерее
    public void setTemperature(int temperature) {
        this.temperature = temperature;
    }

    // Получить температуру в оранжерее
    public int temperature() {
        return temperature;
    }

    // Получить растение по индексу
    public IPlantable getPlant(int index) {
        return plants.get(index);
    }

    // Добавить новое растение в оранжерею
    public void addPlant(String plantType, String species, String originCountry, String description) {
        IPlantable plant;
        switch (plantType) {
            case "Кустовое":
                plant = new BushPlant(species, originCountry, description);
                break;
            case "Цветковое":
                plant = new FloweringPlant(species, originCountry, description);
                break;
            case "Комнатное":
                plant = new HousePlant(species, originCountry, description);
                break;
            default:
                System.out.println("Неизвестный тип растения");
                return;
        }
        plants.add(plant);
    }

    // Выкопать растения определенного вида
    public void removePlantSpecies(String species) {
        plants = plants.stream()
                .filter(plant -> !plant.species().equalsIgnoreCase(species))
                .collect(Collectors.toList());
    }

    // Информация о всех растениях в оранжерее
    public String allPlantsInfo() {
        StringBuilder sb = new StringBuilder("Все растения в оранжерее:");
        for (int i = 0; i < plants.size(); i++) {
            IPlantable plant = plants.get(i);
            sb.append("\n").append(i + 1).append(". ").append(plant.info());
        }

        return sb.toString();
    }

    // Получить список растений определенного вида
    private List<IPlantable> getPlantsBySpecies(String species) {
        return plants.stream()
                .filter(plant -> plant.species().equalsIgnoreCase(species))
                .collect(Collectors.toList());
    }

    // Информация о растениях определенного вида
    public String plantsSpeciesInfo(String species) {
        StringBuilder sb = new StringBuilder("Растения вида " + species + " в оранжерее:");
        List<IPlantable> plantsOfTheSpecies = getPlantsBySpecies(species);
        for (int i = 0; i < plantsOfTheSpecies.size(); i++) {
            IPlantable plant = plantsOfTheSpecies.get(i);
            sb.append("\n").append(i + 1).append(". ").append(plant.info());
        }

        return sb.toString();
    }

    // Получить список растений определенной странны происхождения
    private List<IPlantable> getPlantsByOriginCountry(String originCountry) {
        return plants.stream()
                .filter(plant -> plant.originCountry().equalsIgnoreCase(originCountry))
                .collect(Collectors.toList());
    }

    // Информация о растениях определенного вида
    public String plantsOfOriginCountryInfo(String originCountry) {
        StringBuilder sb = new StringBuilder("Растения из " + originCountry + " в оранжерее:");
        List<IPlantable> plantsOfTheOriginCountry = getPlantsByOriginCountry(originCountry);
        for (int i = 0; i < plantsOfTheOriginCountry.size(); i++) {
            IPlantable plant = plantsOfTheOriginCountry.get(i);
            sb.append("\n").append(i + 1).append(". ").append(plant.info());
        }

        return sb.toString();
    }
}