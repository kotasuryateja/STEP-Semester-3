
import java.util.Scanner;

public class Problem5BankTransactionReferenceValidator {

    public static String normalizeReference(String raw) {
        raw = raw.trim();

        if (raw.length() < 3) {
            return raw.toUpperCase();
        }

        return raw.substring(0, 3).toUpperCase()
                + raw.substring(3);
    }

    public static String validateAndFormat(String reference) {
        if (reference.length() != 14) {
            return "Invalid: wrong length";
        }

        for (int i = 0; i < 3; i++) {
            if (!Character.isLetter(reference.charAt(i))) {
                return "Invalid: bank code must be 3 letters";
            }
        }

        for (int i = 3; i < 14; i++) {
            if (!Character.isDigit(reference.charAt(i))) {
                return "Invalid: transaction body must contain only digits";
            }
        }

        StringBuilder result = new StringBuilder();
        result.append("[")
              .append(reference.substring(0, 3))
              .append("] DATE: ")
              .append(reference.substring(3, 9))
              .append(" | SEQ: ")
              .append(reference.substring(9));

        return result.toString();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter transaction reference: ");
        String raw = sc.nextLine();

        String normalized = normalizeReference(raw);
        System.out.println(validateAndFormat(normalized));

        sc.close();
    }
}
