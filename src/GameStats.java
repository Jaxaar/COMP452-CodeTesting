/**
 * An interface for a data structure, DB API, file reader, etc. that
 * tells us how many games were played that took some number of guesses
 * (e.g., How many games took 8 guesses? --> 17)
 *
 * You can edit this file, but the two abstract methods listed below must remain
 */
public abstract class GameStats {

    public static final int [] BIN_EDGES = {1, 2, 4, 6, 8, 10, 12, 14};

    public static String[] getBinNames() {
        String[] binNames = new String[BIN_EDGES.length];

        for (int binIndex = 0; binIndex < BIN_EDGES.length; binIndex++) {
            String binName;
            if (binIndex == BIN_EDGES.length - 1) {
                // last bin
                binName = BIN_EDGES[binIndex] + " or more";
            } else {
                int upperBound = BIN_EDGES[binIndex + 1] - 1;
                if (upperBound > BIN_EDGES[binIndex]) {
                    binName = BIN_EDGES[binIndex] + "-" + upperBound;
                } else {
                    binName = Integer.toString(BIN_EDGES[binIndex]);
                }
            }
            binNames[binIndex] = binName;
        }
        return binNames;
    }

    public int getGamesInBin(int binIndex){
        final int lowerBound = BIN_EDGES[binIndex];
        int numGames = 0;

        if(binIndex == BIN_EDGES.length-1){
            // last bin
            // Sum all the results from lowerBound on up
            for(int numGuesses=lowerBound; numGuesses<maxNumGuesses(); numGuesses++){
                numGames += numGames(numGuesses);
            }
        }
        else{
            int upperBound = BIN_EDGES[binIndex+1];
            for(int numGuesses=lowerBound; numGuesses <= upperBound; numGuesses++) {
                numGames += numGames(numGuesses);
            }
        }
        return numGames;
    }
    /**
     * @return the number of games played that took numGuesses
     */
    public abstract int numGames(int numGuesses);

    /**
     * @return the maximum number of guesses that any game took
     */
    public abstract int maxNumGuesses();
}
