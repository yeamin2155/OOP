package inclass12;

public class AstronautIC12 implements CharacterIC12 {
    private String name;
    private int health;
    private String playerType;
    
    public AstronautIC12(String name, int health, String playerType) {
        this.name = name;
        this.health = health;
        this.playerType = playerType;
    }

    @Override
    public String getName() {
        return name;
    }
    
    @Override
    public int getHealth() {
        return health;
    }

    @Override
    public void attack() {
        System.out.println(name + " uses a laser pistol!");
    }
}
