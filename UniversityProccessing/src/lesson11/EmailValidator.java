package lesson11;
public class EmailValidator {
    public static boolean validate(String email) {
        if (email == null) return false;
        if (email.length() < 5) return false;
        if (!email.contains("@")) return false;
        if (!email.contains(".")) return false; // check what is FQDN
        return true;
    }

    public static void printExplanation() {
        System.out.println("Conditions:");
        System.out.println("  1. E-mail mustn't be null");
        System.out.println("  2. E-mail must be 6 characters long.");
        System.out.println("  3. E-mail must contain '@' character.");
        System.out.println("  4. E-mail must contain '.' character.");
    }
}
