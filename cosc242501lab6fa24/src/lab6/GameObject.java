package lab6;

public class GameObject {
	
	protected int id;
	protected double positionX;
	protected double positionY;
	
	public GameObject(int id, double positionX, double positionY) {
		this.id = id;
		this.positionX = positionX;
		this.positionY = positionY;
	}

	public void displayInformation() {
		System.out.println("This is " + id + " within the position of x of: " + positionX + " and the position y of: " + positionY);
	}
	
	@Override
	public String toString() {
		return "Game Object id: " + id + " Position of X is: " + positionX + " Position for Y is: " + positionY;
	}
}

