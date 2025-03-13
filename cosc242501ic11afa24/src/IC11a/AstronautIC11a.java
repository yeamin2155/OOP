package IC11a;

public class AstronautIC11a extends CharacterIC11a{
	private String playerType;
	
	public AstronautIC11a(String name, int health , String playerType) {
		super(name, health);
		this.playerType = playerType;
	}
	@Override
	public void attack(String name) {
	System.out.println(name + "attacks!");
}
	
}
