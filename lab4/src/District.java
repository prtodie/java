import java.util.ArrayList;
import java.util.List;


public class District {
    private String name;
    private List<City> cities;


    // Конструктор
    public District(String name) {
        this.name = name;
        this.cities = new ArrayList<>();
    }


    // Добавление города в район
    public void addCity(City city) {
        cities.add(city);
    }


    // Геттеры
    public String getName() {
        return name;
    }


    public List<City> getCities() {
        return cities;
    }


    // Перегрузки
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        District district = (District) o;
        return name.equals(district.name) && cities.equals(district.cities);
    }


    @Override
    public int hashCode() {
        return name.hashCode();
    }


    @Override
    public String toString() {
        return "District{name='" + name + "', cities=" + cities + "}";
    }

}
