// Lab 4 – COSC 2425-<Appropriate Section> – Professor McCurry
// Implemented by - Your name & Lab Partners Name

package lab4;

import java.util.Random;
import java.util.Scanner;

public class SpaceAdventureGame {
	public static void main(String[] args) {
		int rows = 5;
		int columns = 5;
		SolarSystemLab4 solarSystem = new SolarSystemLab4(rows, columns);
		AstronautLab4 astronaut = new AstronautLab4("Kirk", 100); // Initial health: 100
		astronaut.setRowPosition(0);
		astronaut.setColumnPosition(0);

		Scanner scanner = new Scanner(System.in);
		Random random = new Random();

		while (astronaut.getHealth() > 0
				&& (astronaut.getRowPosition() != rows - 1 || astronaut.getColumnPosition() != columns - 1)) {

			System.out.println("\nAstronaut's current position: (" + astronaut.getRowPosition() + ", "
					+ astronaut.getColumnPosition() + ")");
			System.out.println("Astronaut's health: " + astronaut.getHealth());

			SolarSystemLab4.LocationType locationType = solarSystem.getLocationType(astronaut.getRowPosition(),
					astronaut.getColumnPosition());

			switch (locationType) {
			case EMPTY:
				System.out.println("This sector is empty. Moving on...");
				break;
			case RESOURCE:
				String resource = "Resource" + random.nextInt(100);
				astronaut.addToInventory(resource);
				System.out.println("Found a resource: " + resource + "! Added to inventory.");
				break;
			case ALIEN:
				int alienStrength = random.nextInt(10) + 10; // 10-20
				System.out.println("Encountered an alien with strength " + alienStrength + "!");

				if (astronaut.hasItem("Weapon")) {
					System.out.println("Used Weapon to defeat the alien!");
					astronaut.removeItem("Weapon");
				} else {
					System.out.println("Lost health fighting the alien.");
					astronaut.decreaseHealth(alienStrength);
				}
				break;
			}

			if (astronaut.getHealth() <= 0) {
				break; // Game over if health reaches 0
			}

			System.out.print("Enter direction (up, down, left, right): ");
			String direction = scanner.nextLine().toLowerCase();

			switch (direction) {
			case "up":
				if (astronaut.getRowPosition() > 0) {
					astronaut.setRowPosition(astronaut.getRowPosition() - 1);
				} else {
					System.out.println("Cannot move further up.");
				}
				break;
			case "down":
				if (astronaut.getRowPosition() < rows - 1) {
					astronaut.setRowPosition(astronaut.getRowPosition() + 1);
				} else {
					System.out.println("Cannot move further down.");
				}
				break;
			case "left":
				if (astronaut.getColumnPosition() > 0) {
					astronaut.setColumnPosition(astronaut.getColumnPosition() - 1);
				} else {
					System.out.println("Cannot move further left.");
				}
				break;
			case "right":
				if (astronaut.getColumnPosition() < columns - 1) {
					astronaut.setColumnPosition(astronaut.getColumnPosition() + 1);
				} else {
					System.out.println("Cannot move further right.");
				}
				break;
			default:
				System.out.println("Invalid direction.");
			}
		}

		scanner.close();

		if (astronaut.getHealth() <= 0) {
			System.out.println("\nGame Over! The astronaut ran out of health.");
		} else {
			System.out.println("\nCongratulations! The astronaut reached the end!");
		}

		astronaut.printInventory();
	}
}