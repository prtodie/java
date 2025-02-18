import java.util.ArrayList;
import java.util.List;

public class Region {
    private String name;
    private City regionalCenter;
    private List<District> districts;


    // Конструктор
    public Region(String name, City regionalCenter) {
        this.name = name;
        this.regionalCenter = regionalCenter;
        this.districts = new ArrayList<>();
    }


    // Добавление района в область
    public void addDistrict(District district) {
        districts.add(district);
    }


    // Геттеры
    public String getName() {
        return name;
    }


    public City getRegionalCenter() {
        return regionalCenter;
    }


    public List<District> getDistricts() {
        return districts;
    }


    // Перегрузки
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Region region = (Region) o;
        return name.equals(region.name) && regionalCenter.equals(region.regionalCenter) && districts.equals(region.districts);
    }


    @Override
    public int hashCode() {
        return name.hashCode();
    }


    @Override
    public String toString() {
        return "Region{name='" + name + "', regionalCenter=" + regionalCenter + ", districts=" + districts + "}";
    }

}
