public class WeSolve {

    public static void main(String[] args) {
        SecretAttempt attempt = new SecretAttempt();
        Game game = new Game(attempt);
        Game.GameSolver solver = new AlgorithmSolver();
        solver.run(game);
    }

}
