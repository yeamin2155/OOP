package ic16;

//In-Class 16 – COSC 2425-01 – Professor McCurry
//Implemented by: Ashabul Yeamin


import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class StarshipSurvivalGameIC16 {

    private static int fuelLevel = 100; // Initialize fuel level to 100%
    private static int hullIntegrity = 100; // Initialize hull integrity to 100%

    public static void main(String[] args) {
        // Start the game within a try-catch block to handle any unexpected issues
        try {
            startGame();
            // What statement goes here for unexpected issues?
        } catch (Exception e) {
            System.out.println("An unexpected error occurred: " + e.getMessage());
        }
    }

    private static void startGame() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the Starship Survival Game!");

        while (fuelLevel > 0 && hullIntegrity > 0) {
            // implement try-catch block to check input mismatch,
            // catch block to check arithmetic issues
            // catch block to check null pointer issues
            // catch block to check array index out of bounds
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
                // What statement goes here for input type mismatch?
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Captain, please enter a number.");
                scanner.next(); // Clear invalid input
            } catch (ArithmeticException e) {
                // What statement goes here for arithmetic issues?
                System.out.println("Mathematical error encountered. Adjusting calculations...");
                fuelLevel -= 10; // Apply a default fuel penalty as a recovery
            } catch (NullPointerException e) {
                // What statement goes here for null pointer issues?
                System.out.println("Error: A critical system component was unavailable. Scanning again...");
            } catch (ArrayIndexOutOfBoundsException e) {
                // What statement goes here for array index out of bounds issues?
                System.out.println("Error: Attempted to access an invalid game element. Adjusting strategy...");
            }
        }

        if (fuelLevel <= 0) {
            System.out.println("Game Over! Your ship ran out of fuel and drifted into deep space.");
        } else if (hullIntegrity <= 0) {
            System.out.println("Game Over! Your ship's hull was breached and you were lost to the void.");
        }

        scanner.close(); // Close the scanner to release resources
    }

    // IC16 change
    private static void warpToNewSector() {
        Scanner scanner = new Scanner(System.in);
        // implement try-catch block to check input mismatch,
        // catch block to check arithmetic issues
        // try {
        // change
        System.out.println("Entering warp drive. Set warp factor (1-5):");
        int warpFactor = scanner.nextInt();

        // if(warpFactor >= 1 && warpFactor <= 5) {
        if (warpFactor < 1 || warpFactor > 5) { // corrected condition
            // change
            throw new InputMismatchException("Invalid warp factor!");
        }
        // Modify for test case 2
        int fuelConsumed = warpFactor * 10;
        if (fuelLevel >= fuelConsumed) {
            fuelLevel -= fuelConsumed;
            System.out.println("Warp drive engaged. Traveling at warp factor " + warpFactor + ".");

            Random random = new Random();
            if (random.nextInt(10) < 2) { // 20% chance of malfunction
                System.out.println("Warning! Engine malfunction detected. Warp drive efficiency reduced.");
                fuelLevel -= 5; // Additional fuel penalty due to malfunction
            }
        } else {
            System.out.println("Insufficient fuel for warp factor " + warpFactor + ".");
        }
        // } catch (InputMismatchException e) {
        // System.out.println("Invalid input. Captain, please enter a number.");
        // scanner.next(); // Clear invalid input
        // What statement goes here for arithmetic issues?
        // } catch (ArithmeticException e) {
        // System.out.println("Mathematical error encountered. Adjusting fuel consumption...");
        // }
    }

    // ic16 change throws nullpoint exception
    private static void scanForLifeForms() {
        Random random = new Random();
        // implement try-catch block to check null pointer issues,
        // catch block to check array index out of bounds
        try {
            // Modify for test case 3
            // String scanSystem = null;
            // if (scanSystem.equals("active")) {
            if (random.nextInt(10) < 5) { // 50% chance of encountering aliens
                System.out.println("Life forms detected! Preparing to make contact...");
                encounterAliens();
            } else {
                System.out.println("Scan complete. No life forms detected in this sector.");
            }
            // What statement goes here for null pointer issues?
        } catch (NullPointerException e) {
            System.out.println("Scan system error. Unable to locate life forms.");
            // What statement goes here for array index out of bounds issues?
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Error: Invalid array index during scan. Retrying...");
        }
    }

    private static void encounterAliens() throws ArrayIndexOutOfBoundsException, InputMismatchException {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        // implement try-catch block to check input mismatch,
        // catch block to check arithmetic issues
        // ic16 change
        // try {
        System.out.println("Alien vessel approaching. Choose your action:");
        System.out.println("1. Attempt diplomatic contact");
        System.out.println("2. Evade and flee");
        System.out.println("3. Prepare for combat");
        int choice = scanner.nextInt();

        switch (choice) {
            case 1:
                // Modify for test case 4
                // int[] alienAggressionLevels = { 10, 20, 30 };
                // System.out.println(alienAggressionLevels[5]); // This will throw ArrayIndexOutOfBoundsException
                if (random.nextInt(10) < 7) {
                    System.out.println("Diplomatic contact successful! The aliens are friendly and offer you resources.");
                    fuelLevel += 20;
                } else {
                    System.out.println("Diplomatic efforts failed. The aliens are hostile and attack!");
                    hullIntegrity -= 20;
                }
                break;
            case 2:
                if (random.nextInt(10) < 6) {
                    System.out.println("Evasion successful! You escaped the alien encounter.");
                } else {
                    System.out.println("Evasion failed! The aliens pursue and attack.");
                    hullIntegrity -= 30;
                }
                break;
            case 3:
                System.out.println("Engaging in combat with the alien vessel!");
                if (random.nextInt(10) < 8) {
                    System.out.println("Combat victorious! You defeated the alien vessel.");
                } else {
                    System.out.println("Combat lost! Your ship sustained heavy damage.");
                    hullIntegrity -= 50;
                }
                break;
            default:
                throw new InputMismatchException("Invalid choice. Please enter 1, 2, or 3.");
        }
        // What statement goes here for input type mismatch?
        // } catch (InputMismatchException e) {
        // System.out.println("Invalid input. Captain, please enter a number.");
        // scanner.next(); // Clear invalid input
        // What statement goes here for array index out of bounds issues?
        // } catch (ArrayIndexOutOfBoundsException e) {
        // System.out.println("Combat error: Invalid array access.");
        // }
    }

    // ic16 change
    // utility method to get valid integer input
    private static int getIntInput(Scanner scanner) throws InputMismatchException {
        try {
            return scanner.nextInt();
        } catch (InputMismatchException e) {
            scanner.next(); // clear invalid input
            throw new InputMismatchException("Invalid input! Please enter a number.");
        }
    }

    private static void checkShipStatus() {
        System.out.println("Fuel Level: " + fuelLevel + "%");
        System.out.println("Hull Integrity: " + hullIntegrity + "%");
    }
}
