import java.util.Scanner;

public class CommandLineSolver implements Game.GameSolver {

    Scanner scan;

    public CommandLineSolver() {
        scan = new Scanner(System.in);
    }

    @Override
    public Attempt next() {
        int attemptValue;
        do {
            System.out.print("Please enter your next attempt: ");
            attemptValue = scan.nextInt();
        } while (!Attempt.isAttemptValid(attemptValue));
        return new Attempt(attemptValue);
    }

    @Override
    public void run(Game game) {
        while (!game.isWon()) {
            BullsAndCows bullsAndCows = game.attempt(next());
            System.out.println("result: " + bullsAndCows.getBulls() + " bulls, " + bullsAndCows.getCows() + " cows.");
        }
        System.out.println("Game won in " + game.getAttempts().size() + " attempts.");
    }

}
