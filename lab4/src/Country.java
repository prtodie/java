import java.util.ArrayList;
import java.util.List;

public class Country {
    private String name;
    private City capital;
    private List<Region> regions;


    // Конструктор
    public Country(String name, City capital) {
        this.name = name;
        this.capital = capital;
        this.regions = new ArrayList<>();
    }


    // Добавление области в государство
    public void addRegion(Region region) {
        regions.add(region);
    }


    // Вывод столицы
    public void printCapital() {
        System.out.println("Столица: " + capital.getName());
    }


    // Вывод количества областей
    public void printNumberOfRegions() {
        System.out.println("Количество областей: " + regions.size());
    }


    // Вывод областных центров
    public void printRegionalCenters() {
        System.out.println("Областные центры:");
        for (Region region : regions) {
            System.out.println("\t" + region.getRegionalCenter().getName());
        }
    }


    // Вычисление общей площади
    public double calculateTotalArea() {
        double totalArea = 0;
        for (Region region : regions) {
            for (District district : region.getDistricts()) {
                for (City city : district.getCities()) {
                    totalArea += city.getArea();
                }
            }
        }
        return totalArea;
    }


    // Перегрузки
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Country country = (Country) o;
        return name.equals(country.name) && capital.equals(country.capital) && regions.equals(country.regions);
    }


    @Override
    public int hashCode() {
        return name.hashCode();
    }


    @Override
    public String toString() {
        return "Country{name='" + name + "', capital=" + capital + ", regions=" + regions + "}";
    }

}
