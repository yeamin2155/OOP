package lab2a;

public class Alien {
    // Fields
    private String species;
    private int energyLevel;
    private int laserPower;
    // Added in IC 3
    private boolean operational;

    // Constructor
    public Alien(String species, int energyLevel, int laserPower) {
        this.species = species;
        this.energyLevel = energyLevel;
        this.laserPower = laserPower;
        this.operational = true; // Set operational to true when an Alien is created
    }

    // Getter methods
    public String getSpecies() {
        return species;
    }

    public int getEnergyLevel() {
        return energyLevel;
    }

    public int getLaserPower() {
        return laserPower;
    }

    // Added in IC 3
    public boolean isOperational() {
        return operational;
    }

    // Additional method to display Alien's status
    public void displayStatus() {
        System.out.println("Alien species: " + species);
        System.out.println("Energy level: " + energyLevel);
        System.out.println("Laser power: " + laserPower);
        // Added in IC 3
        System.out.println("Operational: " + operational);
    }

    // Setter methods
    public void setSpecies(String species) {
        this.species = species;
    }

    public void fireLaser() {
        if (operational && energyLevel >= laserPower) {
            energyLevel -= laserPower;
            System.out.println(species + " fires laser with power: " + laserPower);
        } else {
            System.out.println(species + " cannot fire laser. Not enough energy or is not operational.");
        }
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
            
     // overloaded method to absorb damage 
            public void absorbDamage(int damage, String damageType)
            {
            	System.out.println(species + "absorbs" + damage + " " + damageType +" DamageType.");
            	absorbDamage(damage);
            }
            
        //Alien Enhancement Number 2: 
            
            public void fireLaser(String laserType) {
            double energyCost = 0;
            double damagePotential = 0;
            	
            	switch (laserType.toLowerCase()) {
            	case "plasma":
            		energyCost = 2 *laserPower;
            		damagePotential = 2 * laserPower;
            		break;
            	case "ion":
            		energyCost = 1.5 * laserPower;
            		damagePotential = 1.2 * laserPower;
            		break;
            	}
            	
            	if (operational && energyLevel >= energyCost) {
            		energyLevel -= energyCost;
            		System.out.println(species + " fires " + laserType + "laser with power: " + 
            		damagePotential);
            		
            	} else {
            		System.out.println(species + "cannot fires " + laserType + "laser. Not enough energy or.");
            		
            	
            	}
            }
            
            
            public void healDamage(int health) {
                energyLevel -= health;
                System.out.println(species + " has healed " + health + " points.");

                if (energyLevel <= 0) {
                    energyLevel = 0;
                    operational = false;
                    System.out.println(species + " is no longer operational.");
                    
                 if (energyLevel == 100) {
                     energyLevel = 100;
                     operational = false;
                     System.out.println(species + " is already healed.");
                 }
                }
            }
}
            
            
