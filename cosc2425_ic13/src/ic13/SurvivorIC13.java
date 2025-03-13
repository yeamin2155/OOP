package ic13;

public class SurvivorIC13 extends SpaceCharacterIC13 {
    int resourcefulness;

    public SurvivorIC13(String name, int health, int resourcefulness) {
        super(name, health);
        this.resourcefulness = resourcefulness;
    }

    @Override
    public String toString() {
        return "Survivor: " + name + "\nHealth: " + health + "\nResourcefulness: " + resourcefulness;
    }

    @Override
    public void attack(SpaceCharacterIC13 target) { 
        int damage = 10 + resourcefulness;
        target.health -= damage;
        System.out.println(name + " attacks " + target.name + " with an improvised weapon for " + damage + " damage!");
        if (target.health <= 0) {
            System.out.println(target.name + " has been defeated!");
        }
    }
}
