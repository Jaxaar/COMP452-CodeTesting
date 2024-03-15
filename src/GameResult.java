import com.opencsv.CSVWriter;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;

/**
 * Data class to hold the result of a game
 * NOTE: You can refactor and edit this file if needed
 */
public class GameResult {
    public final boolean humanWasPlaying;
    public final int correctValue;
    public final int numGuesses;

    public GameResult(boolean humanWasPlaying, int correctValue, int numGuesses){
        this.humanWasPlaying = humanWasPlaying;
        this.correctValue = correctValue;
        this.numGuesses = numGuesses;
    }

    public String getNumGuessesText(){
        if(numGuesses == 1){
            return (humanWasPlaying ? "You" : "I") + " guessed it on the first try!";
        }
        else {
            return "It took " + (humanWasPlaying ? "you" : "me") + " " + numGuesses + " guesses.";
        }
    }

    public String[] toRecord(LocalDateTime dateTime){
        String [] record = new String[2];
        record[0] = dateTime.toString();
        record[1] = Integer.toString(numGuesses);
        return record;
    }
}
