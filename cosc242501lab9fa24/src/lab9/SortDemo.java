package lab9;

//Lab 9 – COSC 2425-<Appropriate Section> – Professor McCurry
//Implemented by - Yeamin and Evan

import java.util.Arrays;
import java.util.Random;

public class SortDemo {

	public static void main(String[] args) {
		// Generate spaceships with random attributes
		// Execute test cases of 50, 500 and 5000 spaceships
		Spaceship[] fleet = generateFleet(50000);

		// Test sorting by speed, firepower, and hull integrity
		testSorting(fleet, "speed");
		testSorting(fleet, "firepower");
		testSorting(fleet, "hull");
	}

	// Function to generate an array of 50 Spaceships with random attributes
	public static Spaceship[] generateFleet(int size) {
		Spaceship[] fleet = new Spaceship[size];
		Random random = new Random();

		for (int i = 0; i < size; i++) {
			String id = "SS-" + (i + 1); // Unique ID
			int speed = random.nextInt(1500 - 500 + 1) + 500; // Speed between 500 and 1500
			int firepower = random.nextInt(100 - 20 + 1) + 20; // Firepower between 20 and 100
			int hullIntegrity = random.nextInt(100 - 50 + 1) + 50; // Hull integrity between 50 and 100

			fleet[i] = new Spaceship(id, speed, firepower, hullIntegrity);
		}

		return fleet;
	}

	// Test sorting on different attributes
	private static void testSorting(Spaceship[] fleet, String attribute) {
		System.out.println("\nSorting by " + attribute + "...");
		Spaceship[] arrBubble = Arrays.copyOf(fleet, fleet.length);
		Spaceship[] arrQuick = Arrays.copyOf(fleet, fleet.length);
		Spaceship[] arrMerge = Arrays.copyOf(fleet, fleet.length);

		// Bubble Sort
		int bubSortSteps = SortMethods.bubbleSort(arrBubble, attribute);
//		System.out.println("Array sorted using Bubble Sort: " + Arrays.toString(arrBubble));
		System.out.println("Bubble Sort Steps: " + bubSortSteps);

		// Quick Sort
		int quickSortSteps = SortMethods.quickSort(arrQuick, attribute);
//		System.out.println("Array sorted using Quick Sort: " + Arrays.toString(arrQuick));
		System.out.println("Quick Sort Steps: " + quickSortSteps);

		// Merge Sort
		int mergeSortSteps = SortMethods.countStepsToMergeSort(arrMerge, attribute);
//		System.out.println("Array sorted using Merge Sort: " + Arrays.toString(arrMerge));
		System.out.println("Merge Sort Steps: " + mergeSortSteps);
	}
}