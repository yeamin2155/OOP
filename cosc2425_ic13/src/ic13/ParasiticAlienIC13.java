package ic13;

public class ParasiticAlienIC13 extends SpaceCharacterIC13 {
    int infectionLevel;

    public ParasiticAlienIC13(String name, int health, int infectionLevel) {
        super(name, health);
        this.infectionLevel = infectionLevel; 
    }

    @Override
    public String toString() {
        return "ParasiticAlien: " + name + "\nHealth: " + health + "\nInfectionLevel: " + infectionLevel;
    }

    @Override
    public void attack(SpaceCharacterIC13 target) { 
        int damage = 5 + infectionLevel;
        target.health -= damage; 
        System.out.println(name + " infects " + target.name + " for " + damage + " damage!");
        if (target.health <= 0) {
            System.out.println(target.name + " has been consumed!");
        }
    }
}
