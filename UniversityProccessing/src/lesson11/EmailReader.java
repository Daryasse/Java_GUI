package lesson11;
import java.util.Scanner;
public class EmailReader {
    public static String readEmail() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter email: ");
        String email = scanner.nextLine();
        boolean isValid = EmailValidator.validate(email);
        if (!isValid) {
            System.out.println("Your email is not valid");
            EmailValidator.printExplanation();
            return null;
        }
        return email;
    }
}
