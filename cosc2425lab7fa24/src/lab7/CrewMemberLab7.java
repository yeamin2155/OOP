package lab7;

public class CrewMemberLab7 extends GameObjectLab7 implements Attackable {
    private int phaseEnergy;
    private int health;
    private String name;
    private String weapon;

    public CrewMemberLab7(int id, double positionX, double positionY, int health, int phaseEnergy, String name, String weapon) {
        super(id, positionX, positionY);
        this.health = health;
        this.phaseEnergy = phaseEnergy;
        this.name = name;
        this.weapon = weapon;
    }

    public void firePhaser(CrewMemberLab7 target) { 
        int damage = 5;
        System.out.println(name + " fires phaser! Damage: " + damage);
        phaseEnergy -= damage;
        target.setHealth(target.getHealth() - damage);
        System.out.println(target.getName() + "'s health is now: " + target.getHealth());
    }

    @Override
    public void attack(GameObjectLab7 target) {
        if (target instanceof CrewMemberLab7) {
            CrewMemberLab7 crewTarget = (CrewMemberLab7) target;
            
            if (weapon.equals("Phaser")) {
                firePhaser(crewTarget);
            } else if (weapon.equals("Torpedo")) {
                int damage = 30;
                System.out.println(name + " fires torpedo! Damage: " + damage);
                crewTarget.setHealth(crewTarget.getHealth() - damage);
                System.out.println(crewTarget.getName() + "'s health is now: " + crewTarget.getHealth());
            } else {
                System.out.println("Weapon doesn't work.");
            }
        }
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public String getName() {
        return name;
    }

    public int getHealth() {
        return health;
    }

    @Override
    public String toString() {
        return ("Astronaut: " + id + " " + positionX + " " + positionY + " Weapon: " + weapon);
    }
}
