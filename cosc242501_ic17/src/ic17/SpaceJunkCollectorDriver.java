package ic17;

public class SpaceJunkCollectorDriver {
	
	public static void main(String[] args) {
		// Example array of space junk masses
		int[] junkMasses = {12, 5, 7, 20};
		
		// Two additional data sets
		int[] junkMasses10 = {3, 8, 12, 5, 17, 2, 9, 15, 4, 1}; 
		int[] junkMasses100 = {
			5, 83, 12, 65, 37, 21, 99, 55, 42, 18, 
			76, 23, 91, 48, 6, 89, 33, 7, 59, 14, 
			92, 4, 73, 29, 85, 19, 66, 43, 98, 54, 
			11, 77, 24, 90, 47, 5, 88, 32, 6, 58, 
			13, 93, 41, 72, 28, 84, 18, 65, 42, 97, 
			53, 10, 76, 23, 91, 48, 6, 89, 33, 7, 
			59, 14, 92, 4, 73, 29, 85, 19, 66, 43, 
			98, 54, 11, 77, 24, 90, 47, 5, 88, 32, 
			6, 58, 13, 93, 41, 72, 28, 84, 18, 65, 
			42, 97, 53, 10, 76, 23, 91, 48, 6, 89
		}; 
		
		// Create an instance of SpaceJunkCollector
		SpaceJunkCollector collector = new SpaceJunkCollector();
		
		// Call the recursive method to collect junk mass
		int totalMass = collector.collectJunk(junkMasses10, 0);
		
		// Output the total mass of collected space junk
		System.out.println("Total mass of collected space junk: " + totalMass);
	}
}

