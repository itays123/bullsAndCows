import java.util.Scanner;

public class SecretAttempt extends Attempt {

    public SecretAttempt() {
        super();
    }

    @Override
    public BullsAndCows bullsAndCows(Attempt other) {
        System.out.println("New attempt: " + other);
        int bulls, cows;
        Scanner scan = new Scanner(System.in);
        do {
            System.out.println("Plase enter the number of bulls and cows (sparated by space)");
            bulls = scan.nextInt();
            cows = scan.nextInt();
        } while (BullsAndCows.isValid(bulls, cows));
        BullsAndCows result = new BullsAndCows(bulls, cows);
        scan.close();
        return result;
    }

}
