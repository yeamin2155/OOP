package lab4;

import java.util.ArrayList;

public class AstronautLab4 {
	private String name;
	private int health;
	private int rowPosition;
	private int columnPosition;
	private ArrayList<String> inventory;

	public AstronautLab4(String name, int initialHealth) {
		this.name = name;
		this.health = initialHealth;
		this.inventory = new ArrayList<>();
	}

	// Getters and Setters
	public String getName() {
		return name;
	}

	public int getHealth() {
		return health;
	}

	public void setHealth(int health) {
		this.health = health;
	}

	public int getRowPosition() {
		return rowPosition;
	}

	public void setRowPosition(int rowPosition) {
		this.rowPosition = rowPosition;
	}

	public int getColumnPosition() {
		return columnPosition;
	}

	public void setColumnPosition(int columnPosition) {
		this.columnPosition = columnPosition;
	}

	// Inventory methods
	public void addToInventory(String item) {
		inventory.add(item);
	}

	public void printInventory() {
		if (inventory.isEmpty()) {
			System.out.println("Inventory is empty.");
		} else {
			System.out.println("Inventory:");
			for (String item : inventory) {
				System.out.println("- " + item);
			}
		}
	}

	public boolean hasItem(String item) {
		return inventory.contains(item);
	}

	public void removeItem(String item) {
		inventory.remove(item);
	}

	// Health modification methods
	public void increaseHealth(int amount) {
		health += amount;
	}

	public void decreaseHealth(int amount) {
		health -= amount;
	}
}
