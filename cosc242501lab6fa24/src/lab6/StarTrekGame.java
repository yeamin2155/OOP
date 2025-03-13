package lab6;

public class StarTrekGame {
	public static void main(String[] args) {
		// Needed to test `AstronautLab6.java`
		// Create an instance of the player
		AstronautLab6 astronaut = new AstronautLab6(1, 5.0, 5.0, 100, 50);

		// Display player information and fire phaser
		System.out.println(astronaut); // Use toString()
		astronaut.firePhaser();

		System.out.println("-----");
		// Needed to test DilithiumPowerUp
		// Create instances of power-ups
		DilithiumPowerUp phaserPowerUp = new DilithiumPowerUp(2, 15.0, 15.0, "Phaser Recharge", 25);
		DilithiumPowerUp tricorderPowerUp = new DilithiumPowerUp(3, 20.0, 10.0, "Tricorder Recharge", 30);

		// Display power-up information and apply them
		System.out.println(phaserPowerUp); // Use toString()
		phaserPowerUp.applyPowerUp(astronaut); // Pass the astronaut object

		System.out.println("-----");

		System.out.println(tricorderPowerUp); // Use toString()
		tricorderPowerUp.applyPowerUp(astronaut); // Pass the astronaut object

		System.out.println("-----");

		System.out.println(astronaut); // Use toString() to show updated info
	}
}
