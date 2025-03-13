package asg2Test;  

import asg2.Alien;  

public class Alientest {
    public static void main(String[] args) {
        
        Alien alien1 = new Alien("martin", 100, 50);
        
        // Display the Alien's status
        alien1.displayStatus();
        
        // Test firing the laser
        alien1.fireLaser();
        alien1.displayStatus(); // Display updated status after firing the laser
        
        // Test the absorbing damage
        alien1.absorbDamage(30);
        alien1.displayStatus(); 
        
        // Test the absorbing damage with damage type
        alien1.absorbDamage(50, "Plasma");
        alien1.displayStatus(); 
        
        // Test the healing the alien
        alien1.healDamage(10);
        alien1.displayStatus(); // Display status after healing
    }
}

