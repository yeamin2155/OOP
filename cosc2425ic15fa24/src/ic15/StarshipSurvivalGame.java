package ic15;

import java.util.Random;
import java.util.Scanner;
import java.util.InputMismatchException;

public class StarshipSurvivalGame {

    private static int fuelLevel = 100;
    private static int hullIntegrity = 100;
    private static Scanner scanner = new Scanner(System.in); // Single Scanner instance

    public static void main(String[] args) {
        try {
            startGame();
        } catch (Exception e) {
            System.out.println("An unexpected error occurred: " + e.getMessage());
        } finally {
            scanner.close(); // Close scanner in finally block
        }
    }

    private static void startGame() {
        System.out.println("Welcome to the Starship Survival Game!");

        while (fuelLevel > 0 && hullIntegrity > 0) {
            try {
                System.out.println("\nCaptain, choose your action:");
                System.out.println("1. Warp to a new sector");
                System.out.println("2. Scan for life forms");
                System.out.println("3. Check ship status");
                System.out.println("4. Exit Game");
                int choice = scanner.nextInt();

                switch (choice) {
                    case 1:
                        warpToNewSector();
                        break;
                    case 2:
                        scanForLifeForms();
                        break;
                    case 3:
                        checkShipStatus();
                        break;
                    case 4:
                        System.out.println("Exiting game. Farewell, Captain!");
                        return;
                    default:
                        System.out.println("Invalid choice. Captain, please enter 1, 2, 3, or 4.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Captain, please enter a number.");
                scanner.next(); // Clear invalid input
            }
        }

        if (fuelLevel <= 0) {
            System.out.println("Game Over! Your ship ran out of fuel and drifted into deep space.");
        } else if (hullIntegrity <= 0) {
            System.out.println("Game Over! Your ship's hull was breached and you were lost to the void.");
        }
    }

    private static void warpToNewSector() {
        try {
            System.out.println("Entering warp drive. Set warp factor (1-5):");
            int warpFactor = scanner.nextInt();

            if (warpFactor >= 1 && warpFactor <= 5) {
                int fuelConsumed = warpFactor * 10;
                if (fuelLevel >= fuelConsumed) {
                    fuelLevel -= fuelConsumed;
                    System.out.println("Warp drive engaged. Traveling at warp factor " + warpFactor + ".");

                    Random random = new Random();
                    if (random.nextInt(10) < 2) {
                        System.out.println("Warning! Engine malfunction detected. Warp drive efficiency reduced.");
                        fuelLevel -= 5; // Adjust fuel level for malfunction
                    }
                } else {
                    System.out.println("Insufficient fuel for warp factor " + warpFactor + ".");
                }
            } else {
                System.out.println("Invalid warp factor. Please enter a number between 1 and 5.");
            }
        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Captain, please enter a number.");
            scanner.next(); // Clear invalid input
        }
    }

    private static void scanForLifeForms() {
        Random random = new Random();

        if (random.nextInt(10) < 5) {
            System.out.println("Life forms detected! Preparing to make contact...");
            encounterAliens();
        } else {
            System.out.println("Scan complete. No life forms detected in this sector.");
        }
    }

    private static void encounterAliens() {
        try {
            System.out.println("Alien vessel approaching. Choose your action:");
            System.out.println("1. Attempt diplomatic contact");
            System.out.println("2. Evade and flee");
            System.out.println("3. Prepare for combat");
            int choice = scanner.nextInt();

            Random random = new Random();
            switch (choice) {
                case 1:
                    if (random.nextInt(10) < 7) {
                        System.out.println("Diplomatic contact successful! The aliens are friendly and offer you resources.");
                        fuelLevel += 20; // Gain fuel from friendly aliens
                    } else {
                        System.out.println("Diplomatic efforts failed. The aliens are hostile and attack!");
                        hullIntegrity -= 20; // Damage hull from attack
                    }
                    break;
                case 2:
                    if (random.nextInt(10) < 6) {
                        System.out.println("Evasion successful! You escaped the alien encounter.");
                    } else {
                        System.out.println("Evasion failed! The aliens pursue and attack.");
                        hullIntegrity -= 30; // More damage from failed evasion
                    }
                    break;
                case 3:
                    System.out.println("Engaging in combat with the alien vessel!");
                    if (random.nextInt(10) < 8) {
                        System.out.println("Combat victorious! You defeated the alien vessel.");
                    } else {
                        System.out.println("Combat lost! Your ship sustained heavy damage.");
                        hullIntegrity -= 50; // Heavy damage in combat
                    }
                    break;
                default:
                    System.out.println("Invalid choice. Please enter 1, 2, or 3.");
            }
        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Captain, please enter a number.");
            scanner.next(); // Clear invalid input
        }
    }

    private static void checkShipStatus() {
        System.out.println("Ship Status Report:");
        System.out.println("Fuel Level: " + fuelLevel + "%");
        System.out.println("Hull Integrity: " + hullIntegrity + "%");
    }
}
