package ic8;


/**
 * The driver class to start the Galactic Exploration Game
 */
public class GalacticGameDriver {

    /**
     * The main method, the entry point of the Java program
     * @param args Command-line arguments (not used in this game)
     */
    public static void main(String[] args) {
        // Create a new instance of the GalacticExplorationGame
        GalacticExplorationGame game = new GalacticExplorationGame();
        
        // Start the game by calling the playGame method
        game.playGame();
    }
}