package lab6;

public class AstronautLab6 extends GameObject {
	
	private int phaseEnergy;
	private int health;
	

	public AstronautLab6(int id, double positionX, double positionY, int health, int phaseEnergy) {
		super(id , positionX, positionY);
		this.health = health;
		this.phaseEnergy = phaseEnergy;
		
	}

	public void firePhaser() {
		System.out.println("Astronaut fires phaser! Damage: " + phaseEnergy);
	}
	
	@Override
	public String toString() {
		return super.toString () + "Astronaut health is: " + health + "Phaser Energy";
	}
}
