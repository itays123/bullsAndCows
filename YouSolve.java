import java.util.Random;

public class YouSolve {

    public static void main(String[] args) {
        Random r = new Random();
        int answer;
        do {
            answer = r.nextInt(10000);
        } while (!Attempt.isAttemptValid(answer));
        Game game = new Game(answer);
        Game.GameSolver solver = new CommandLineSolver();
        solver.run(game);
    }

}
