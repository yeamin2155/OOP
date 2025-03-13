package ic18;

import java.util.ArrayList;
import java.util.List;

public class GalacticExplorationGame {

    public static void main(String[] args) {
        // Create a list of missions
        List<Mission> missions = new ArrayList<>();
        missions.add(new Mission("Explore Nebula 9", 15));
        missions.add(new Mission("Survey Planet X", 5));
        missions.add(new Mission("Mine Asteroid Belt", 25));
        missions.add(new Mission("Investigate Space Anomaly", 10));
        missions.add(new Mission("Map Gamma Quadrant", 20));

        // Bubble Sort Test
        List<Mission> bubbleSortedMissions = new ArrayList<>(missions);
        //GalacticSorting.bubbleSort(bubbleSortedMissions);
        GalacticSorting.SortResult bubbleResult = GalacticSorting.bubbleSort(bubbleSortedMissions);
        System.out.println("Missions sorted by Bubble Sort:");
        bubbleSortedMissions.forEach(System.out::println);
        System.out.println("Bubble Sort - Time taken: " + bubbleResult.timeTaken + " ns");


        // Quick Sort Test
        List<Mission> quickSortedMissions = new ArrayList<>(missions);
        //GalacticSorting.quickSort(quickSortedMissions);
        GalacticSorting.SortResult quickResult = GalacticSorting.quickSort(quickSortedMissions);
        System.out.println("\nMissions sorted by Quick Sort:");
        quickSortedMissions.forEach(System.out::println);
        System.out.println("Quick Sort - Time taken: " + quickResult.timeTaken + " ns");

    }
}

