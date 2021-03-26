import java.util.ArrayList;
import java.util.List;

/**
 * A Game of bulls and cows
 * 
 * @author Itay Schechner
 */
public class Game {

    // attributes
    private Attempt solution;
    private List<Attempt> attempts;
    private boolean isWon;

    // constructors
    public Game() {
        this.solution = new Attempt();
        this.attempts = new ArrayList<>();
        this.isWon = false;
    }

    /**
     * Creates a new game object
     * 
     * @param solution the solution integer
     */
    public Game(int solution) {
        this.solution = new Attempt(solution);
        this.attempts = new ArrayList<>();
        this.isWon = false;
    }

    // methods

    public BullsAndCows attempt(Attempt attempt) {
        BullsAndCows bullsAndCows = solution.bullsAndCows(attempt);
        isWon = bullsAndCows.getBulls() == BullsAndCows.MAX_VALUE;
        attempt.setBullsAndCows(bullsAndCows);
        attempts.add(attempt);
        return bullsAndCows;
    }

    public List<Attempt> getAttempts() {
        return attempts;
    }

    public boolean isWon() {
        return isWon;
    }

    public static interface GameSolver {

        Attempt next();

        void run(Game game);

    }

}