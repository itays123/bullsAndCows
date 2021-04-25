import java.util.Scanner;

public class SecretAttempt extends Attempt {

    Scanner scan;

    public SecretAttempt() {
        super();
        scan = new Scanner(System.in);
    }

    @Override
    public BullsAndCows bullsAndCows(Attempt other) {
        System.out.println("New attempt: " + other);
        int bulls, cows;
        do {
            System.out.println("Plase enter the number of bulls and cows (sparated by space)");
            bulls = scan.nextInt();
            cows = scan.nextInt();
        } while (!BullsAndCows.isValid(bulls, cows));
        BullsAndCows result = new BullsAndCows(bulls, cows);
        return result;
    }

}
