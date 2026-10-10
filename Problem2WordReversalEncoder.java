
import java.util.Scanner;

public class Problem2WordReversalEncoder {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a word: ");
        String word = sc.next();

        StringBuilder reversed = new StringBuilder(word);
        reversed.reverse();

        System.out.println("Reversed word: " + reversed);

        if (word.equals(reversed.toString())) {
            System.out.println("Palindrome: Yes");
        } else {
            System.out.println("Palindrome: No");
        }

        sc.close();
    }
}
