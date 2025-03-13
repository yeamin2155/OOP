package ic13;

public abstract class SpaceCharacterIC13 {
    protected String name;
    protected int health;

    public SpaceCharacterIC13(String name, int health) {
        this.name = name;
        this.health = health;
    }

    @Override
    public abstract String toString(); 

    public abstract void attack(SpaceCharacterIC13 target); 
}
