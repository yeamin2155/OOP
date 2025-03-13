package lab7;

import java.util.Random;

public class Klingon extends EnemyLab7 {

    public Klingon(int id, double positionX, double positionY, String type, int health, int attackPower) {
        super(id, positionX, positionY, type, health, attackPower);
    }

    @Override
    public void attack(GameObjectLab7 target) {
        Random random = new Random();
        
        if (target instanceof EnemyLab7) {
            EnemyLab7 enemy = (EnemyLab7) target;
            int dice = random.nextInt(11);

            if (dice == 10) {
                int damage = 50;
                System.out.println(type + " landed a stunner attack for " + damage + " damage!");
                enemy.setHealth(enemy.getHealth() - damage);
                System.out.println(enemy.getType() + "'s health is now: " + enemy.getHealth());
            } else {
                int damage = 15;
                System.out.println(type + " landed a hit for " + damage + " damage!");
                enemy.setHealth(enemy.getHealth() - damage);
                System.out.println(enemy.getType() + "'s health is now: " + enemy.getHealth());
            }
        }
    }
}
