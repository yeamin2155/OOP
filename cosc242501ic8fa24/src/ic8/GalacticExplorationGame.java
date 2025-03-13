package ic8;

//import the correct libraries  - item #1 to fix
import java.util.ArrayList; // fixed import
import java.util.Collections; // fixed import
import java.util.Random;
import java.util.Scanner;

/**
 * This class represents the core logic of the Galactic Exploration Game.
 * It manages the star systems, explorers, and the gameplay loop.
 */
class GalacticExplorationGame {
    // ArrayList to store all the star systems in the game
    ArrayList<StarSystem> starSystems = new ArrayList<>(); //item #2 to fix
    
    // ArrayList to store the star systems discovered by Explorer 1
    ArrayList<StarSystem> explorer1Systems = new ArrayList<>(); //item #3 to fix
    
    // ArrayList to store the star systems discovered by Explorer 2
    ArrayList<StarSystem> explorer2Systems = new ArrayList<>(); // item #4 to fix
    
    /**
     * Constructor: Initializes the game by creating star systems, shuffling them, and dealing them to the explorers.
     */
    public GalacticExplorationGame() {
        initializeStarSystems(); // Create the star systems
        shuffleStarSystems(); // Randomize the order of star systems
        dealStarSystems(); // Distribute the star systems to the explorers
    }
    
    /**
     * Creates a variety of star systems with different types and resource levels.
     */
    private void initializeStarSystems() {
        String[] systemTypes = {"Nebula", "Binary Star", "Gas Giant", "Terrestrial"};
        String[] resourceLevels = {"Abundant", "Moderate", "Scarce", "Depleted"};

        // Iterate through system types and resource levels to create all possible combinations
        // Use enhanced for loops to add the resources to the `StarSystem` #5
        // XXXXXXXXXXXXXX
        for (String systemType : systemTypes) {
            // XXXXXXXXXXXXXX
            for (String resourceLevel : resourceLevels) {
                // XXXXXXXXXXXXXX
                starSystems.add(new StarSystem(systemType, resourceLevel)); //item #5 fixed
            }
        }
    }

    /**
     * Shuffles the star systems randomly to ensure fair gameplay.
     */
    private void shuffleStarSystems() {
        // Use collections method to 'shuffle` the `StarSystem` #6
        // XXXXXXXXXXXXXX
        Collections.shuffle(starSystems); //item #6 fixed
    }

    /**
     * Deals the star systems equally to both explorers.
     */
    private void dealStarSystems() {
        // Alternate assigning star systems to each explorer
        for (int i = 0; i < starSystems.size(); i++) {
            if (i % 2 == 0) {
                // Use an ArrayList method to give star systems to explorer1 #7
                // XXXXXXXXXXXXXX
                explorer1Systems.add(starSystems.get(i)); //item #7 fixed
            } else {
                // Use an ArrayList method to give star systems to explorer2 #8
                // XXXXXXXXXXXXXX
                explorer2Systems.add(starSystems.get(i)); //item #8 fixed
            }
        }
    }

    /**
     * The main gameplay loop where explorers take turns exploring star systems.
     */
    public void playGame() {
        Scanner scanner = new Scanner(System.in);

        // Continue the game until one explorer runs out of star systems
        while (!explorer1Systems.isEmpty() && !explorer2Systems.isEmpty()) {
            // Display the number of star systems each explorer has discovered using an ArrayList method #9
            // XXXXXXXXXXXXXX
            System.out.println("\nExplorer 1 has discovered: " + explorer1Systems.size() + " star systems");
            System.out.println("Explorer 2 has discovered: " + explorer2Systems.size() + " star systems");

            // Prompt the user to proceed to the next round
            System.out.println("\nPress Enter to continue to the next round...");
            scanner.nextLine();

            // Explorers reveal their next star system using an ArrayList method #10
            // XXXXXXXXXXXXXX
            StarSystem explorer1System = explorer1Systems.remove(0); //item #10 fixed
            StarSystem explorer2System = explorer2Systems.remove(0); //item #10 fixed

            System.out.println("Explorer 1 explores: " + explorer1System);
            System.out.println("Explorer 2 explores: " + explorer2System);

            // Compare resource levels to determine the winner using a String method #11
            // XXXXXXXXXXXXXX
            int result = explorer1System.getResourceLevel().compareTo(explorer2System.getResourceLevel()); //item #11 fixed

            if (result > 0) {
                // Explorer 1 wins the round - Use an ArrayList method to add the solar systems to the winners collection #12
                // XXXXXXXXXXXXXX
                System.out.println("Explorer 1 claims the system!");
                explorer1Systems.add(explorer1System); //item #12 fixed
                explorer1Systems.add(explorer2System); //item #12 fixed
            } else if (result < 0) {
                // Explorer 2 wins the round
                System.out.println("Explorer 2 claims the system!");
                explorer2Systems.add(explorer1System); //item #12 fixed
                explorer2Systems.add(explorer2System); //item #12 fixed
            } else {
                // It's a tie - initiate a Cosmic Clash
                System.out.println("It's a tie! Cosmic Clash!");

                // Create an ArrayList to create a clashPile if explorers reveal the same solar system #13
                // XXXXXXXXXXXXXX
                ArrayList<StarSystem> clashPile = new ArrayList<>(); //item #13 fixed

                // Use an ArrayList method to add a solar system from each explorer's collection to the clashPile #14
                // XXXXXXXXXXXXXX
                clashPile.add(explorer1System); //item #14 fixed
                clashPile.add(explorer2System); //item #14 fixed

                resolveCosmicClash(clashPile);
            }
        }

        // Declare the winner based on who has remaining star systems
        if (explorer1Systems.isEmpty()) {
            System.out.println("\nExplorer 2 wins the game and conquers the galaxy!");
        } else {
            System.out.println("\nExplorer 1 wins the game and conquers the galaxy!");
        }

        scanner.close();
    }

    /**
     * Handles the Cosmic Clash scenario where explorers have a tie.
     * @param clashPile The star systems involved in the clash.
     */
    private void resolveCosmicClash(ArrayList<StarSystem> clashPile) {
        // Each explorer secretly explores 3 more star systems
        for (int i = 0; i < 3; i++) {
            if (!explorer1Systems.isEmpty() && !explorer2Systems.isEmpty()) {
                clashPile.add(explorer1Systems.remove(0));
                clashPile.add(explorer2Systems.remove(0));
            }
        }

        // If both explorers still have star systems, reveal one and have a laser duel
        if (!explorer1Systems.isEmpty() && !explorer2Systems.isEmpty()) {
            StarSystem explorer1ClashSystem = explorer1Systems.remove(0);
            StarSystem explorer2ClashSystem = explorer2Systems.remove(0);

            System.out.println("Explorer 1 reveals: " + explorer1ClashSystem + " (after secret explorations)");
            System.out.println("Explorer 2 reveals: " + explorer2ClashSystem + " (after secret explorations)");

            clashPile.add(explorer1ClashSystem);
            clashPile.add(explorer2ClashSystem);

            // Laser Duel Visualization
            System.out.println("\n*** COSMIC CLASH! ***");
            System.out.println("Spaceships engage in a laser duel amidst a swirling nebula!");

            Random random = new Random();
            int laserPower1 = random.nextInt(10) + explorer1ClashSystem.getResourceValue();
            int laserPower2 = random.nextInt(10) + explorer2ClashSystem.getResourceValue();

            System.out.println("Explorer 1's laser power: " + laserPower1);
            System.out.println("Explorer 2's laser power: " + laserPower2);

            if (laserPower1 > laserPower2) {
                // Explorer 1 wins the clash
                System.out.println("Explorer 1's lasers pierce the nebula and strike true! They claim the systems!");
                explorer1Systems.addAll(clashPile);
            } else if (laserPower2 > laserPower1) {
                // Explorer 2 wins the clash
                System.out.println("Explorer 2's lasers cut through the cosmic dust! They seize the systems!");
                explorer2Systems.addAll(clashPile);
            } else {
                // It's another tie - continue the clash
                System.out.println("The lasers clash and dissipate in a dazzling display! The clash continues!");
                resolveCosmicClash(clashPile);
            }
        }
    }
}
