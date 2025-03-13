package ic23;

import java.util.Set;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class GameWorld {

    private Map<String, Set<String>> stationMap;

    public GameWorld() {
        stationMap = new HashMap<>();
        stationMap.put("Medbay", Set.of("Medkit"));
        stationMap.put("Ventilation Shaft", Set.of());
        stationMap.put("Cargo Hold", Set.of("Oxygen Tank", "Keycard"));
    }

    public void moveAstronaut(Astronaut astronaut, String newLocation) {
        astronaut.move(newLocation);
        System.out.println("Astronaut moved to " + newLocation);

        Set<String> items = stationMap.get(newLocation);
        if (items != null && !items.isEmpty()) {
            System.out.println("You found the following items:");
            for (String item : items) {
                System.out.println("- " + item);
            }

            Scanner scanner = new Scanner(System.in);

            for (String item : items) {
                System.out.println("What do you want to do with " + item + "?");
                System.out.println("1. Add to inventory");
                System.out.println("2. Use");
                int choice = scanner.nextInt();
                scanner.nextLine();

                switch (choice) {
                    case 1:
                        astronaut.pickupItem(item, "1");
                        System.out.println(item + " added to inventory.");
                        break;
                    case 2:
                        astronaut.useItem(item);
                        break;
                    default:
                        System.out.println("Invalid choice. Item left behind.");
                }
            }
        }
    }

    public boolean checkEncounter(Astronaut astronaut, Alien alien) {
        return alien.isAtLocation(astronaut.getCurrentLocation());
    }
}
