import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class HumanGuessesGameTest {

    @Test
    void correctGuess() {
        HumanGuessesGame hgg = new HumanGuessesGame(new RandomMockHGG(500));
        assertEquals(GuessResult.CORRECT, hgg.makeGuess(500));
    }

    @Test
    void lowGuess() {
        HumanGuessesGame hgg = new HumanGuessesGame(new RandomMockHGG(500));
        assertEquals(GuessResult.LOW, hgg.makeGuess(250));
    }

    @Test
    void highGuess() {
        HumanGuessesGame hgg = new HumanGuessesGame(new RandomMockHGG(500));
        assertEquals(GuessResult.HIGH, hgg.makeGuess(750));
    }

    @Test
    void zeroGuesses() {
        HumanGuessesGame hgg = new HumanGuessesGame(new RandomMockHGG(500));
        assertEquals(0, hgg.getNumGuesses());
    }

    @Test
    void oneGuess() {
        HumanGuessesGame hgg = new HumanGuessesGame(new RandomMockHGG(500));
        hgg.makeGuess(25);
        assertEquals(1, hgg.getNumGuesses());
    }

    @Test
    void manyGuesses() {
        HumanGuessesGame hgg = new HumanGuessesGame(new RandomMockHGG(500));
        for (int i = 0; i < 5; i++)
            hgg.makeGuess(100+i);
        assertEquals(5, hgg.getNumGuesses());
    }

//    Should Fail
    @Test
    void gameIsDoneAfterCorrectGuess() {
        HumanGuessesGame hgg = new HumanGuessesGame(new RandomMockHGG(500));
        hgg.makeGuess(500);
        assertTrue(hgg.isDone());
    }

    @Test
    void gameIsNotDoneAfterIncorrectGuess() {
        HumanGuessesGame hgg = new HumanGuessesGame(new RandomMockHGG(500));
        hgg.makeGuess(2);
        assertFalse(hgg.isDone());
    }




}
