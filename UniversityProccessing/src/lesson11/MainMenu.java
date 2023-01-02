package lesson11;
import java.util.Scanner;
public class MainMenu {
    private University university;
    private boolean isWorking;

    public MainMenu() {
        this(new University());
    }

    public MainMenu(University university) {
        this.university = university;
    }

    private static String[] options = {
            "Add new professor",
            "Add new student",
            "List all professors",
            "List all students",
            "End program"
    };

    public void run() {
        isWorking = true;
        university.sayHello();
        Scanner s = new Scanner(System.in);
        while (isWorking) {
            this.printMenu();
            if (s.hasNextInt()) {
                switch (s.nextInt()) {
                    case 0:
                        university.addProfessor(Professor.readFromScanner());
                        break;
                    case 1:
                        university.addStudent(Student.readFromScanner());
                        break;
                    case 2:
                        university.listProfessors();
                        break;
                    case 3:
                        university.listStudents();
                        break;
                    case 4:
                        endProgram();
                        break;
                }
            }
        }
    }

    private void printMenu() {
        System.out.println("Main Menu:");
        for (int i = 0; i < options.length; i++) {
            System.out.println("[" + i + "]: " + options[i]);
        }
        System.out.println("What you want to do? [0-" + options.length + "]");
    }

    private void endProgram(){
        isWorking = false;
    }
}
