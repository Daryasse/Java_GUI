package lesson11;

public class Professor {
    private String name;
    private String faculty;

    public Professor(String name, String faculty) {
        this.name = name;
        this.faculty = faculty;
    }

    public static Professor readFromScanner() {
        String name = NameReader.readName();
        if (name == null) return null;
        String faculty = NameReader.readName("faculty");
        if (faculty == null) return null;
        return new Professor(name, faculty);
    }

    public void print() {
        System.out.println("Hello, I am " + name + ". My faculty is: " + faculty);
    }
}
