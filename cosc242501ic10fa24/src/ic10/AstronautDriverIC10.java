package ic10;

public class AstronautDriverIC10 {
	
	public static void main(String[]args) {
		AstronautIC10 astronaut1 = new AstronautIC10("Jmaes T.Krik",100);
		AstronautIC10 astronaut2 = new AstronautIC10("Spock",100);
		AstronautIC10 astronaut3 = new AstronautIC10("Jmaes T.Krik",100);
		
		//Display the Astronauts
		System.out.println(astronaut1);
		System.out.println(astronaut2);
		System.out.println(astronaut3);
		
		
		//compare the astronaut 
		
		System.out.println("astronaut1 equals astronanut2: " + astronaut1.equals(astronaut2));
		System.out.println("astronaut1 equals astronanut3: " + astronaut1.equals(astronaut3));
	}

}
