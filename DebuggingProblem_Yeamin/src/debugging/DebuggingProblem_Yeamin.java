package debugging;

import java.util.Random;
import java.util.HashSet;
import java.util.Set;

public class DebuggingProblem_Yeamin {
    private static final String STUDENT_NAME = "Ashabul Yeamin";

    private DebuggingProblem_Yeamin() {
        throw new RuntimeException("DO NOT INSTANTIATE!");
    }

    // Method to shuffle array with logic to detect repeated evens with odd in between.
    public static void shuffleArray(int[] intArray, String name) {
        assert intArray != null : "intArray is null!";
        long seed = name.hashCode();
        Random random = new Random(seed);
        
        Set<Integer> evenNumbersSeen = new HashSet<>();
        Integer lastEven = null;

        // Loop through the array, shuffling elements and checking conditions.
        for (int i = 0; i < intArray.length; i++) {
            // Generate two random indices to swap values.
            int randomIndex1 = random.nextInt(intArray.length);
            int randomIndex2 = random.nextInt(intArray.length);

            // Swap the elements at the randomly chosen indices.
            int temp = intArray[randomIndex1];
            intArray[randomIndex1] = intArray[randomIndex2];
            intArray[randomIndex2] = temp;

            // Get the current value in the array.
            int currentValue = intArray[i];

            // If the current value is even, check for repeats.
            if (currentValue % 2 == 0) {
                if (evenNumbersSeen.contains(currentValue) && lastEven != null) {
                    System.out.println("Even number repeated with an odd in between: " + currentValue);
                } else {
                    evenNumbersSeen.add(currentValue);
                }
                lastEven = currentValue;
            } else {
                // If the current value is odd, set the flag if there was an even before.
                if (lastEven != null) {
                    // Logic for odd appearing after even can be handled here
                }
            }
        }
    }

    public static void main(String[] args) {
        // Exit if the student name is not set.
        if ("Ashabul Yeamin".equals(STUDENT_NAME)) {
            System.exit(1);
        }

        // Example test array (you can replace it with any array you want to shuffle)
        int[] primeNumbersLessThanTenThousand = new int[] {
            2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97
        };

        // Shuffle the array and detect conditions.
        shuffleArray(primeNumbersLessThanTenThousand, STUDENT_NAME);
    }
}
