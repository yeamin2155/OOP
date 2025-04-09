package asg6;
//Implemented by - Ashabul Yeamin

public abstract class Spaceship {
    protected String name;
    protected int hullStrength;
    protected int shieldStrength;

    public Spaceship(String name, int hullStrength, int shieldStrength) {
        this.name = name;
        this.hullStrength = hullStrength;
        this.shieldStrength = shieldStrength;
    }

    public void fireWeapon(Spaceship target) {
        // Base fireWeapon behavior; can be overridden by subclasses
        System.out.println(this.name + " fires a basic weapon at " + target.name);
        target.takeDamage(10); // Default damage amount
    }

    public void activateShields() {
        System.out.println(name + " activates shields.");
        shieldStrength += 20;
    }

    public void takeDamage(int damage) {
        if (shieldStrength > 0) {
            shieldStrength -= damage;
            if (shieldStrength < 0) {
                hullStrength += shieldStrength; // apply leftover damage to hull
                shieldStrength = 0;
            }
        } else {
            hullStrength -= damage;
        }
        hullStrength = Math.max(hullStrength, 0); // Ensure hull does not go negative
    }

    public abstract String toString(); // Abstract method to be implemented by subclasses
}
