package asg6;

//Asg 6 – COSC 2425-01 – Professor McCurry
//Implemented by - Ashabul Yeamin


//Fighter subclass
public class Fighter extends Spaceship {
 private int missileDamage;      
 private int missilesRemaining;  

 // Constructor 
 public Fighter(String name, int hullStrength, int shieldStrength, int missileDamage, int missilesRemaining) {
     super(name, hullStrength, shieldStrength);
     this.missileDamage = missileDamage;
     this.missilesRemaining = missilesRemaining;
 }

 // Override the primary weapon fire method with Fighter-specific behavior
 @Override
 public void fireWeapon(Spaceship target) {
     System.out.println(name + " fires primary weapon at " + target.name);
     target.takeDamage(10); 
 }

 // Method to launch a missile at a target if missiles are available
 public void launchMissile(Spaceship target) {
     if (missilesRemaining > 0) {
         System.out.println(name + " launches a missile at " + target.name);
         target.takeDamage(missileDamage); 
         missilesRemaining--;
     } else {
         System.out.println(name + " has no missiles left!");
     }
 }

 // Override toString
 @Override
 public String toString() {
     return "Fighter: " + name + " | Hull Strength: " + hullStrength + " | Shield Strength: " + shieldStrength + " | Missile Damage: " + missileDamage + " | Missiles Remaining: " + missilesRemaining;
 }
}
