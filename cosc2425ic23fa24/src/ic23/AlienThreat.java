package ic23;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class AlienThreat {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Astronaut astronaut = new Astronaut();
        Alien alien = new Alien();
        GameWorld gameWorld = new GameWorld();
        Random random = new Random();

        List<String> alienLocations = new ArrayList<>(List.of("Medbay", "Ventilation Shaft", "Cargo Hold"));

        System.out.println("Welcome to the Java Treasure Hunt!");

        while (astronaut.getHealth() > 0) {
            System.out.println(astronaut);

            System.out.println("\nWhat do you want to do?");
            System.out.println("1. Move");
            System.out.println("2. Use Item");
            System.out.println("3. Exit");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.println("Enter a location to move to (Medbay, Ventilation Shaft, Cargo Hold):");
                    String newLocation = scanner.nextLine();
                    gameWorld.moveAstronaut(astronaut, newLocation);

                    if (gameWorld.checkEncounter(astronaut, alien)) {
                        System.out.println("ALERT! You've encountered an Alien!");
                        System.out.println("1. Run");
                        System.out.println("2. Fight");
                        int encounterChoice = scanner.nextInt();
                        scanner.nextLine();

                        switch (encounterChoice) {
                            case 1:
                                System.out.println("You attempt to escape...");
                                int damage = random.nextInt(31) + 10;
                                astronaut.setHealth(astronaut.getHealth() - damage);
                                System.out.println("You took " + damage + " damage while escaping!");
                                break;
                            case 2:
                                System.out.println("You bravely fight the Alien... but are no match.");
                                astronaut.setHealth(0);
                                break;
                        }
                    }
                    alien.move(alienLocations);
                    break;

                case 2:
                    System.out.println("Enter item to use:");
                    String itemToUse = scanner.nextLine();
                    astronaut.useItem(itemToUse);
                    alien.move(alienLocations);
                    break;

                case 3:
                    System.out.println("Exiting game. Goodbye!");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid choice!");
            }
        }

        if (astronaut.getHealth() <= 0) {
            System.out.println("Game Over! The alien has defeated you.");
        }
    }
}
