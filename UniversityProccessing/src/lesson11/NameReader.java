package lesson11;
import java.util.Scanner;
public class NameReader {
    public static String readName(String what) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter " + what + ": ");
        String name = scanner.nextLine();
        boolean isValid = NameValidator.validate(name);
        if (!isValid) {
            System.out.println("Your " + what + " is not valid");
            NameValidator.printExplanation();
            return null;
        }
        return name;
    }

    public static String readName() {
        return readName("name");
    }
}
