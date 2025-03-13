package ic23;

import java.util.HashMap;
import java.util.Map;

public class Astronaut {

    private int health;
    private Map<String, String> inventory;
    private String currentLocation;

    public Astronaut() {
        inventory = new HashMap<>();
        currentLocation = "Start";
        this.health = 100;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public void pickupItem(String item, String quantity) {
        inventory.put(item, quantity);
    }

    public void useItem(String item) {
        if (inventory.containsKey(item)) {
            System.out.println("Used " + item);
            inventory.remove(item);
        } else {
            System.out.println("You don't have " + item + " in your inventory.");
        }
    }

    public void move(String newLocation) {
        currentLocation = newLocation;
    }

    public Map<String, String> getInventory() {
        return inventory;
    }

    public String getCurrentLocation() {
        return currentLocation;
    }

    @Override
    public String toString() {
        return "Astronaut Status:\n" + "  Health: " + health + "\n" + "  Location: " + currentLocation + "\n"
                + "  Inventory: " + inventory;
    }
}
