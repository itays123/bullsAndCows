import java.util.Random;
import java.util.Scanner;

public class CommandLineSolver implements Game.GameSolver {

    public static void main(String[] args) {
        Random r = new Random();
        int solution;
        do {
            solution = r.nextInt(10000);
        } while (!Attempt.isAttemptValid(solution));

        Game game = new Game(solution);
        CommandLineSolver solver = new CommandLineSolver();
        solver.run(game);
    }

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
