package asg4;

import java.util.ArrayList;

public class Astronaut {
    private String name;
    private int health;
    private int position; // Represents the current sector
    private ArrayList<String> inventory; // List to store inventory items

    public Astronaut(String name, int health) {
        this.name = name;
        this.health = health;
        this.position = 0; // Starting at the first sector
        this.inventory = new ArrayList<>();
    }

    // Getters and Setters
    public String getName() {
        return name;
    }

    public int getHealth() {
        return health;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    // Method to adjust health
    public void adjustHealth(int amount) {
        health += amount;
        if (health < 0) {
            health = 0;
        }
    }

    // Method to add to inventory
    public void addToInventory(String item) {
        inventory.add(item);
    }

    // Method to print inventory
    public void printInventory() {
        System.out.println("Inventory: " + inventory);
    }
}
