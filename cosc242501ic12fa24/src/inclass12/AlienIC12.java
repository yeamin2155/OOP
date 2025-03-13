package inclass12;

public class AlienIC12 implements CharacterIC12 {
    
    private String name;
    private int health;
    private String alienType;
    
    public AlienIC12(String name, int health, String alienType) {
        this.name = name;
        this.health = health;
        this.alienType = alienType;
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
        System.out.println(name + " uses alien powers!");
    }
}
