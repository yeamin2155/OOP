package ic18;

import java.util.List;

public class GalacticSorting {

	public static class SortResult{
		long timeTaken; //nanoseconds
		int steps; // number of steps taken in the algorithm
		
		public SortResult(long timeTaken, int steps) {
			this.timeTaken = timeTaken;
			this.steps = steps;
		}
	}
	
    // Bubble Sort (add timer and step counter as needed)
    public static SortResult bubbleSort(List<Mission> missions) {

    	//start timer here (long startTime = System.nanoTime();
    	//initialize step counter here
    	
    	int steps = 0;
    	long startTime = System.nanoTime();
    	

        int n = missions.size();
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {

                if (missions.get(j).getCompletionTime() > missions.get(j + 1).getCompletionTime()) {
                    Mission temp = missions.get(j);
                    missions.set(j, missions.get(j + 1));
                    missions.set(j + 1, temp);

                }
            }
        }
        long endTime = System.nanoTime();
        return new SortResult(endTime - startTime, steps);

    }

    // Quick Sort (add timer and step counter as needed)
    public static SortResult quickSort(List<Mission> missions) {
    	long startTime = System.nanoTime();
    	int[] steps = {0};
        
        quickSortHelper(missions, 0, missions.size() - 1, null); // Pass step counter if needed
        long endTime = System.nanoTime();
        return new SortResult(endTime - startTime, steps[0]);

    }

    private static void quickSortHelper(List<Mission> missions, int low, int high, int[] steps) {
        if (low < high) {
            int pivotIndex = partition(missions, low, high, steps);
            quickSortHelper(missions, low, pivotIndex - 1, steps);
            quickSortHelper(missions, pivotIndex + 1, high, steps);
        }
    }

    private static int partition(List<Mission> missions, int low, int high, int[] steps) {
        Mission pivot = missions.get(high);
        int i = low - 1;

        for (int j = low; j < high; j++) {

            if (missions.get(j).getCompletionTime() <= pivot.getCompletionTime()) {
                i++;
                Mission temp = missions.get(i);
                missions.set(i, missions.get(j));
                missions.set(j, temp);

            }
        }

        Mission temp = missions.get(i + 1);
        missions.set(i + 1, missions.get(high));
        missions.set(high, temp);


        return i + 1;
    }
}

