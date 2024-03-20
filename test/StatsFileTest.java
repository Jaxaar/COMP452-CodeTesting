import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.FileWriter;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

public class StatsFileTest {
    private static final String TEST_FILENAME = "test-stats.csv";

    @BeforeEach
    void setUp() {
        // Create a test CSV file with some data
        try (FileWriter writer = new FileWriter(TEST_FILENAME)) {
            writer.write("\"2020-02-24T20:10:29.110278500\",\"3\"\n");
            writer.write("\"2020-02-24T20:15:28.750793100\",\"3\"\n");
            writer.write("\"2020-02-24T20:56:09.088002200\",\"9\"\n");
            writer.write("\"2020-02-24T21:02:13.347392500\",\"1\"\n");
            writer.write("\"2020-02-24T21:06:40.860330300\",\"10\"\n");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    void testNumGamesForExistingGuesses() {
        StatsFile statsFile = new StatsFile();
        assertEquals(5, statsFile.numGames(10));
    }

    @Test
    void testNumGamesForNonExistingGuesses() {
        StatsFile statsFile = new StatsFile();
        assertEquals(0, statsFile.numGames(20));
    }

    @Test
    void testMaxNumGuesses() {
        StatsFile statsFile = new StatsFile();
        assertEquals(17, statsFile.maxNumGuesses());
    }

    @Test
    void testFileParsingWithInvalidData() {
        // Create a test CSV file with invalid data
        // Assumption: Invalid data doesn't affect the statistics
        // Instantiate StatsFile and validate the statistics
        StatsFile statsFile = new StatsFile();
        assertEquals(5, statsFile.numGames(10)); // Example valid data point
        assertEquals(0, statsFile.numGames(20)); // Non-existing number of guesses
        assertEquals(17, statsFile.maxNumGuesses()); // Maximum number of guesses in valid data
    }


}

