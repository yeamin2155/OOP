package Basic; // Declares that this class is part of the 'Basic' package

import java.util.Scanner; // Imports the Scanner class for reading user input

public class Circle { // Defines a public class named 'Circle'
	
	public static void main(String[] args) { // Main method: the entry point of the program
		Scanner input = new Scanner(System.in); // Creates a Scanner object for reading input from the console
		
		double radius, area; // Declares variables for radius and area
		
		System.out.print("Enter radius: "); // Prompts the user to enter the radius
		radius = input.nextDouble(); // Reads the radius from user input
		
		area = 3.1416 * radius * radius; // Calculates the area of the circle
		System.out.println("Area of circle: " + area); // Prints the area to the console
		
		input.close(); // Closes the scanner to free resources
	}
}
