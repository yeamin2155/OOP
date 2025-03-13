package ic5test;

import ic5.Alien;

public class AlienTest {
	public static void main(String[] args) {
		Alien alien1 = new Alien ("Martian", 100, 50);
		
		
		//Display the Alien's status
		
		alien1.displayStatus();
		// Added in IC 3
	
		//Test firing the laser 
		alien1.fireLaser();
		alien1.displayStatus();
		
		
	    alien1.absorbDamage(50  , "plasma");
	     alien1.displayStatus();
	     alien1.heal(40);
	     alien1.displayStatus();
		}
	
	
	}