package asg2;

import java.util.Random;

public class Alien {
    private String species;
    private int energyLevel;
    private int laserPower;
    private int level;
    private int experience;
    private int spaceCredits;
    private boolean operational;

    // Constructor
    public Alien(String species, int energyLevel, int laserPower) {
        this.species = species;
        this.energyLevel = energyLevel;
        this.laserPower = laserPower;
        this.operational = true;
        
        Random rand = new Random();
        this.level = rand.nextInt(5)+ 1; 
        this.experience = level * 50;      
        this.spaceCredits = level * 10;    
    }

    // Method to absorb damage
    public void absorbDamage(int damage) {
        energyLevel -= damage;
        System.out.println(species + " absorbs " + damage + " damage.");
        if (energyLevel <= 0) {
            energyLevel = 0;
            operational = false;
            System.out.println(species + " is no longer operational.");
        }
    }

    // Method to drop space credits
    public int dropSpaceCredits() {
        if (!operational) {
            System.out.println(species + " drops " + spaceCredits + " space credits.");
            return spaceCredits;
        }
        return 0;
    }

    // Method to grant experience when the alien will be  defeated
    public int grantExperience() {
        if (!operational) {
            System.out.println(species + " grants " + experience + " experience points.");
            return experience;
        }
        return 0;
    }

    public boolean isOperational() {
        return operational;
    }

    // Aliens status
    public void displayStatus() {
        System.out.println("Alien species: " + species);
        System.out.println("Level: " + level);
        System.out.println("Energy level: " + energyLevel);
        System.out.println("Laser power: " + laserPower);
        System.out.println("Operational: " + operational);
    }

    public int getLaserPower() {
        return level * 5;
    }
}
