package lesson11;
public class Main {
    public static void main(String[] args) {
        System.out.println("FIRST SCENARIO");
        Student s = new Student("John Doe", 754, 1950);
        s.sayHello();
        System.out.println("SECOND SCENARIO");
        Student input = Student.readFromScanner();
        if (input != null) {
            input.sayHello();
        }
        System.out.println("THIRD SCENARIO");
        MainMenu mainMenu = new MainMenu();
        mainMenu.run();
    }
}
