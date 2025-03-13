package lab7;

public class EnemyLab7 extends GameObjectLab7 implements Attackable {
    protected String type;
    protected int health;
    protected int attackPower;

    public EnemyLab7(int id, double positionX, double positionY, String type, int health, int attackPower) {
        super(id, positionX, positionY);
        this.type = type;
        this.health = health;
        this.attackPower = attackPower;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public String getType() {
        return type;
    }

    @Override
    public void attack(GameObjectLab7 target) {
        
    }

    @Override
    public String toString() {
        return "Alien: " + type + " Health: " + health + " Attack power: " + attackPower;
    }
}
