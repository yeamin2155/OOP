package ic5;

public class Alien {
    // Fields
    private String species;
    private int energyLevel;
    private int laserPower;
    private int maxEnergy;
    //Added in IC 3
    private boolean operational = true;
    
    
    // Constructor 
    public Alien(String species, int energyLevel, int laserPower) {
        this.species = species;
        this.energyLevel = energyLevel;
        this.laserPower = laserPower;   
        this.operational = true; // Set operational to true when an Alien is created 
        this.maxEnergy = energyLevel;
    }
    
    // Getter methods
    
    public String getSpecies() {
        return species;
    }

    public int getEnergyLevel() { // Corrected method name capitalization
        return energyLevel;
    }
    
    public int getLaserPower() { // Corrected method name capitalization
        return laserPower;
    }
    
    
    //Added in IC 3
    public boolean isOperational() {
    	return operational;
    }
    
    
    // Setter methods
    public void setSpecies(String species) {
        this.species = species; // Corrected assignment to use the correct parameter
    }

    public void setLaserPower(int laserPower) { // Corrected method name capitalization
        this.laserPower = laserPower;
    }

    public void setEnergyLevel(int energyLevel) { // Corrected method name capitalization and method signature
        this.energyLevel = energyLevel;
    }
    
    // Additional method to display alien's status
    public void displayStatus() { // Added method definition to display status
        System.out.println("Alien species: " + species);
        System.out.println("Energy level: " + energyLevel);
        System.out.println("Laser Power: " + laserPower);
        System.out.println("Operational: "  + operational);
    }
    public void fireLaser() {
    	if (operational && energyLevel >= laserPower) {
    		energyLevel -= laserPower;
    		System.out.println(species+ "fire laser with Power: " +laserPower);
    	} else { 
    		System.out.println(species + "Can not fire laser. Not enough energy or It is not operational.");
    		
    	}
    	
    	
    }
  //Method absorb damage , reducing the energy level by the damage amount 
    public void absorbDamage(int damage) {
    	energyLevel -= damage;
    	System.out.println(species + " absorbs " +  damage+  " damage ");
    	if(energyLevel <= 0) {
    		energyLevel= 0;
    		operational = false;
    		System.out.println(species+ " is no longer operational.");
    	}
    	}
   
    // Overloaded method to absorb damage with a specific type of damage
    public void absorbDamage(int damage , String  damageType ) {
    	System.out.println( species  +  "  absorb   " + damage + "  " +  damageType  + " damage type  ");
    	absorbDamage(damage); //Reuse the original absorbDamage method 
    }
 	// Method that allows the Alien to regain some energy 
	public void heal (int heal) {
		if (energyLevel== 0) {
			System.out.println("Alien is dead");
		} else if(energyLevel + heal >= maxEnergy) {
			energyLevel = maxEnergy;
			System.out.println(" You healed " + heal + " Health . new Energy Level: "  + energyLevel);
			
		}
	}
	public void fireLaser(String laserType) {
		double energyCost = 0;
		double damagePotential = 0;
		
		switch (laserType.toLowerCase()) {
		case "plasma" :
			energyCost = 2 * laserPower;
			damagePotential = 2 * laserPower;
			break;
		case "ion" :
			energyCost = (int) (1.5*laserPower);
			damagePotential = (int)(1.2 * laserPower);
			break;
			default: //Default to the oriinal laser Type
				energyCost = laserPower ;
				damagePotential = laserPower ;
				break;
				
			
		}
		if (operational && energyLevel >= energyCost) {
			energyLevel -= energyCost;
			System.out.println(species+ "fires" + laserType + " laser with Power: " + damagePotential);
		}else {
			System.out.println( species + " can not fire " + laserType + "with laser Power" + damagePotential);
		}
	}
}