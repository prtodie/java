public class Main {
    public static void main(String[] args) {
        GradeBook gb = new GradeBook("Иванов Иван");

        gb.addGradeToSession(1, "История", false, 1);
        gb.addGradeToSession(1, "Высшая математика", true, 3);
        gb.addGradeToSession(1, "Высшая математика", false, 0);
        gb.addGradeToSession(1, "Английский язык", true, 5);

        // пересдача
        gb.addGradeToSession(1, "Высшая математика", true, 4);
        gb.addGradeToSession(1, "Высшая математика", false, 1);



        gb.addGradeToSession(2, "История", false, 1);
        gb.addGradeToSession(2, "Высшая математика", true, 5);
        gb.addGradeToSession(2, "Высшая математика", false, 0);
        gb.addGradeToSession(2, "Английский язык", true, 4);



        gb.addGradeToSession(3, "История", false, 0);
        gb.addGradeToSession(3, "Высшая математика", true, 3);
        gb.addGradeToSession(3, "Высшая математика", false, 0);
        gb.addGradeToSession(3, "Английский язык", true, 5);

        // пересдача
        gb.addGradeToSession(3, "История", false, 1);
        gb.addGradeToSession(3, "Высшая математика", true, 4);
        gb.addGradeToSession(3, "Высшая математика", false, 1);

        System.out.println(gb.info());
    }
}