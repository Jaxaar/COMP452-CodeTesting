public class ComputerGuessingGame {
    int numGuesses;
    private int lastGuess;
    int upperBound;
    int lowerBound;

    public ComputerGuessingGame() {
        resetGame();
    }

    public void makeLowerGuess() {
        upperBound = Math.min(upperBound, lastGuess);
        lastGuess = (lowerBound + upperBound + 1) / 2;
        numGuesses++;
    }

    public void makeHigherGuess() {
        lowerBound = Math.max(lowerBound, lastGuess + 1);
        lastGuess = (lowerBound + upperBound + 1) / 2;
        numGuesses++;
    }

    public GameResult finishGame() {
        return new GameResult(false, lastGuess, numGuesses);
    }

    public void resetGame() {
        numGuesses = 0;
        upperBound = 1000;
        lowerBound = 1;
        lastGuess = (lowerBound + upperBound + 1) / 2;
    }

    public int getLastGuess() {
        return lastGuess;
    }
}
