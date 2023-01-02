package lesson11;

public class NameValidator {
    public static boolean validate(String name) {
        if (name == null) return false;
        if (name.length() < 3) return false;
        return true;
    }

    public static void printExplanation() {
        System.out.println("Conditions:");
        System.out.println("  1. Name mustn't be null");
        System.out.println("  2. Name must be 3 characters long.");
    }
}
