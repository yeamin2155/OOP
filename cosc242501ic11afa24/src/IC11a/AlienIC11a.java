package IC11a;

public class AlienIC11a extends CharacterIC11a{
	
	private String alienType;
	
	public AlienIC11a(String name, int health, String alienType) {
		super(name, health);
		this.alienType = alienType;
	}
	
	@Override
	public void attack(String name) {
		System.out.println(name +"uses acid spit!");
	}
	

}