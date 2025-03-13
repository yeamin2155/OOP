package asg2;

public class Astronaut {
    private String name;
    private int health;
    private int laserPower;
    private int rank;
    private int experience;
    private int spaceCredits;

    public Astronaut(String name, int health, int laserPower) {
        this.name = name;
        this.health = health;
        this.laserPower = laserPower;
        this.rank = 1;           
        this.experience = 0;     
        this.spaceCredits = 0;   
    }

    // Getter and setter methods
    public String getName() {
        return name;
    }

    public int getHealth() {
        return health;
    }

    public int getLaserPower() {
        return laserPower;
    }

    public int getRank() {
        return rank;
    }

    public int getExperience() {
        return experience;
    }

    public int getSpaceCredits() {
        return spaceCredits;
    }

    // Adjust astronaut's health
    public void adjustHealth(int amount) {
        health += amount;
        if (health < 0) {
            health = 0;
        }
    }

    //Method for accumulate experience
    public void accumulateExperience(int exp) {
        experience += exp;
        promoteIfNeeded();
    }

    //Method for accumulate space credits
    public void accumulateCredits(int credits) {
        spaceCredits += credits;
    }

    //Promote astronaut if experience crosses 500 points
    private void promoteIfNeeded() {
        if (experience >= 500) {
            rank++;
            experience = 0; // Reset experience after promotion
            System.out.println(name + " has been promoted to Rank " + rank + "!");
        }
    }

    //Check if astronaut is still breathing
    public boolean isStillBreathing() {
        return health > 0;
    }

    public void displayStatus() {
        System.out.println("Astronaut: " + name);
        System.out.println("Health: " + health);
        System.out.println("Laser Power: " + laserPower);
        System.out.println("Rank: " + rank);
        System.out.println("Experience: " + experience);
        System.out.println("Space Credits: " + spaceCredits);
    }
}
