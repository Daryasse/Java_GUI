package lesson11;

public class University {
    private String name;
    private Student[] students;
    private Professor[] professors;

    public University() {
        this("PJAIT");
    }

    public University(String name) {
        this.name = name;
    }

    public void sayHello() {
        System.out.println("Welcome at " + name + " University!");
    }

    public void addProfessor(Professor p) {
        if (p == null) return;
        if (professors == null) {
            professors = new Professor[1];
        } else {
            // my strategy: add one place more, if there is new professor
            Professor[] biggerTable = new Professor[professors.length+1];
            for (int i = 0; i < professors.length; i++) {
                biggerTable[i] = professors[i];
            }
            this.professors = biggerTable;
        }
        professors[professors.length - 1] = p;
    }

    public void addStudent(Student s) {
        if (s == null) return;
        if (students == null) {
            students = new Student[20];
        } else {
            // my strategy: add twice as space, if there is a new student
            Student[] biggerTable = new Student[students.length*2];
            for (int i = 0; i < students.length; i++) {
                biggerTable[i] = students[i];
            }
            this.students = biggerTable;
        }
        for (int i = 0; i < students.length; i++) {
            if (students[i] == null) {
                students[i] = s;
                s.setIndex(i);
                return;
            }
        }
    }

    public void listProfessors() {
        if (professors == null ) {
            System.out.println("There is no professor yet");
            return;
        }
        for (int i = 0; i < professors.length; i++) {
            Professor p = professors[i];
            if (p != null) {
                p.print();
            }
        }
    }

    public void listStudents() {
        if (professors == null) {
            System.out.println("There is no student yet");
            return;
        }
        for (int i = 0; i < students.length; i++) {
            Student s = students[i];
            if (s != null) {
                s.sayHello();
            }
        }
    }
}
