package lesson11;

public class Student {
    private String name;
    private int index;
    private int yearOfBirth;

    public Student(String name, int index, int yearOfBirth) {
        this(name);
        this.index = index;
        this.yearOfBirth = yearOfBirth;
    }

    public Student(String name) {
        if (name != null) {
            this.name = name;
        } else {
            System.out.println("Student constructor: null value");
        }
    }

    public void sayHello() {
        System.out.println("Hi, I am " + name + ". My student index is: " + getIndexAsString());
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public String getIndexAsString() {
        return "s" + index;
    }

    public static Student readFromScanner() {
        String name = NameReader.readName();
        if (name == null) return null;
        String firstLetter = name.substring(0, 1);
        String rest = name.substring(1);
        return new Student(firstLetter.toUpperCase() + rest.toLowerCase());
    }
}
