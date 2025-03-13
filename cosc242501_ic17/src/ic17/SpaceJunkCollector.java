package ic17;

public class SpaceJunkCollector {
	
	// Recursive method to collect junk mass 
	public int collectJunk(int[] junkMasses, int index) {
		// Base Case
		if(index == junkMasses.length) {
			return 0;
		}
		
		// Print
		System.out.println("Collecting junk mass: " + junkMasses[index]);
		
		// Recursive call with correct syntax
		return junkMasses[index] + collectJunk(junkMasses, index + 1);
	}
}
