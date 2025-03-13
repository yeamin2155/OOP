package lab6;

public class DilithiumPowerUp extends GameObject {
	private String powerUpType;
	private int amount;

	public DilithiumPowerUp(int id, double positionX, double positionY, String powerUpType, int amount) {
		super(id, positionX, positionY);
		this.powerUpType = powerUpType; 
		this.amount = amount;
	}

	public void applyPowerUp(AstronautLab6 astronaut) { 
		System.out.println("Applying " + powerUpType + " " + amount);
	}
}
