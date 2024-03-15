import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class GameResultTest {

    @Test
    void humanGuessedItFirstTry() {
        GameResult gr = new GameResult(true, 500, 1);
        assertEquals("You guessed it on the first try!", gr.getNumGuessesText());
    }

    @Test
    void computerGuessedItFirstTry() {
        GameResult gr = new GameResult(false, 500, 1);
        assertEquals("I guessed it on the first try!", gr.getNumGuessesText());
    }

    @Test
    void humanGuessedItIn1000() {
        GameResult gr = new GameResult(true, 500, 1000);
        assertEquals("It took you 1000 guesses.", gr.getNumGuessesText());
    }
    @Test
    void computerGuessedItIn2() {
        GameResult gr = new GameResult(false, 500, 2);
        assertEquals("It took me 2 guesses.", gr.getNumGuessesText());
    }

    @Test
    void checkRecordString(){
        GameResult gr = new GameResult(false, 500, 12);
        LocalDateTime time = LocalDateTime.parse("2020-02-24T21:38:37.771960700");
        assertArrayEquals(new String[]{"2020-02-24T21:38:37.771960700", "12"}, gr.toRecord(time));
    }




}
