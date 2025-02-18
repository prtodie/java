import java.util.*;


class Abiturient {
    private int id;
    private String lastName; // фамилия
    private String firstName; // имя
    private String patronymic; // отчество
    private String address;
    private String phone;
    private int[] grades;


    // Конструкторы класса
    public Abiturient(int id, String lastName, String firstName, String patronymic, String address, String phone, int[] grades) {
        this.id = id;
        this.lastName = lastName;
        this.firstName = firstName;
        this.patronymic = patronymic;
        this.address = address;
        this.phone = phone;
        this.grades = grades;
    }


    public Abiturient(int id, String lastName, String firstName, String patronymic, String address, String phone) {
        this.id = id;
        this.lastName = lastName;
        this.firstName = firstName;
        this.patronymic = patronymic;
        this.address = address;
        this.phone = phone;
        this.grades = new int[]{};
    }


    public Abiturient(int id, String fullName, String address, String phone, int[] grades) {
        this.id = id;
        var strings = fullName.split(" ");
        this.lastName = strings[0];
        this.firstName = strings[1];
        this.patronymic = strings[2];
        this.address = address;
        this.phone = phone;
        this.grades = grades;
    }


    public Abiturient(int id, String fullName, String address, String phone) {
        this.id = id;
        var strings = fullName.split(" ");
        this.lastName = strings[0];
        this.firstName = strings[1];
        this.patronymic = strings[2];
        this.address = address;
        this.phone = phone;
        this.grades = new int[]{};
    }


    // Геттеры для получения значений полей
    public int getId() {
        return id;
    }


    public String getLastName() {
        return lastName;
    }


    public String getFirstName() {
        return firstName;
    }


    public String getPatronymic() {
        return patronymic;
    }


    public String getAddress() {
        return address;
    }


    public String getPhone() {
        return phone;
    }


    public int[] getGrades() {
        return grades;
    }


    // Метод для вычисления общей суммы баллов
    public int getGradesSum() {
        int sum = 0;
        for (int grade : grades) {
            sum += grade;
        }
        return sum;
    }


    // Метод для проверки наличия неудовлетворительных оценок
    public boolean hasBadGrade() {
        for (int grade : grades) {
            if (grade < 4) {
                return true;
            }
        }
        return false;
    }


    public String getInfo() {
        String gradesString = Arrays.toString(getGrades());
        return "Абитуриент #" + getId() +
                "\n\tФИО:\t\t\t" + getLastName() + " " + getFirstName() + " " + getPatronymic() +
                "\n\tАдрес:\t\t\t" + getAddress() +
                "\n\tТелефон:\t\t" + getPhone() +
                "\n\tОценки:\t\t\t" + gradesString.substring(1, gradesString.length() - 1);
    }


    @Override
    public String toString() {
        return "Abiturient{id=" + id + ", lastName='" + lastName + "', firstName='" + firstName + "', patronymic='" + patronymic + "', address='" + address + "', phone='" + phone + "', grades=" + Arrays.toString(grades) + "}";
    }
}


public class Main {
    public static void main(String[] args) {


        // Создание массива абитуриентов
        Abiturient[] abiturients = new Abiturient[]{
                new Abiturient(1, "Иванов", "Иван", "Иванович", "Москва", "123456789", new int[]{5, 3, 4, 2}),
                new Abiturient(2, "Петров Петр Петрович", "Санкт-Петербург", "987654321", new int[]{4, 4, 5, 5}),
                new Abiturient(3, "Сидоров", "Сидр", "Сидорович", "Казань", "555666777", new int[]{2, 3, 2, 4}),
                new Abiturient(4, "Викторов", "Виктор", "Викторович", "Грозный", "999999999"),
                new Abiturient(5, "Дагбаева Виктория Викторовна", "Кяхта", "000000000", new int[]{5, 5, 5, 5}),
                new Abiturient(6, "Семенов Семен Семенович", "Иркутск", "8008"),
        };


        // Вывод всех абитуриентов
        System.out.println("Абитуриенты:");
        for (Abiturient abiturient : abiturients) {
            System.out.println(abiturient.getInfo());
        }


        // Вывод абитуриентов с неудовлетворительными оценками
        System.out.println("\nАбитуриенты с неудовлетворительными оценками:");
        for (Abiturient abiturient : abiturients) {
            if (abiturient.hasBadGrade()) {
                System.out.println(abiturient.getInfo());
            }
        }


        // Вывод абитуриентов с суммой баллов выше заданного значения
        int minScore = 15;
        System.out.println("\nАбитуриенты с суммой баллов выше " + minScore + ":");
        for (Abiturient abiturient : abiturients) {
            if (abiturient.getGradesSum() > minScore) {
                System.out.println(abiturient.getInfo());
            }
        }


        // Выбор n абитуриентов с самой высокой суммой баллов
        int n = 3;


        // Чтобы не выходить за границы массива
        // переназначим n на меньше из двух: n или количество абитуриентов
        n = Math.min(n, abiturients.length);
        System.out.println("\nТоп " + n + " абитуриентов с самой высокой суммой баллов:");


        // Сортировка
        for (int i = 0; i < abiturients.length - 1; i++) {
            for (int j = i + 1; j < abiturients.length; j++) {
                if (abiturients[i].getGradesSum() < abiturients[j].getGradesSum()) {
                    Abiturient temp = abiturients[i];
                    abiturients[i] = abiturients[j];
                    abiturients[j] = temp;
                }
            }
        }


        // Вывод
        for (int i = 0; i < n; i++) {
            System.out.println(abiturients[i].getInfo());
        }
    }
}
