package lab9;

//Lab 9 – COSC 2425-<Appropriate Section> – Professor McCurry
//Implemented by - Yeamin and Evan

public class SortMethods {

	// Bubble Sort based on spaceship attribute
	public static int bubbleSort(Spaceship[] arr, String attribute) {
		int steps = 0;
		int n = arr.length;
		// Place an increment step counter in the correct place in the for loop
		for (int i = 0; i < n - 1; i++) {
			for (int j = 0; j < n - i - 1; j++) {
				if (compare(arr[j], arr[j + 1], attribute) > 0) {
					// Swap arr[j+1] and arr[j]
					steps +=1;
					Spaceship temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = temp;
				}
			}
		}
		return steps;
	}

	// Quick Sort based on spaceship attribute
	public static int quickSort(Spaceship[] arr, String attribute) {
		return quickSortHelper(arr, 0, arr.length - 1, 0, attribute);
	}

	private static int quickSortHelper(Spaceship[] arr, int low, int high, int steps, String attribute) {
		// Place an increment step counter in the correct place in the for loop
		if (low < high) {
			int pi = partition(arr, low, high, attribute);
			steps += 1; // Count partition operation
			steps = quickSortHelper(arr, low, pi - 1, steps, attribute);
			steps = quickSortHelper(arr, pi + 1, high, steps, attribute);
		}
		return steps;
	}

	private static int partition(Spaceship[] arr, int low, int high, String attribute) {
		Spaceship pivot = arr[high];
		int i = low - 1;
		for (int j = low; j < high; j++) {
			if (compare(arr[j], pivot, attribute) < 0) {
				i++;
				Spaceship temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;
			}
		}
		Spaceship temp = arr[i + 1];
		arr[i + 1] = arr[high];
		arr[high] = temp;
		return i + 1;
	}

	// Merge Sort based on spaceship attribute
	private static int mergeSort(Spaceship[] arr, Spaceship[] temp, int left, int right, String attribute) {
		int steps = 0;
		if (left < right) {
			int mid = (left + right) / 2;
			steps += mergeSort(arr, temp, left, mid, attribute);
			steps += mergeSort(arr, temp, mid + 1, right, attribute);
			steps += merge(arr, temp, left, mid, right, attribute);
		}
		return steps;
	}

	private static int merge(Spaceship[] arr, Spaceship[] temp, int left, int mid, int right, String attribute) {
		int steps = 0;
		int i = left;
		int j = mid + 1;
		int k = left;
		// Place an increment step counter in the correct place in the for loop
		while (i <= mid && j <= right) {
			if (compare(arr[i], arr[j], attribute) <= 0) {
				temp[k++] = arr[i++];
			} else {
				temp[k++] = arr[j++];
				steps +=1;
				
			}
		}

		while (i <= mid) {
			temp[k++] = arr[i++];
		}

		while (j <= right) {
			temp[k++] = arr[j++];
		}

		for (i = left; i <= right; i++) {
			arr[i] = temp[i];
		}

		return steps;
	}

	public static int countStepsToMergeSort(Spaceship[] arr, String attribute) {
		Spaceship[] temp = new Spaceship[arr.length];
		return mergeSort(arr, temp, 0, arr.length - 1, attribute);
	}

	// Helper method to compare two spaceships based on a given attribute
	private static int compare(Spaceship s1, Spaceship s2, String attribute) {
		switch (attribute.toLowerCase()) {
		case "speed":
			return Integer.compare(s1.getSpeed(), s2.getSpeed());
		case "firepower":
			return Integer.compare(s1.getFirepower(), s2.getFirepower());
		case "hull":
			return Integer.compare(s1.getHullIntegrity(), s2.getHullIntegrity());
		default:
			throw new IllegalArgumentException("Unknown attribute: " + attribute);
		}
	}
}
