import java.util.List;

public class AlgorithmSolver implements Game.GameSolver {

    private int attempt;

    public AlgorithmSolver() {
        attempt = Attempt.MIN_VALUE;
    }

    private boolean shouldAttempt(Attempt attempt, List<Attempt> prevAttempts) {
        for (Attempt prevAttempt : prevAttempts) {
            if (!prevAttempt.getBullsAndCows().equals(prevAttempt.bullsAndCows(attempt)))
                return false;
        }
        return true;
    }

    @Override
    public Attempt next() {
        attempt++;
        if (Attempt.isAttemptValid(attempt))
            return new Attempt(attempt);
        else
            return next();
    }

    @Override
    public void run(Game game) {
        while (!game.isWon()) {
            Attempt next = next();
            if (shouldAttempt(next, game.getAttempts())) {
                System.out.println("Guessing: " + next);
                BullsAndCows bullsAndCows = game.attempt(next);
                System.out
                        .println("result: " + bullsAndCows.getBulls() + " bulls, " + bullsAndCows.getCows() + " cows.");
            }
        }
        System.out.println("Game won in " + game.getAttempts().size() + " attempts.");
    }

}
