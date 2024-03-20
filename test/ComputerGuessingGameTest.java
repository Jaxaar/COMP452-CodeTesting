import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;

public class ComputerGuessingGameTest {

    @Test
    void testResetGame() {
        ComputerGuessingGame game = new ComputerGuessingGame();
        game.resetGame();
        assertEquals(501, game.getLastGuess());
        assertEquals(0, game.numGuesses);
    }

    @Test
    void testMakeLowerGuess() {
        ComputerGuessingGame game = new ComputerGuessingGame();
        game.resetGame();
        game.makeLowerGuess();
        assertEquals(251, game.getLastGuess());
        assertEquals(1, game.lowerBound);
        assertEquals(501, game.upperBound);
        assertEquals(1, game.numGuesses);
    }

    @Test
    void testMakeHigherGuess() {
        ComputerGuessingGame game = new ComputerGuessingGame();
        game.resetGame();
        game.makeHigherGuess();
        assertEquals(751, game.getLastGuess());
        assertEquals(502, game.lowerBound);
        assertEquals(1000, game.upperBound);
        assertEquals(1, game.numGuesses);
    }

    @Test
    void testFinishGame() {
        ComputerGuessingGame game = new ComputerGuessingGame();
        game.makeLowerGuess();
        GameResult result = game.finishGame();
        assertEquals(1, result.numGuesses);
        assertEquals(251, result.correctValue);
        assertFalse(result.humanWasPlaying);
    }

    @Test
    void testGameIsNotDoneAfterIncorrectGuess() {
        ComputerGuessingGame game = new ComputerGuessingGame();
        game.makeLowerGuess();
        GameResult result = game.finishGame();
        assertFalse(result.correctValue != game.getLastGuess());
    }

    @Test
    void testGameIsDoneAfterCorrectGuess() {
        ComputerGuessingGame game = new ComputerGuessingGame();
        game.makeLowerGuess();
        GameResult result = game.finishGame();
        assertTrue(result.correctValue == game.getLastGuess());
    }

}
