package Basic; // Declares that this class is part of the 'Basic' package

import java.util.Scanner; // Imports the Scanner class for reading user input

public class operations { // Defines a public class named 'operations'
	
	public static void main(String[] args) { // Main method: the entry point of the program
		 
		Scanner input = new Scanner(System.in); // Creates a Scanner object for reading input from the console
		int num1, num2, result; 
		
		System.out.print("Enter First Number: "); // Prompts the user to enter the first number
		num1 = input.nextInt(); // Reads the first number entered by the user and assigns it to num1
		
		System.out.println("Enter Second Number: "); // Prompts the user to enter the second number
		num2 = input.nextInt(); // Reads the second number entered by the user and assigns it to num2
		
		result = num1 + num2; // Calculates the sum of num1 and num2 and stores it in result
		System.out.println("Sum = " + result); // Prints the result to the console
	}
}
