import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class GradeBook {
    private final String studentName; // Имя студента
    private final Map<Integer, Session> sessions; // Словарь сессий, номер семестра должен быть уникальным

    // Конструктор
    public GradeBook(String studentName) {
        this.studentName = studentName;
        this.sessions = new TreeMap<>(); // TreeMap чтобы при выводе семестры выводились в правильном порядке
    }

    // Добавление оценки в зачетку
    public void addGradeToSession(int semester, String subject, boolean isExam, int grade) {
        // Ищем сессию в заданный семестр
        // Если не нашли, создаем ее
        Session session = sessions.computeIfAbsent(semester, Session::new);
        session.addGrade(subject, isExam, grade);
    }

    // Вывод информации о всех сессиях
    public String info() {
        StringBuilder sb = new StringBuilder("Зачетная книжка студента: " + studentName);
        for (Map.Entry<Integer, Session> entry : sessions.entrySet()) {
            entry.getValue().appendInfo(sb);
        }
        return sb.toString();
    }

    @Override
    public String toString() {
        return "GradeBook{studentName='" + studentName + "', sessions=" + sessions + "}";
    }

    // Внутренний класс, в котором хранится информация о сессии
    private class Session {
        private final int semester; // Номер семестра
        private final Map<Subject, Integer> subjects; // Словарь предметов и оценок, предмет должен быть уникальным в одной сессии

        // Конструктор
        public Session(int semester) {
            this.semester = semester;
            this.subjects = new HashMap<>();
        }

        // Добавление результата (предмет, оценка, тип)
        public void addGrade(String subjectName, boolean isExam, int grade) {
            // Добавляем оценку (обновляем, если предмет уже был ранее добавлен)
            subjects.put(new Subject(subjectName, isExam), grade);
        }

        // Вывод информации об оценках за сессию
        public void appendInfo(StringBuilder sb) {
            sb.append("\n|\tСеместр ").append(semester);
            for (Map.Entry<Subject, Integer> entry : subjects.entrySet()) {
                Subject subject = entry.getKey();
                int grade = entry.getValue();
                if (subject.isExam()) {
                    sb.append("\n|\t\tЭкзамен\t\t").append(grade).append("\t\t\t").append(subject.name());
                } else {
                    sb.append("\n|\t\tЗачет\t\t").append(grade == 0 ? "Незачет\t\t" : "Зачет\t\t").append(subject.name());
                }
            }
        }

        // Геттер семестра
        public int getSemester() {
            return semester;
        }

        // Перегрузки
        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Session s = (Session) o;
            return this.semester == s.semester;
        }

        @Override
        public int hashCode() {
            return semester;
        }

        @Override
        public String toString() {
            return "Session{semester=" + semester + ", subjects=" + subjects + "}";
        }

        // Внутренний record класс, в котором хранится информация о предмете и оценке
        private record Subject(String name, boolean isExam) {
            @Override
            public boolean equals(Object o) {
                if (this == o) return true;
                if (o == null || getClass() != o.getClass()) return false;
                Subject s = (Subject) o;
                return this.name().equals(s.name()) && this.isExam() == s.isExam();
            }

            @Override
            public int hashCode() {
                return 31 * name.hashCode() + (isExam ? 1 : 0);
            }

            @Override
            public String toString() {
                return "Subject{name='" + name + "', isExam=" + isExam + "}";
            }
        }
    }
}