package ic5junittest;

//Implemented by Ashabul Yeamin
//Ic5
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import ic5.Alien;

class AlienTestJunit {
//	//Test case 1 data 
//	String expectedSpecies = "Martian";
//	Alien myAlien = new Alien(expectedSpecies, 100, 50);
	//Test case 2 data 
	String expectedSpecies = "Zorgon";
	int expectedEnergyLevel = 100;
	Alien myAlien = new Alien(expectedSpecies, 100, 50);

	@Test
	void testGetAlienSpecies() {
		assertEquals(expectedSpecies, myAlien.getSpecies());
	}
	@Test
	void testGetAlienEnergyLevel() {
		assertEquals(expectedEnergyLevel, myAlien.getEnergyLevel());
	}

}
