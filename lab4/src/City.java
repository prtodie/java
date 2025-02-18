public class City {
    private String name;
    private double area;


    // Конструктор
    public City(String name, double area) {
        this.name = name;
        this.area = area;
    }


    // Геттеры
    public String getName() {
        return name;
    }


    public double getArea() {
        return area;
    }
    // Перегрузки
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        City city = (City) o;
        return city.area == area && name.equals(city.name);
    }


    @Override
    public int hashCode() {
        return name.hashCode();
    }


    @Override
    public String toString() {
        return "City{name='" + name + "', area=" + area + "}";
    }
}


