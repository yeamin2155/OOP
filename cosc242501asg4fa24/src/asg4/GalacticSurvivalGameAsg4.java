package asg4;

import java.util.Random;
import java.util.Scanner;

public class GalacticSurvivalGameAsg4 {
    private static final int TOTAL_SECTORS = 10; 
    // Number of sectors in the solar system
    private static SolarSystem solarSystem;
    private static Astronaut astronaut;
    private static Scanner scanner;
    private static Random random;

    public static void main(String[] args) {
        solarSystem = new SolarSystem(TOTAL_SECTORS);
        astronaut = new Astronaut("Kirk", 100); 
        // Initial health: 100
        scanner = new Scanner(System.in);
        random = new Random();

        // Game loop
        while (astronaut.getHealth() > 0 && astronaut.getPosition() < solarSystem.getSectors()) {
            System.out.println("\nAstronaut's current position: Sector " + astronaut.getPosition());
            System.out.println("Astronaut's health: " + astronaut.getHealth());

            handleLocationChallenges(solarSystem.getSectorType(astronaut.getPosition()));

            System.out.print("Enter direction (forward, backward): ");
            String direction = scanner.nextLine().toLowerCase();
            moveAstronaut(direction);
        }

        scanner.close();
        if (astronaut.getHealth() <= 0) {
            System.out.println("\nGame Over! The astronaut ran out of health.");
        } else {
            System.out.println("\nCongratulations! The astronaut reached the end!");
        }
        astronaut.printInventory();
    }

    // Handle the challenges based on the sector type
    private static void handleLocationChallenges(SolarSystem.SectorType sectorType) {
        switch (sectorType) {
            case EMPTY:
                System.out.println("This sector is empty. Moving on...");
                break;
            case RESOURCE:
                String resource = "Resource" + random.nextInt(100);
                astronaut.addToInventory(resource);
                System.out.println("Found a resource: " + resource + "! Added to inventory.");
                break;
            case ALIEN:
                int alienStrength = random.nextInt(10) + 10; 
                System.out.println("Encountered an alien with strength " + alienStrength + "!");
                astronaut.adjustHealth(-alienStrength); 
                if (astronaut.getHealth() <= 0) {
                    System.out.println("Lost health fighting the alien. Game Over!");
                }
                break;
        }
    }

    // Move the astronaut based on the chosen direction
    private static void moveAstronaut(String direction) {
        switch (direction) {
            case "forward":
                if (astronaut.getPosition() < solarSystem.getSectors() - 1) {
                    astronaut.setPosition(astronaut.getPosition() + 1);
                } else {
                    System.out.println("Cannot move further forward.");
                }
                break;
            case "backward":
                if (astronaut.getPosition() > 0) {
                    astronaut.setPosition(astronaut.getPosition() - 1);
                } else {
                    System.out.println("Cannot move further backward.");
                }
                break;
            default:
                System.out.println("Invalid direction.");
        }
    }
}
